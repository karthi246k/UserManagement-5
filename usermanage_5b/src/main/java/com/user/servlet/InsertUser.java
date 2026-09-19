package com.user.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.user.client.UserApiClient;
import com.user.model.Address;
import com.user.model.User;

public class InsertUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("insert.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            Address homeAddress = new Address();

            homeAddress.setStreetAddress(
                    request.getParameter("homeStreetAddress"));

            homeAddress.setCity(
                    request.getParameter("homeCity"));

            homeAddress.setState(
                    request.getParameter("homeState"));

            homeAddress.setZipCode(
                    request.getParameter("homeZipCode"));

            Address officeAddress = new Address();

            officeAddress.setStreetAddress(
                    request.getParameter("officeStreetAddress"));

            officeAddress.setCity(
                    request.getParameter("officeCity"));

            officeAddress.setState(
                    request.getParameter("officeState"));

            officeAddress.setZipCode(
                    request.getParameter("officeZipCode"));

            User user = new User();

            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setHomeAddress(homeAddress);
            user.setOfficeAddress(officeAddress);

            UserApiClient.insertUser(user);

            request.setAttribute("insertSuccess", true);

            request.getRequestDispatcher("insert.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "insertError",
                    "Unable to add the user. Please try again."
            );

            request.getRequestDispatcher("insert.jsp")
                   .forward(request, response);
        }
    }
}