// pages/menu/menu.js
import { request } from "../../request/index.js";

Page({


  data: {
    menuid:"",
    menu:{},
    imgHead: "",

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      menuid:options.menuid,
      imgHead: getApp().globalData.imgHead,

    })
    this.getcompMenu();
  },

  getcompMenu(){
    request({ url: getApp().globalData.urlHead + "onemenu/" + this.data.menuid })
      .then(result => {
        this.setData({
          menu: result.data
        })
      })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  
})