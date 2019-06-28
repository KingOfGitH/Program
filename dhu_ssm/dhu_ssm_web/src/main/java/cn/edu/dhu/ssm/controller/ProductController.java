package cn.edu.dhu.ssm.controller;

import cn.edu.dhu.ssm.domain.Product;
import cn.edu.dhu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/17 16:55
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> ps=productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String  save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
