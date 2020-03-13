package com.foodguide.service.impl;

import com.alibaba.fastjson.JSON;
import com.foodguide.controller.MainController;
import com.foodguide.service.WeChatService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeChatServiceimpl implements WeChatService {
    private static  final Log log= LogFactory.getLog(WeChatService.class);

    @Override
    public String codetoopenid(String code) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", "wxb5ac5a22f3c114e8");
        data.put("secret", "ab6fbf045228ea00877478d778e3e571");
        data.put("js_code", code);
        data.put("grant_type", "authorization_code");


        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();
        log.warn("Response was: " + response);
        JSONObject obj= JSON.parseObject(response);//将json字符串转换为json对
        log.warn("openid="+obj.get("openid"));

        return (String) obj.get("openid");
    }
}
