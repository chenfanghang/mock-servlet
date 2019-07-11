package filters;

import pojo.MockContent;
import service.MockService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by barryfan on 6/17/19.
 */
@WebFilter(filterName = "MockFilter", urlPatterns = "/*")
public class MockFilter implements Filter {

    private MockService mockService = new MockService();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req == null || !(req instanceof HttpServletRequest)
                || resp == null || !(resp instanceof HttpServletResponse)) {
            throw new IllegalStateException("仅支持http协议");
        }

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) req;
        HttpServletResponse httpServletResponse =
                (HttpServletResponse) resp;

        CustomResponseWarpper customResponseWarpper = new CustomResponseWarpper(httpServletResponse);

        // 为了解决乱码
        httpServletResponse.setContentType("text/html;charset=utf-8");

        // httpServletResponse.sendRedirect();
        // 项目自身的资源交由tomcat处理


        // 如果说现在请求了一个不存在的资源，那么tomcat服务器会做两件事
        // 第一件事setStatus = 404, 第二件事sendError(404), 当调用
        // sendError方法时
        // response的状态会被置为已提交状态，这时不允许再手动调用sendError方法
        // 但是根据我们实现mock平台的方式来看，我们必须要重置status状态的
        // 但是serlvet2.5之后影响status状态的还有sendError，所以也要重置
        // sendError

        // 这时就要拦截tomcat服务器在发生404错误时，禁止sendError的行为，
        // 并且将status的状态设置为200
        chain.doFilter(req, customResponseWarpper);

        // 当资源找到后立即返回，不管是200还是500....., 只要不是404
        if (customResponseWarpper.isFound()) {
            return;
        }

        // 访问login.jsp不存在于项目资源中，所以返回404
        System.out.println(httpServletResponse.getStatus()); //404
        // 如果资源不存在，服务器将状态置为404, 我通过过滤器在mockdata库中进行一次
        // 筛选，如果筛选到了，返回mock数据的返回值，并且要将状态改200，如果依然没有，返回null，

        String key = httpServletRequest.getRequestURI().concat("-").
                concat(httpServletRequest.getMethod().toUpperCase());
        MockContent mockContent = mockService.getMockData(key);
        if (mockContent != null) {
            System.out.println(11111);
            httpServletResponse.setContentType(mockContent.getResponseContent().getContentType());
            httpServletResponse.getWriter().print(mockContent.getResponseContent().getText());
        } else {
            httpServletResponse.sendError(404);
            httpServletResponse.setStatus(404);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
