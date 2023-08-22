package com.only.apibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @author 28677
 * @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
 * @createDate 2023-08-19 22:33:03
 * @Entity
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




