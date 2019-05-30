package com.example.yahaha.vip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * COM-SYSTEM
 *
 * @author create by yangb in 2019/5/28
 */
@Component
public class WxUtils {

    private OkHttpClient client = new OkHttpClient();

    public String getOpenId(String code) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/sns/jscode2session?appid=wx78bdf33b59093578&secret=05ff94a1444942d51615bc55fc4e73cc&js_code="+code+"&grant_type=authorization_code")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String json = response.body().string();
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject.getString("openid");
        }

    }

    public String filterEmoji(String source,String slipStr) {
        if(StringUtils.isNotBlank(source)){
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
        }else{
            return source;
        }
    }
}
