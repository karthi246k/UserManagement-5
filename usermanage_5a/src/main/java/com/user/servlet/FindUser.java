package com.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.user.client.UserWebServiceClient;
import com.user.model.*;

public class FindUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter == null || idParameter.trim().isEmpty()) {

            request.getRequestDispatcher("find.jsp")
                   .forward(request, response);

            return;
        }

        int userId = Integer.parseInt(idParameter);

        User user = UserWebServiceClient.findUser(userId);

        request.setAttribute("user", user);

        request.getRequestDispatcher("find.jsp")
               .forward(request, response);
    }
}