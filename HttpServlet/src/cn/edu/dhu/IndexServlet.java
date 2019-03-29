package cn.edu.dhu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String html="";
        HttpSession session = request.getSession(false);
        if (null==session){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return;
        }

        String  loginName = (String) session.getAttribute("loginName");
        if (null==loginName){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return;
        }
        html="<html><body>欢迎回来，"+loginName+"，<a href='"+request.getContextPath()+"/logoutpage'>安全退出</a></body></html>";
        writer.write(html);

    }
}
