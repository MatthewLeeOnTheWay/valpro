package com.security.valpro.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Msg {
    private Integer id;
    private String title;
    private String content;
    private String extraInfo;

    public Msg(String 测试标题, String 测试内容) {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


    public Msg(String title, String content, String extraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }


}
