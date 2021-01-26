package com.epam.jwd_online_book_store.controller.command.impl;

import com.epam.jwd_online_book_store.controller.command.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RequestContextImpl implements RequestContext {

    private HttpServletRequest httpServletRequest;

    public RequestContextImpl(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public List<String> getParameters() {
        return null;
    }

    @Override
    public String getParameter(String parameter) {
        return httpServletRequest.getParameter(parameter);
    }

    @Override
    public String getRequestMethod() {
        return httpServletRequest.getMethod();
    }

    @Override
    public void setAttribute(String name, Object o) {
        httpServletRequest.setAttribute(name, o);
    }

    @Override
    public HttpSession getSession() {
        return httpServletRequest.getSession();
    }

    @Override
    public Object getAttributes(String name) {
       return httpServletRequest.getAttribute(name);
    }
}
