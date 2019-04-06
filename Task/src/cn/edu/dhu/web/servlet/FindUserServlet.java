package cn.edu.dhu.web.servlet;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.service.UserService;
import cn.edu.dhu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhbr
 * @date 2019/4/5 18:44
 * 在更新时，根据userName查找数据进行数据回显功能
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        UserService userService=new UserServiceImpl();
        User user = userService.find(userName);
        request.setAttribute("user",user);

        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
