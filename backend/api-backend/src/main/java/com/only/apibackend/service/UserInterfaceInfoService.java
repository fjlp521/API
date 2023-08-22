package com.only.apibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.apicommon.model.entity.UserInterfaceInfo;

/**
 * @author 28677
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2023-08-09 17:55:31
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo post, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);

    boolean hasInvokeNum(long interfaceInfoId, long userId);
}
