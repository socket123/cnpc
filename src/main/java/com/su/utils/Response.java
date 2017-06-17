/**
 * Project Name:springlearn
 * File Name:Response.java
 * Package Name:com.vrvutil.http
 * Date:2016�?1�?22日下�?3:23:01
 * Copyright (c) 2016, jingshouyan@126.com All Rights Reserved.
 *
 */

package com.su.utils;

import java.util.Map;

/**
 * ClassName:Response <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016�?1�?22�? 下午3:23:01 <br/>
 *
 * @author bxy-jing
 * @see
 * @since JDK 1.6
 */
public class Response {
    private int statusCode;
    private String reasonPhrase;
    private String body;
    private Map<String, String> headers;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }
}
