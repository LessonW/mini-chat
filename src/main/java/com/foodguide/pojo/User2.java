package com.foodguide.pojo;


import com.alibaba.fastjson.JSON;

public class User2 {

  private long id;
  private JSON name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public JSON getName() {
    return name;
  }

  public void setName(JSON name) {
    this.name = name;
  }

}
