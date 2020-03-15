package com.foodguide.pojo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class User2 {

  private long id;
  private JSONObject name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public JSONObject getName() {
    return name;
  }

  public void setName(JSONObject name) {
    this.name = name;
  }

}
