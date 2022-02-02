package com.gmail.grechich;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = {"/my-servlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello from servlet!!!");

        resp.getWriter().println(parseParametrs(req.getParameterMap()));
    }

    private String parseParametrs(Map<String, String[]> parameters){
        String rez = "";
        for (Map.Entry<String, String[]> e : parameters.entrySet()) {
            rez += ("\n" + e.getKey() + " => ");
            for (int i = 0; i < e.getValue().length; i++) {
                rez += e.getValue()[i];
                if (e.getValue().length > i + 1)
                    rez += "and " + e.getKey() + " => ";
            }
        }
        return rez;
    }

//    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(parseParametrs(req.getParameterMap()));

    }
}
