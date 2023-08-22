package com.only.apiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {
    static public String genSign(String data, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = data + "." + secretKey;
        String digestHex = md5.digestHex(content);
        return digestHex;
    }
}
