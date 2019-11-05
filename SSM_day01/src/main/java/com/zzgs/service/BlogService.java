package com.zzgs.service;

import com.zzgs.domain.Blog;
import java.util.List;

public interface BlogService {
    //查询全部数据
    public List<Blog> findAll(int page,int size);
    //根据id查数据
    public Blog findById(int id);
    //查询上一条下一跳记录
    public List<Blog> fetchNearById(int id);
    //条件查询语句
    public List<Blog> findAllById(int page,int size,int blog_type_id);
    //删除语句
    public void deleteById(int id);
    //增加语句
    public void addBlog(Blog blog);
    //更新语句
    public void updateBlog(Blog blog);
    //浏览量增加
    public void updateBrowse(int id);
    //模糊查询
    public List<Blog> search(int page,int size,String title);
}
