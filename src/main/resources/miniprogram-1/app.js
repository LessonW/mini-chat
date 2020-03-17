//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      
    })
    
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  onReady: function (options) {
    const that = this;
    wx.login({
      // 获取code
      success: function (res) {
        var code = res.code; // 返回code
        var APPID = 'wxb5ac5a22f3c114e8'; // 换成自己的APPID
        var SECRET = 'ab6fbf045228ea00877478d778e3e571' // 换成自己的SECRET
        var url = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + APPID + '&secret=' + SECRET + '&js_code=' + code + '&grant_type=authorization_code';

        wx.request({
          url,
          data: {},
          headers: {
            "content-type": "application/json",
          },
          success: function (res) {
            that.setData({
              openid: res.openid
            });
          }
        })
      }
    })
  },

  globalData: {
    userInfo: null,
    urlHead:'http://localhost:8080/',
    imgHead: 'http://q6d69wjq6.bkt.clouddn.com/'
  }
})