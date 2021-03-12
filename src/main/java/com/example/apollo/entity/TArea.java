package com.example.apollo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_area
 * @author 
 */
@Data
public class TArea implements Serializable {
    /**
     * 地市编码
     */
    private String areaCode;

    /**
     * 地市名称
     */
    private String areaName;

    /**
     * 地域关系节点串
     */
    private String areaFrame;

    /**
     * 同级排序
     */
    private String orderNo;

    private String parentAreaCode;

    private Integer startDate;

    private Integer endDate;

    private Integer areaLevel;

    private Integer validflag;

    private String areaCode1;

    private String areaCode2;

    private String remark;

    private String para;

    private String paraId;

    private String paraValue;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}