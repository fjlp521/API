package com.only.apibackend.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 调用接口
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * id
     */
    private Long id;


    /**
     * 请求参数
     */
    private String userRequestParams;


    private static final long serialVersionUID = 1L;
}