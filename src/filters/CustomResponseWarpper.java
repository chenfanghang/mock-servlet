package filters;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by barryfan on 6/19/19.
 */
public class CustomResponseWarpper extends HttpServletResponseWrapper {

    private int status;

    private int OK = 200;
    private int NOTFOUND = 404;

    public CustomResponseWarpper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {

        this.status = sc;
        // 只有发生404错误时，才认为该请求是正常请求(200状态)，其它错误全部交由父类
        // 自己处理
        if (status != NOTFOUND) {
            super.sendError(sc, msg);
        } else {
            super.setStatus(OK);
        }
    }

    @Override
    public void sendError(int sc) throws IOException {
        this.status = sc;
        // 只有发生404错误时，才认为该请求是正常请求(200状态)，其它错误全部交由父类
        // 自己处理
        if (status != NOTFOUND) {
            super.sendError(sc);
        } else {
            super.setStatus(OK);
        }
    }

    // 代表资源存在
    public boolean isFound() {
        return status != NOTFOUND;
    }
}
