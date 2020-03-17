//封装的 request 请求
export const request = (url,method)=>{
    return new Promise((resolve,reject)=>{
        wx.request({
          ...url,
          ...method,
            // ...params,
            success: (result)=> {
                resolve(result)
            },fail: (err)=> {
                reject(err)
            }
        })
    })
}