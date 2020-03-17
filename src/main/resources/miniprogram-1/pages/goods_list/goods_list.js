// pages/goods_list/goods_list.js
import { request } from "../../request/index.js";
Page({

  /**
   * 页面的初始数据
   */

  data: {
    imgHead: "",
    sortid:'3',
    menulist:[],
    tabs:[
      {
        id:0,
        value:"热门",
        isActive:true
      },
      {
        id:1,
        value:"收藏高",
        isActive:false
      },
      {
        id:2,
        value:"点赞高",
        isActive:false
      }
    ]
  },
  
  //标题点击事件从子组件传递过来
  handleTabsItemChange(e){
    //获取被点击的标题索引
    const {index}=e.detail;
    //修改源数组
    let {tabs}=this.data;
    tabs.forEach((v,i)=>i===index?v.isActive=true:v.isActive=false);
    //赋值到 data
    this.setData({
      tabs
    })
  },
  //获取该分类下的菜谱
  getsortList() {
    request({ url: getApp().globalData.urlHead + "selectByid/" + this.data.sortid })
      .then(result => {
        this.setData({
          menulist: result.data
        })
      })
  },


  onLoad: function (options) {
    this.setData({
      sortid: options.sortid,
      imgHead:getApp().globalData.imgHead,
    })
  this.getsortList();
  },

})