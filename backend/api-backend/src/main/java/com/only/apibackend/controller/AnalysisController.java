package com.only.apibackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.apibackend.annotation.AuthCheck;
import com.only.apibackend.common.BaseResponse;
import com.only.apibackend.common.ErrorCode;
import com.only.apibackend.common.ResultUtils;
import com.only.apibackend.constant.UserConstant;
import com.only.apibackend.exception.BusinessException;
import com.only.apibackend.mapper.UserInterfaceInfoMapper;
import com.only.apibackend.model.vo.InterfaceInfoVO;
import com.only.apibackend.service.InterfaceInfoService;
import com.only.apicommon.model.entity.InterfaceInfo;
import com.only.apicommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> collect = userInterfaceInfoList.stream().
                collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", collect.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (list.isEmpty()) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = collect.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }
}
