package cn.edu.dhu.ssm.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zhbr
 * @date 2019/7/8 11:57
 */
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}
