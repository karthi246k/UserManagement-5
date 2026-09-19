package com.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.user.client.UserWebServiceClient;
import com.user.model.*;

public class UpdateUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(request.getParameter("id"));

            User user = UserWebServiceClient.findUser(userId);

            if (user != null) {

                request.setAttribute("user", user);

                request.getRequestDispatcher("update.jsp")
                       .forward(request, response);

            } else {

                response.sendRedirect("list");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("list");
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(request.getParameter("id"));

            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            String homeStreetAddress =
                    request.getParameter("homeStreetAddress");

            String homeCity =
                    request.getParameter("homeCity");

            String homeState =
                    request.getParameter("homeState");

            String homeZipCode =
                    request.getParameter("homeZipCode");

            String officeStreetAddress =
                    request.getParameter("officeStreetAddress");

            String officeCity =
                    request.getParameter("officeCity");

            String officeState =
                    request.getParameter("officeState");

            String officeZipCode =
                    request.getParameter("officeZipCode");

            User user = UserWebServiceClient.findUser(userId);

            if (user != null) {

                user.setName(name);
                user.setPhone(phone);
                user.setEmail(email);

                Address homeAddress = user.getHomeAddress();

                if (homeAddress != null) {

                    homeAddress.setStreetAddress(homeStreetAddress);
                    homeAddress.setCity(homeCity);
                    homeAddress.setState(homeState);
                    homeAddress.setZipCode(homeZipCode);
                }

                Address officeAddress = user.getOfficeAddress();

                if (officeAddress != null) {

                    officeAddress.setStreetAddress(officeStreetAddress);
                    officeAddress.setCity(officeCity);
                    officeAddress.setState(officeState);
                    officeAddress.setZipCode(officeZipCode);
                }

                UserWebServiceClient.updateUser(user);

                request.setAttribute("updateSuccess", true);
                request.setAttribute("user", user);

            } else {

                request.setAttribute("updateError", "User not found.");
            }

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "updateError",
                    "Unable to update the user. Please try again."
            );

            try {

                int userId =
                        Integer.parseInt(request.getParameter("id"));

                User user =
                        UserWebServiceClient.findUser(userId);

                request.setAttribute("user", user);

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }

        request.getRequestDispatcher("update.jsp")
               .forward(request, response);
    }
}