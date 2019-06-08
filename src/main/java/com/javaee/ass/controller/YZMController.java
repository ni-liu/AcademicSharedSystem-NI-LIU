package com.javaee.ass.controller;

import com.javaee.ass.utils.DrawYzm;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@WebServlet("/yzmServlet")
public class YZMController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DrawYzm drawYzm=new DrawYzm();
        drawYzm.getCode(request,response);
        request.setAttribute("yzm",drawYzm);
        request.getRequestDispatcher("yzmimg").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
