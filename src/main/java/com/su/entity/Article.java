package com.su.entity;

public class Article {
    private Integer id;

    private String title;

    private String summary;

    private String createtime;

    private Integer createuser;

    private String createusername;

    private String status;

    private Integer isHome;

    private Integer isTop;

    private String updateTime;

    private Integer updateUser;

    private Integer specialtopicId;

    private Integer keywords;

    private String image;

    private String content;

    private Integer sum;

    private  String keywordText;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getSpecialtopicId() {
        return specialtopicId;
    }

    public void setSpecialtopicId(Integer specialtopicId) {
        this.specialtopicId = specialtopicId;
    }

    public Integer getKeywords() {
        return keywords;
    }

    public void setKeywords(Integer keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get image
     * 
     * @return Returns the image.<br>
     */
    public String getImage() {

        return image == null ? "" : image;
    }

    /**
     * set image
     * 
     * @param image The image to set. <br>
     */
    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSum() {
        if (sum == null) {
            sum = 0;
        }
        return sum;
    }

    public void setSum(Integer sum) {
        if (sum == null) {

            sum = 0;
        }

        this.sum = sum;
    }

    public String getKeywordText() {
        return keywordText;
    }

    public void setKeywordText(String keywordText) {
        this.keywordText = keywordText;
    }
}