package pojo;

/**
 * Created by barryfan on 6/17/19.
 */
public class RequestContent {

    private String uri;
    private String method;
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public RequestContent setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }


    public String getUri() {
        return uri;
    }

    public RequestContent setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RequestContent setMethod(String method) {
        this.method = method;
        return this;
    }
}
