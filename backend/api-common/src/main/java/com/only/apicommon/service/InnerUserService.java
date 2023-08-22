package com.only.apicommon.service;

import com.only.apicommon.model.entity.User;

public interface InnerUserService {
    /**
     * 从数据库中查是否已分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
