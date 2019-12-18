package com.entity;

import java.util.Date;

public class Discuss {
    private Integer id;

    private Integer mainpostsid;

    private Integer userid;

    private Date time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainpostsid() {
        return mainpostsid;
    }

    public void setMainpostsid(Integer mainpostsid) {
        this.mainpostsid = mainpostsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}