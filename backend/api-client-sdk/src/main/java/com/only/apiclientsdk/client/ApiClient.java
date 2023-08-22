package com.only.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.only.apiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.only.apiclientsdk.utils.SignUtils.genSign;

public class ApiClient {
    public static final String GATEWAY_HOST = "http://localhost:8090";
    private String accessKey;
    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> header = new HashMap<>();
        header.put("accessKey", accessKey);
//        header.put("secretKey", secretKey);
        header.put("nonce", RandomUtil.randomNumbers(4));
        header.put("body", body);
        header.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        header.put("sign", genSign(body, secretKey));
        return header;
    }


    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String res = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        System.out.println(res);
        return res;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String res = HttpUtil.post(GATEWAY_HOST + "/api/name/post", paramMap);
        System.out.println(res);
        return res;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String res = httpResponse.body();
        System.out.println(res);
        return res;
    }
}
