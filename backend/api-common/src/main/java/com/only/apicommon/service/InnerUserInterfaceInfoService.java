package com.only.apicommon.service;

public interface InnerUserInterfaceInfoService {
    /**
     * 调用接口统计（调用次数加1）
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 判断是否还有调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean hasInvokeNum(long interfaceInfoId, long userId);
}
