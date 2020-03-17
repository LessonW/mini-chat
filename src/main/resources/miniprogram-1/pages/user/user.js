// pages/user/user.js
import { request } from "../../request/index.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgHead: "",
    userid:'',
    menuList: [],
    tabs:[
      {
        id:0,
        value:"菜谱",
        isActive:true
      },
      {
        id:1,
        value:"作品",
        isActive:false
      }
    ]

  },
  //标题点击事件从子组件传递过来
  handleTabsItemChange(e) {
    //获取被点击的标题索引
    const { index } = e.detail;
    //修改源数组
    let { tabs } = this.data;
    tabs.forEach((v, i) => i === index ? v.isActive = true : v.isActive = false);
    //赋值到 data
    this.setData({
      tabs
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      imgHead: getApp().globalData.imgHead,
      userid: options.userid,
    })
    this.getdata();
  },

//该用户的菜谱
  getdata() {
    request({ url: getApp().globalData.urlHead + "search/userid/"+this.data.userid }, { method: 'get' })
      .then(result => {
        console.log(getApp().globalData.urlHead)
        this.setData({
          menuList: result.data
        })
      })
  },

  
})