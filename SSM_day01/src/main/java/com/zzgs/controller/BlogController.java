package com.zzgs.controller;

import com.github.pagehelper.PageInfo;
import com.zzgs.domain.Blog;
import com.zzgs.domain.BlogType;
import com.zzgs.service.impl.BlogServiceImpl;
import com.zzgs.service.impl.BlogTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private BlogTypeServiceImpl blogTypeService;
    @RequestMapping("/link")
    public ModelAndView link(@RequestParam(name="action",required = false)String action,
                             @RequestParam(name="page",required = false) Integer page,
                             @RequestParam(name="size",required = false) Integer size,
                             @RequestParam(name="id",required = false) Integer id){
        if(page==null){
            page=1;
        }
        if(size==null){
            size=5;
        }
        if("".equals(action)||action==null) {
            action="blogedit";
        }
        if("".equals(id)||id==null)
        {
            id=0;
        }
        ModelAndView model = new ModelAndView();
        if(action.equals("blogadd"))
        {
            Blog blog = blogService.findById(id);
            List<BlogType> blogtypes = blogTypeService.findAll();
            model.addObject("blog",blog);
            model.addObject("blogtypes",blogtypes);
            model.addObject("mainPage","/blog/blogSave.jsp");
        }
        if(action.equals("blogedit"))
        {
            List<Blog> blogs = blogService.findAll(page, size);
            model.addObject("blogs", blogs);
            PageInfo pageinfo = new PageInfo(blogs);
            model.addObject("pageInfo", pageinfo);
            model.addObject("mainPage", "/blog/blogedit.jsp");
        }
        model.setViewName("mainTemp");
        return model;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveBlog(Blog blog) throws Exception {
        if(blog.getId()==null)
        {
           blog.setId(0);
        }
        if(blog.getId()!=0)
        {
            blogService.updateBlog(blog);
            ModelAndView model = new ModelAndView("redirect:/blog/link?action=blogedit");
            return model;
        }else{
            blogService.addBlog(blog);
            ModelAndView model = new ModelAndView("redirect:/blog/link?action=blogedit");
            return model;
        }
    }
    @RequestMapping("/delete")
    public ModelAndView deleteBlog(@RequestParam(name="id",required = false)Integer id){
        if("".equals(id)||id==null){
            id=0;
        }
        blogService.deleteById(id);
        ModelAndView model = new ModelAndView("redirect:/blog/link");
        return model;
    }
    @RequestMapping("/search")
    public ModelAndView searchBlog(@RequestParam(name="page",required = false) Integer page,
                                   @RequestParam(name="size",required = false) Integer size,
                                   Blog blog){
        if(page==null){
            page=1;
        }
        if(size==null){
            size=5;
        }
        ModelAndView model = new ModelAndView();
        List<Blog> search = blogService.search(page,size,blog.getTitle());
        PageInfo pageinfo = new PageInfo(search);
        model.addObject("blogs",search);
        model.addObject("pageInfo",pageinfo);
        model.addObject("mainPage", "/blog/blogedit.jsp");
        model.setViewName("mainTemp");
        return model;
    }
}
