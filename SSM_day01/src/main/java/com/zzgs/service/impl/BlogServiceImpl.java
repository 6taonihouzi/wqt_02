package com.zzgs.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.dao.BlogDao;
import com.zzgs.domain.Blog;
import com.zzgs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("blogService")
public class BlogServiceImpl implements BlogService
{
    @Autowired
    private BlogDao blogDao;
    @Override
    public List<Blog> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return blogDao.findAll();
    }
    @Override
    public Blog findById(int id) {
        return blogDao.findById(id);
    }
    @Override
    public List<Blog> fetchNearById(int id) {
        return blogDao.fetchNearById(id);
    }
    @Override
    public List<Blog> findAllById(int page, int size, int blog_type_id) {
        PageHelper.startPage(page,size);
        return blogDao.findAllById(blog_type_id);
    }

    @Override
    public void deleteById(int id) {
        blogDao.deleteById(id);
    }

    @Override
    public void addBlog(Blog blog) {
        blogDao.addBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.updateBlog(blog);
    }

    @Override
    public void updateBrowse(int id) {
        blogDao.updateBrowse(id);
    }

    @Override
    public List<Blog> search(int page,int size,String title) {
        PageHelper.startPage(page,size);
        return blogDao.search(title);
    }
}
