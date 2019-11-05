package com.zzgs.controller;

import com.zzgs.domain.BlogType;
import com.zzgs.service.impl.BlogTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/background")
public class BackgroundController {

    @Autowired
    private BlogTypeServiceImpl blogtypeService;

    @RequestMapping("/mainTemp")
    public ModelAndView mainTemp() {
         ModelAndView model = new ModelAndView();
         model.setViewName("mainTemp");
         return model;
    }

    @RequestMapping(value = "/type")
    public ModelAndView type(@RequestParam(name="action",required = false) String action,
                             @RequestParam(name="id",required = false) Integer id){
        if("".equals(action)||action==null)
        {
            action="typeadd";
        }
        ModelAndView model = new ModelAndView();
        if(action.equals("typeedit")){
            List<BlogType> blogTypes = blogtypeService.findAll();
            model.addObject("blogTypes",blogTypes);
            model.addObject("mainPage","/newsType/newsTypeList.jsp");
        }
        if(action.equals("typeadd"))
        {
            model.addObject("mainPage","/newsType/newsTypeSave.jsp");
        }
        if(action.equals("edit"))
        {
            if("".equals(id)||id==null){
                id=0;
            }
            BlogType blogTypes = blogtypeService.findAllById(id);
            model.addObject("blogTypes",blogTypes);
            model.addObject("mainPage","/newsType/newsTypeSave.jsp");
        }
        model.setViewName("mainTemp");
        return model;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addType(BlogType blogtype) throws Exception{
        if(blogtype.getId()==null){
            blogtype.setId(0);
        }
        if(blogtype.getId()!=0)
        {
           blogtypeService.updateBlogType(blogtype);
           ModelAndView model = new ModelAndView("redirect:/background/type?action=typeedit");
           return model;
        }else{
           blogtypeService.addBlogType(blogtype);
           ModelAndView model = new ModelAndView("redirect:/background/type?action=typeedit");
           return model;
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ModelAndView deleteType(@RequestParam(name="id",required = false) Integer id) throws Exception{
        if("".equals(id)||id==null){
            id=0;
        }
        blogtypeService.deleteBlogType(id);
        ModelAndView model = new ModelAndView("redirect:/background/type?action=typeedit");
        return model;
    }
    @RequestMapping("/update")
    @ResponseBody
    public ModelAndView updatevType(BlogType blogType) throws Exception{
        blogtypeService.updateBlogType(blogType);
        ModelAndView model = new ModelAndView("redirect:/background/type?action=typeedit");
        return model;
    }
}
