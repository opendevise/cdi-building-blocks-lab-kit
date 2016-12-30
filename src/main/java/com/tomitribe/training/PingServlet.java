package com.tomitribe.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public @WebServlet("/ping") class PingServlet extends HttpServlet {
     @Override protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
            throws ServletException, IOException {
        rsp.setStatus(200);
        rsp.setContentType("text/plain");
        rsp.setCharacterEncoding("UTF-8");
        rsp.getWriter().write("here");
    }
}
