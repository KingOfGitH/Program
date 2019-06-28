package cn.edu.dhu.ssm.controller;

import cn.edu.dhu.ssm.domain.Orders;
import cn.edu.dhu.ssm.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/25 14:54
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer size){
        ModelAndView mv=new ModelAndView();
        List<Orders> all = orderService.findAll(page, size);
        for (Orders orders:all) System.out.println(orders.getId());
        PageInfo pageInfo=new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv=new ModelAndView();
        Orders orders=orderService.findById(id);
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;
    }
}
