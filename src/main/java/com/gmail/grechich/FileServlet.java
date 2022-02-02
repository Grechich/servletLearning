package com.gmail.grechich;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/file-servlet"})
@MultipartConfig(location = "C:\\Users\\ogmet11\\IdeaProjects\\servletLearning\\src\\main")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if (part.getName().equals("author")) {
                InputStream inputStream = part.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String author = bufferedReader.lines().collect(Collectors.joining("\n"));
                System.out.println(author);
            } else {
                part.write(UUID.randomUUID() + part.getSubmittedFileName());
            }
        }
        resp.sendRedirect("/");
    }
}
