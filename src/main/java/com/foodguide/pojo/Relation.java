package com.foodguide.pojo;


public class Relation {

  private long id;
  private long userid;
  private long fansid;
  private long state;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public long getFansid() {
    return fansid;
  }

  public void setFansid(long fansid) {
    this.fansid = fansid;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
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
