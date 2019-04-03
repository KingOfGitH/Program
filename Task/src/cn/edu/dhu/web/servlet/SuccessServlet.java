package cn.edu.dhu.web.servlet;

import cn.edu.dhu.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user= (User) request.getAttribute("user");
        if (null!=user){
            response.getWriter().write("<h1>登陆成功！用户"+user.getUserName()+"，欢迎您！</h1>");
            boolean flag=true;
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(
                    "yyyy年MM月dd日 HH:mm:ss:SSS");
            String str_date=simpleDateFormat.format(date);
            //URL编码
            str_date= URLEncoder.encode(str_date,"utf-8");

            Cookie[] cookies = request.getCookies();
            if (null!=cookies && 0<cookies.length){
                for (Cookie cookie:cookies){
                    String name=cookie.getName();
                    if ("lastTime".equals(name)){
                        flag=false;
                        String lastTime=cookie.getValue();
                        cookie.setValue(str_date);
                        cookie.setMaxAge(60*60*24*30);
                        response.addCookie(cookie);
                        //URL解码
                        lastTime= URLDecoder.decode(lastTime,"utf-8");
                        response.getWriter().write("<h2>您的上次访问时间为"+lastTime+"</h2>");
                        break;
                    }
                }
            }
            if(null==cookies || 0>=cookies.length || flag){
                Cookie cookie=new Cookie("lastTime",str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                response.getWriter().write("<h2>欢迎首次访问</h2>");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
