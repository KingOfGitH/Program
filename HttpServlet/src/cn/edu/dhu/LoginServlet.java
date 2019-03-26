package cn.edu.dhu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //1、接收参数、
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //2、判断逻辑
        if ("zhbr".equals(userName)&&"123456".equals(userPwd)){
            HttpSession session = request.getSession();
            session.setAttribute("loginName",userName);
            String contextPath = request.getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(request.getContextPath()+"/indexpage");
        }else {
            response.sendRedirect(request.getContextPath()+"/fail.html");
        }
    }
}
