package com.zzgs.domain;

import java.io.Serializable;

public class Blog implements Serializable{

    private Integer id;
    private String title;
    private String atitle;
    private String img1;
    private String content;
    private int blogTypeId;
    private String contentOne;
    private Integer browse;

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public String getContentOne() {
        return contentOne;
    }

    public void setContentOne(String contentOne) {
        this.contentOne = contentOne;
    }

    public int getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(int blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", atitle='" + atitle + '\'' +
                ", img1='" + img1 + '\'' +
                ", content='" + content + '\'' +
                ", blogTypeId=" + blogTypeId +
                ", contentOne='" + contentOne + '\'' +
                ", browse=" + browse +
                '}';
    }
}
