package com.zzgs.controller;

import com.github.pagehelper.PageInfo;
import com.zzgs.domain.*;
import com.zzgs.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/list")
public class listController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private BlogTypeServiceImpl blogtypeService;

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id",required = false) Integer id){
        if(id==null||id==0)
        {
            id=1;
        }
        blogService.updateBrowse(id);
        ModelAndView mv = new ModelAndView();
        Blog blog = blogService.findById(id);
        List<Blog> blogList = blogService.fetchNearById(id);
        List<BlogType> blogtypes = blogtypeService.findAll();
        mv.addObject("blogs1",blogList);
        mv.addObject("blogs",blog);
        mv.addObject("blogtypes",blogtypes);
        mv.setViewName("datail");
        return mv;
    }
    @RequestMapping("/findList")
    public ModelAndView findList(@RequestParam(name="page",required = false) Integer page,
                                 @RequestParam(name="size",required = false) Integer size,
                                 @RequestParam(name="id",required = false) Integer id){
        if(page==null||page==0){
             page=1;
        }
        if(size==null||size==0){
            size=2;
        }
        if(id==null||id==0)
        {
            id=2;
        }
        ModelAndView model = new ModelAndView();
        List<BlogType> blogtypes = blogtypeService.findAll();
        BlogType allById = blogtypeService.findAllById(id);
        model.addObject("allByIds",allById);
        model.addObject("blogtypes",blogtypes);
        List<Blog> blogs = blogService.findAllById(page,size,id);
        PageInfo pageinfo = new PageInfo(blogs);
        model.addObject("pageInfo",pageinfo);
        model.setViewName("list");
        return model;
    }
}
