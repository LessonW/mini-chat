package com.foodguide.pojo;


public class Favorite {

  private long id;
  private long menuid;
  private long userid;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMenuid() {
    return menuid;
  }

  public void setMenuid(long menuid) {
    this.menuid = menuid;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
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
