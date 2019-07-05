package cn.com.model;

import java.util.Date;

public class Activitystate {
    private Integer id;

    private String username;

    private Date datetime;

    private Float sittime;

    private Float walktime;

    private Float lietime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Float getSittime() {
        return sittime;
    }

    public void setSittime(Float sittime) {
        this.sittime = sittime;
    }

    public Float getWalktime() {
        return walktime;
    }

    public void setWalktime(Float walktime) {
        this.walktime = walktime;
    }

    public Float getLietime() {
        return lietime;
    }

    public void setLietime(Float lietime) {
        this.lietime = lietime;
    }
}