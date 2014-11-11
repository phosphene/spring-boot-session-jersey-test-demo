package com.phosphene.rest.config;

import org.springframework.session.web.http.HeaderHttpSessionStrategy;

public class CustomHeaderHttpSessionStrategy extends HeaderHttpSessionStrategy {


    private String headerName = "RadiusAuth";


    public String getHeaderName(){
        return this.headerName;
    }

}
