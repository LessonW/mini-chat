// pages/sort/sort.js
//引入 发送请求的方法
import { request } from "../../request/index.js";
Page({
  imgHead: "",
  menuList: [],


  onLoad: function (option) {
    //通过 es6的promise技术解决
    // wx.request({
    //   url: 'https://URL',
    //   method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
    //   // header: {}, // 设置请求的 header
    //   success:(result) => {
    //     this.setData({
    //       floorList:result.data.message
    //     })
    //   },
    // })
    this.setData({
      imgHead: getApp().globalData.imgHead,
    })
    this.getdata()
  },

  getdata() {
    request({ url: getApp().globalData.urlHead+"/menulist"},{method:'get'})
      .then(result => {
        console.log(getApp().globalData.urlHead)
        this.setData({
          menuList: result.data
        })
      })
  },
  



})