package cn.edu.dhu.web.servlet;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.service.UserService;
import cn.edu.dhu.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author zhbr
 * @date 2019/4/5 14:02
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String,String[]> map=request.getParameterMap();
//        for (String[] value : map.values()) {
//            System.out.println("Value = " + value[0]);
//        }

        User registerUser=new User();
        try {
            BeanUtils.populate(registerUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService=new UserServiceImpl();
        if (userService.find(registerUser.getUserName())==null){
            userService.register(registerUser);
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else {
//            request.setAttribute("registerUser",registerUser);
            request.setAttribute("register_msg","用户名已存在！请重试！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);//转发
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
