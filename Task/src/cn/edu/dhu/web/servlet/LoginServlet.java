package cn.edu.dhu.web.servlet;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*手动获取对象
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        User loginUser=new User();
        loginUser.setUserName(userName);
        loginUser.setPassword(password);*/
        Map<String,String[]> map=request.getParameterMap();
        User loginUser=new User();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDAO userDAO=new UserDAOImpl();
        User user = userDAO.login(loginUser);
        if (null == user){
//            request.getRequestDispatcher("/failServlet").forward(request,response);//转发
//            response.getWriter().print("<script> alert(\"请确认您的账号密码!\"); </script>");
            response.getWriter().write("<script> alert(\"请确认您的账号密码!\"); </script>");
        }else {
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}