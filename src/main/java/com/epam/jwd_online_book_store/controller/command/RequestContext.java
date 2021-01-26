package com.epam.jwd_online_book_store.controller.command;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface RequestContext {

    List<String> getParameters();

    String getParameter(String parameter);

    String getRequestMethod();

    void setAttribute(String name, Object o);

    HttpSession getSession();

    Object getAttributes(String name);
}
