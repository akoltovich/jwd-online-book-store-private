package com.epam.jwd_online_book_store.filter;

import com.epam.jwd_online_book_store.filter.xss.XSSHttpServletRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/home")
public class XSSFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XSSHttpServletRequestWrapper((HttpServletRequest) req), res);
    }
}
