package cn.edu.dhu.web.servlet;

import cn.edu.dhu.beans.Page;
import cn.edu.dhu.beans.User;
import cn.edu.dhu.service.UserService;
import cn.edu.dhu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhbr
 * @date 2019/4/6 15:21
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (null==currentPage||"".equals(currentPage)){
            currentPage="1";
        }
        if (null==rows||"".equals(rows)){
            rows="5";
        }

//        获取所有参数，包含上面的两个参数以及查询条件
        Map<String, String[]> contion = request.getParameterMap();

        UserService userService=new UserServiceImpl();
        Page<User> page=userService.findUserByPage(currentPage,rows,contion);


        request.setAttribute("page",page);
        request.setAttribute("contion",contion);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
