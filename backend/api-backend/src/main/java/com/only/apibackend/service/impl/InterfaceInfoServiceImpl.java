package com.only.apibackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.apibackend.common.ErrorCode;
import com.only.apibackend.exception.BusinessException;
import com.only.apibackend.mapper.InterfaceInfoMapper;
import com.only.apibackend.service.InterfaceInfoService;
import com.only.apicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 28677
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2023-08-09 17:55:31
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo post, boolean add) {
        if (post == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = post.getName();
        String method = post.getMethod();
        String description = post.getDescription();
        String url = post.getUrl();
        if (add) {
            if (StringUtils.isAnyBlank(name, url, method, description)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
    }

}




