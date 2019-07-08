package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.SysLog;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/7/8 12:27
 */
public interface ISysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
