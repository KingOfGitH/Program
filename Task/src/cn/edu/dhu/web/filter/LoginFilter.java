package cn.edu.dhu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhbr
 * @date 2019/4/7 16:00
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        String uri = request.getRequestURI();

        if (uri.contains("/login")||uri.contains("/register")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/checkCodeServlet")){
            chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","请您登录!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
