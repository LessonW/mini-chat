// pages/sort/sort.js
//引入 发送请求的方法
import{request} from "../../request/index.js";

Page({
  floorList:[],
  //菜谱分类
  sortList:[],
  imgHead: "",

  onLoad:function(option){
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
    });
    this.getflootList();
    this.getsortList();
  },

  getflootList(){
    request({url:"https://api-hmugo-web.itheima.net/api/public/v1/home/floordata"})
    .then(result=>{
      this.setData({
        floorList:result.data.message
      })
    })
  },
  getsortList(){
    request({ url: getApp().globalData.urlHead +"selectallsort"})
    .then(result=>{
      this.setData({
        sortList:result.data
      })
    })
  }

})