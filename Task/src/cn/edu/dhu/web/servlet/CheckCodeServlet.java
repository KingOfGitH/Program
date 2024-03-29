package cn.edu.dhu.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author zhbr
 * @date 2019/4/3 10:26
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");//加上在高级浏览器画图无效

        int width=100,height=50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("楷体",Font.BOLD,24));
        String str="ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234546789";
        String checkCode="";
        Random random=new Random();
        for (int i = 1; i <=4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);

            checkCode+=ch;
            graphics.drawString(ch+"",width/5*i,height/2*(index+31)/str.length());
        }
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);

        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
