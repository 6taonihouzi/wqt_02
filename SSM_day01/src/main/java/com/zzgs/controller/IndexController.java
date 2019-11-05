package com.zzgs.controller;

import com.github.pagehelper.PageInfo;
import com.zzgs.domain.Blog;
import com.zzgs.domain.BlogType;
import com.zzgs.service.impl.BlogServiceImpl;
import com.zzgs.service.impl.BlogTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private BlogTypeServiceImpl blogtypeService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page",required = false)Integer page,
                                @RequestParam(name="size",required = false)Integer size){
        System.out.println("nihao_________________-");
        if(page==null){
            page=1;
        }
        if(size==null){
            size=5;
        }
        ModelAndView model = new ModelAndView();
        List<BlogType> blogtypes = blogtypeService.findAll();
        model.addObject("blogtypes",blogtypes);
        List<Blog> blogs = blogService.findAll(page,size);
        PageInfo pageinfo = new PageInfo(blogs);
        model.addObject("pageInfo",pageinfo);
//        model.setViewName("index");
        return model;
    }
}
