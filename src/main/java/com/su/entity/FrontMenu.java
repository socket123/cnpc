package com.su.entity;

public class FrontMenu {
    private Integer id;

    private String menuname;

    private String menuurl;

    private String status;

    private String menucreateuser;

    private String menucreatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMenucreateuser() {
        return menucreateuser;
    }

    public void setMenucreateuser(String menucreateuser) {
        this.menucreateuser = menucreateuser;
    }

    public String getMenucreatetime() {
        return menucreatetime;
    }

    public void setMenucreatetime(String menucreatetime) {
        this.menucreatetime = menucreatetime;
    }
}