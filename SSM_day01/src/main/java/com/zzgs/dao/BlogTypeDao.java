package com.zzgs.dao;


import com.zzgs.domain.BlogType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogTypeDao {
    @Select("select * from blog_type")
    public List<BlogType> findAll();
    @Select("select * from blog_type where id=#{id}")
    public BlogType findAllById(int id);
    @Insert("insert into blog_type(title,description) values(#{title},#{description})")
    public void addBlogType(BlogType blogType);
    @Update("update blog_type set title =#{title},description=#{description} where id = #{id}")
    public void updateBlogType(BlogType blogType);
    @Delete("delete from blog_type where id=#{id}")
    public void deleteBlogType(int id);
}
