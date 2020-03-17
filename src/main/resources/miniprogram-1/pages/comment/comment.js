import { request } from "../../request/index.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
   dbuser:{},
   favList:[],
   imgHead: getApp().globalData.imgHead,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    const dbuser = wx.getStorageSync("dbuser");
    this.setData({ dbuser });
    this.getdata();
  },

  getdata() {
    request({ url: getApp().globalData.urlHead + "/rela/fansid/3" }, { method: 'get' })
      .then(result => {
        this.setData({
          favList: result.data
        })
      })
  },

})