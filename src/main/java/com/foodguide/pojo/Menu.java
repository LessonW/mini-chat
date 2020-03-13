package com.foodguide.pojo;


public class Menu {

  private long id;
  private String title;
  private long userid;
  private String step;
  private String material;
  private long sortid;
  private java.sql.Timestamp ctime;
  private long state;
  private java.sql.Timestamp mtime;
  private String img;
  private User user;
  private Sort sort;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getStep() {
    return step;
  }

  public void setStep(String step) {
    this.step = step;
  }


  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }


  public long getSortid() {
    return sortid;
  }

  public void setSortid(long sortid) {
    this.sortid = sortid;
  }


  public java.sql.Timestamp getCtime() {
    return ctime;
  }

  public void setCtime(java.sql.Timestamp ctime) {
    this.ctime = ctime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getMtime() {
    return mtime;
  }

  public void setMtime(java.sql.Timestamp mtime) {
    this.mtime = mtime;
  }


  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }


}
