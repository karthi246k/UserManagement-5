package com.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.user.client.UserApiClient;
import com.user.model.User;

public class FindUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String searchType =
                request.getParameter("searchType");

        String value;

        if ("id".equals(searchType)) {

            value = request.getParameter("id");

        } else if ("username".equals(searchType)) {

            value = request.getParameter("username");

        } else {

            request.getRequestDispatcher("find.jsp")
                   .forward(request, response);

            return;
        }

        if (value == null || value.trim().isEmpty()) {

            request.getRequestDispatcher("find.jsp")
                   .forward(request, response);

            return;
        }

        User user =
                UserApiClient.findUser(searchType, value);

        request.setAttribute("user", user);

        request.getRequestDispatcher("find.jsp")
               .forward(request, response);
    }
}