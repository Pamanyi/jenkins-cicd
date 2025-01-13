package com.jjtech;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeServletTest {

    private WelcomeServlet welcomeServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @BeforeEach
    public void setUp() throws Exception {
        welcomeServlet = new WelcomeServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        responseWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testDoGet() throws Exception {
        welcomeServlet.doGet(request, response);
        verify(response).setContentType("text/html");
        assertEquals("<h1>Good job team! We made it work, we are officially Devops Engineer! go team!</h1>", responseWriter.toString().trim());
    }
}
