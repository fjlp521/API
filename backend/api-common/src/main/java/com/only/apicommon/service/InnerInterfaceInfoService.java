package com.only.apicommon.service;

import com.only.apicommon.model.entity.InterfaceInfo;

public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（url、请求方法）
     * @param url
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String url, String method);
}
