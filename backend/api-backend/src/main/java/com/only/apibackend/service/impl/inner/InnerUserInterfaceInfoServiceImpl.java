package com.only.apibackend.service.impl.inner;

import com.only.apibackend.service.UserInterfaceInfoService;
import com.only.apicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean hasInvokeNum(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.hasInvokeNum(interfaceInfoId, userId);
    }
}
