package com.zzgs.service;

import com.zzgs.domain.BlogType;
import java.util.List;

public interface BlogTypeService {
     //查询所有类别
     public List<BlogType> findAll();
     //查询所有类别下的
     public BlogType findAllById(int id);
     //增加类别
     public void addBlogType(BlogType blogType);
     //修改类别
     public void updateBlogType(BlogType blogType);
     //删除类别
     public void deleteBlogType(int id);
}
