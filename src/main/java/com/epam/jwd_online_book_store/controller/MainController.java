package com.epam.jwd_online_book_store.controller;

import com.epam.jwd_online_book_store.controller.command.Command;
import com.epam.jwd_online_book_store.controller.command.ResponseContext;
import com.epam.jwd_online_book_store.controller.command.factory.CommandFactory;
import com.epam.jwd_online_book_store.controller.command.impl.RequestContextImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.getCommand(request.getParameter("command").trim());
        ResponseContext context = command.execute(new RequestContextImpl(request));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(context.getPage());
        if (context.getResponseType() == ResponseContext.ResponseType.REDIRECT) {
            response.sendRedirect(context.getPage());
        } else if (context.getResponseType() == ResponseContext.ResponseType.FORWARD){
            requestDispatcher.forward(request, response);
        }
    }
}
