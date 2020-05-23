package com.sitech.aicp.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uid;
    private Long leader;
    private String scheduleName;
    private String startDate;
    private String endDate;
    private Date createTime;
    private Date lastUpdateTime;
    private String opeationIp;
    private int status; // 0 未分配 1 处理中 2 完成

}
