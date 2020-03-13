package com.foodguide.pojo;


public class Sort {

  private long id;
  private String mainsort;
  private String secondsort;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;
  private String img;

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMainsort() {
    return mainsort;
  }

  public void setMainsort(String mainsort) {
    this.mainsort = mainsort;
  }


  public String getSecondsort() {
    return secondsort;
  }

  public void setSecondsort(String secondsort) {
    this.secondsort = secondsort;
  }


  public java.sql.Timestamp getCtime() {
    return ctime;
  }

  public void setCtime(java.sql.Timestamp ctime) {
    this.ctime = ctime;
  }


  public java.sql.Timestamp getMtime() {
    return mtime;
  }

  public void setMtime(java.sql.Timestamp mtime) {
    this.mtime = mtime;
  }

}
