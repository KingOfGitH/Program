package cn.edu.dhu.ssm.service.Impl;

import cn.edu.dhu.ssm.dao.ISysLogDao;
import cn.edu.dhu.ssm.domain.SysLog;
import cn.edu.dhu.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/7/8 12:27
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
