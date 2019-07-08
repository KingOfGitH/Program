package cn.edu.dhu.ssm.controller;

import cn.edu.dhu.ssm.domain.SysLog;
import cn.edu.dhu.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhbr
 * @date 2019/7/8 12:20
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date startTime;
    private Class executionClass;
    private Method executionMethod;


    @Before("execution(* cn.edu.dhu.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException {
        startTime = new Date();
        executionClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            executionMethod = executionClass.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for( int i = 0;i<args.length ;i++){
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* cn.edu.dhu.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        if (executionClass != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping)executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = "";
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];
                    SysLog sysLog = new SysLog();
                    Long executionTime = new Date().getTime() - startTime.getTime();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    String ip = request.getRemoteAddr();
                    sysLog.setIp(ip);
                    SecurityContext context = SecurityContextHolder.getContext(); //
                    request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    String username = ((User)(context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
