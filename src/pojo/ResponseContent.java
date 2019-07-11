package pojo;

import utils.StringUtils;

/**
 * Created by barryfan on 6/17/19.
 */
public class ResponseContent {

    private String contentType;

    private String text;

    public String getText() {
        return text;
    }

    public ResponseContent setText(String text) {
        this.text = text;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public ResponseContent setContentType(String contentType) {
        if (StringUtils.isNull(contentType)) {
            contentType = "text/html;charset=utf-8";
        }
        this.contentType = contentType;
        return this;
    }

}
