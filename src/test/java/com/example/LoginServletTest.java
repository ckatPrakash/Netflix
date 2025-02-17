package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoginServletTest {

    private LoginServlet loginServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    public void setUp() {
        loginServlet = new LoginServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        when(request.getRequestDispatcher("/WEB-INF/login.jsp")).thenReturn(requestDispatcher);
        loginServlet.doGet(request, response);
        verify(request).getRequestDispatcher("/WEB-INF/login.jsp");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostValidCredentials() throws ServletException, IOException {
        when(request.getParameter("email")).thenReturn("user@example.com");
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getParameter("rememberMe")).thenReturn("on");

        loginServlet.doPost(request, response);
        verify(response).sendRedirect("success.jsp");
    }

    @Test
    public void testDoPostInvalidCredentials() throws ServletException, IOException {
        when(request.getParameter("email")).thenReturn("invalid@example.com");
        when(request.getParameter("password")).thenReturn("wrongpassword");
        when(request.getRequestDispatcher("/WEB-INF/login.jsp")).thenReturn(requestDispatcher);

        loginServlet.doPost(request, response);
        verify(request).setAttribute("errorMessage", "Invalid email or password");
        verify(requestDispatcher).forward(request, response);
    }
}