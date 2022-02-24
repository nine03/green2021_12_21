package org.comstudy21.myapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.HandlerMapping;

public class DispatcherServlet extends HttpServlet {
   public String prefix = "/WEB-INF/views/";
   public String suffix = ".jsp";
   public String viewName = "";
   public HandlerMapping handlerMapping = new HandlerMapping();

   protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html; charset=UTF-8");
      
      String ctxPath = req.getContextPath();
      String reqUri = req.getRequestURI();
      int beginIndex = ctxPath.length();
      int endIndex = reqUri.lastIndexOf(".");
      String path = reqUri.substring(beginIndex, endIndex);
      endIndex = path.lastIndexOf("/");
      String dirPath = endIndex == 0 ? "/home" : path.substring(0, endIndex);
      
      Controller controller = handlerMapping.getController(path);
      viewName = controller.action(req, resp);
      
      req.setAttribute("path", path);
      
      // forward하기
      RequestDispatcher view = req.getRequestDispatcher(prefix+viewName+suffix);
      view.forward(req, resp);
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      process(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      process(req, resp);
   }

   @Override
   public void destroy() {
      System.out.println("destroy - DispatcherServlet");
   }

   @Override
   public void init() throws ServletException {
      System.out.println("init - DispatcherServlet");
   }
   
}