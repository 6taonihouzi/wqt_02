package com.zzgs.dao;

import com.zzgs.domain.Blog;
import com.zzgs.domain.BlogType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogDao {
    @Select("select b.id,b.title,bt.title btitle,b.img1,b.content,b.blog_type_id,b.content_1,browse from blog b LEFT JOIN blog_type bt ON b.blog_type_id = bt.id order by  browse Desc")
    @Results(value={
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="btitle",property="atitle"),
            @Result(column="img1",property="img1"),
            @Result(column="content",property="content"),
            @Result(column="blog_type_id",property="blogTypeId"),
            @Result(column="content_1",property="contentOne"),
            @Result(column="browse",property="browse")
    })
    public List<Blog> findAll();

    @Select("select b.id,b.title,bt.title btitle,b.img1,b.content,b.blog_type_id,b.content_1,browse from blog b LEFT JOIN blog_type bt ON b.blog_type_id = bt.id where b.id= #{id}")
    @Results(value={
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="btitle",property="atitle"),
            @Result(column="img1",property="img1"),
            @Result(column="content",property="content"),
            @Result(column="blog_type_id",property="blogTypeId"),
            @Result(column="content_1",property="contentOne"),
            @Result(column="browse",property="browse")
    })
    public Blog findById(int id);

    @Select("select * from blog where id in\n" +
            "(select\n" +
            "case\n" +
            "when SIGN(id-#{id})>0 THEN MIN(id)\n" +
            "when SIGN(id-#{id})<0 THEN MAX(id)\n" +
            "ELSE id\n" +
            "end\n" +
            "from blog\n" +
            "where id !=#{id}\n" +
            "GROUP BY SIGN(id-#{id})\n" +
            "ORDER BY SIGN(id-#{id})\n" +
            ")\n" +
            "ORDER BY id")
    public List<Blog> fetchNearById(int id);

    @Select("select b.id,b.title,bt.title btitle,b.img1,b.content,b.blog_type_id,b.content_1,browse from blog b LEFT JOIN blog_type bt ON b.blog_type_id = bt.id where blog_type_id = #{blog_type_id} order by  browse Desc")
    public List<Blog> findAllById(int blog_type_id);

    @Delete("delete from blog where id = #{id}")
    public void deleteById(int id);

    @Insert("insert into blog(title,img1,content,blog_type_id,content_1,browse) values(#{title},'../images/b01.jpg',#{content},#{blogTypeId},#{contentOne},0)")
    public void addBlog(Blog blog);

    @Update("update blog set title=#{title},content=#{content},blog_type_id=#{blogTypeId},content_1=#{contentOne} where id = #{id}")
    public void updateBlog(Blog blog);

    @Update("update blog set browse=browse+1 where id=#{id}")
    public void updateBrowse(int id);

    @Select("select b.id,b.title,bt.title btitle,b.img1,b.content,b.blog_type_id,b.content_1,browse from blog b LEFT JOIN blog_type bt ON b.blog_type_id = bt.id where b.title like '%${value}%' ")
    @Results(value={
            @Result(id=true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="btitle",property="atitle"),
            @Result(column="content",property="content"),
            @Result(column="blog_type_id",property="blogTypeId"),
            @Result(column="content_1",property="contentOne"),
            @Result(column="browse",property="browse")
    })
    public List<Blog> search(String title);
}
