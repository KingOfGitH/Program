package cn.edu.dhu.controller;

import cn.edu.dhu.domain.User;
import cn.edu.dhu.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author zhbr
 * @date 2019/4/19 13:29
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping(value = "/{username}&{password}",method = {RequestMethod.GET})
    public String sayHello(@PathVariable("username") String username, @PathVariable("password") String password,Model model){
        System.out.println("Hello SpringMVC");
        System.out.println(username);
        System.out.println(password);
        System.out.println(model);
//        model.addAttribute("msg","喜羊羊");
        return "success";
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String saveAccount(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("abc") User user){
        System.out.println("saveUser");
        System.out.println(user);
        return "success";
    }
    @RequestMapping(method = {RequestMethod.POST})
    public String saveAccount1(@CookieValue("JSESSIONID") String body){
        System.out.println(body);
        return "success";
    }

//    @ModelAttribute
//    public void show(){
//        System.out.println("这里?");
//    }

//    @ModelAttribute
//    public User showUser(){
//        User user = new User();
//        user.setUname("123");
//        user.setDate(new Date());
//        System.out.println("showUser()");
//        return user;
//    }

    /*@ModelAttribute
    public void showUser(Map<String ,User> map){
        User user = new User();
        user.setUname("123");
        user.setDate(new Date());
        System.out.println("showUser()");
        map.put("abc",user);
    }*/
    @ModelAttribute
    public void showUser(Model model){
//        System.out.println("model");
//        System.out.println(model);
//        model.addAttribute("msg","美羊羊");
//        System.out.println(model);
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        System.out.println(user);
        user.setUname("张三");
        System.out.println(user);
        return user;
    }

    @RequestMapping("/fileUpLoad")
    public String  fileUpLoad(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");

        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(realPath);
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);

        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem item:fileItems){
            if (item.isFormField()){
                System.out.println("FormField");
            }else {
                String name = item.getName();
                String replace = UUID.randomUUID().toString().replace("-", "");
                name=replace+"_"+name;
                item.write(new File(realPath,name));
                item.delete();
            }
        }

        return "success";
    }
    @RequestMapping("/fileUpLoad1")
    public String  fileUpLoad1(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传。。。");

        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(realPath);
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }

        String name = upload.getOriginalFilename();

        String replace = UUID.randomUUID().toString().replace("-", "");
        name=replace+"_"+name;
        upload.transferTo(new File(realPath,name));


        return "success";
    }
    @RequestMapping("/fileUpLoad2")
    public String  fileUpLoad2( MultipartFile upload) throws Exception {
        System.out.println("springmvc跨服务器文件上传。。。");
        String path="http://localhost:9090/uploads/";

        Client client = Client.create();

        String name = upload.getOriginalFilename();

        String replace = UUID.randomUUID().toString().replace("-", "");
        name=path + replace+"_"+name;

        WebResource resource = client.resource(name);
        resource.put(upload.getBytes());

        return "success";
    }

    @RequestMapping("/exception")
    public String exception() throws SysException {
        try {
            int a=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("计算错误");
        }
        return "success";
    }
    @RequestMapping("/interceptor")
    public String interceptor(){
        System.out.println("interceptor()");

        return "success";
    }
}
