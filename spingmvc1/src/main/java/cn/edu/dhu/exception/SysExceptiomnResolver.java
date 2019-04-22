package cn.edu.dhu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhbr
 * @date 2019/4/21 16:19
 */
public class SysExceptiomnResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException=null;
        if (e instanceof SysException){
            sysException= (SysException) e;
        }else {
            sysException =new SysException("维护中");
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("errorMsg",sysException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
