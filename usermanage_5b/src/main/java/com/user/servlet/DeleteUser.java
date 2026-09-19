package com.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.user.client.UserApiClient;
import com.user.model.User;

public class DeleteUser extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(
                    request.getParameter("id")
            );

            User user = UserApiClient.deleteUser(userId);

            if (user != null) {

                request.setAttribute("deleteSuccess", true);

            } else {

                request.setAttribute(
                        "deleteError",
                        "User not found."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "deleteError",
                    "Unable to delete the user. Please try again."
            );
        }

        request.setAttribute(
                "users",
                UserApiClient.listUsers()
        );

        request.getRequestDispatcher("list.jsp")
               .forward(request, response);
    }
}