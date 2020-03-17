// pages/detail/detail.js
import { request } from "../../request/index.js";

Page({
    handleGetUserInfo(e) {
        // console.log(e);
        const { userInfo } = e.detail;
        wx.setStorageSync("userinfo", userInfo);
        const userinfo=wx.getStorageSync("userinfo");
        this.setData({ userinfo });

      wx.login({
        success: res => {
          // 发送 res.code 到后台换取 openId, sessionKey, unionId
          // console.log(res.code)
          // console.log(userInfo.avatarUrl)
          // console.log(userInfo.nickName)
          if (res.code) {
            wx.request({
              url: getApp().globalData.urlHead +'getAllUserinfo',
              method: 'POST',
              data: {
                code: res.code,
                avatar: userInfo.avatarUrl,
                nickName:userInfo.nickName
              },
              header: {
                'content-type': 'application/x-www-form-urlencoded'
              },
              success(res) {
                // console.log("openid:" + res.data.openid);
                // console.log(res.data);
                // const { dbuser }=res.data
                wx.setStorageSync("dbuser", res.data)
                if (res.data.openid != "undefined" || res.data.openid != null) {
                  // 登录成功
              
                } else {
                  // 登录失败
                  // TODO 跳转到错误页面，要求用户重试

                  return false;
                }
              }
            })
          } else {
            console.log('获取用户登录态失败！' + res.errMsg)
          }
        }
      })       
      },
    data:{
        userinfo:{},
        dbuser:{}
    },

    onShow(){
        const userinfo=wx.getStorageSync("userinfo");
        this.setData({userinfo});
        
        const dbuser = wx.getStorageSync("dbuser");
        this.setData({ dbuser });
    },
})