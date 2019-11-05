package com.zzgs.service.impl;


import com.zzgs.dao.BlogTypeDao;
import com.zzgs.domain.BlogType;
import com.zzgs.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("blogtypeService")
@Transactional
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeDao blogTypeDao;
    @Override
    public List<BlogType> findAll() {
        return blogTypeDao.findAll();
    }

    @Override
    public BlogType findAllById(int id) {
        return blogTypeDao.findAllById(id);
    }

    @Override
    public void addBlogType(BlogType blogType) {
        blogTypeDao.addBlogType(blogType);
    }

    @Override
    public void updateBlogType(BlogType blogType) {
       blogTypeDao.updateBlogType(blogType);
    }

    @Override
    public void deleteBlogType(int id) {
      blogTypeDao.deleteBlogType(id);
    }
}
