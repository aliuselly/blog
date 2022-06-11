package org.aliuselly.blog_demo.service.impl;

import org.aliuselly.blog_demo.dao.SysLogMapper;
import org.aliuselly.blog_demo.dao.SysViewMapper;
import org.aliuselly.blog_demo.entity.SysLog;
import org.aliuselly.blog_demo.entity.SysView;
import org.aliuselly.blog_demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SysService 实现类
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysLogMapper sysLogMapper;
    @Autowired
    private SysViewMapper sysViewMapper;

    /**
     * 增加一条日志信息
     * @param sysLog
     */
    @Override
    public void addLog(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }

    /**
     * 增加一条访问量
     * @param sysView
     */
    @Override
    public void addView(SysView sysView) {
        sysViewMapper.insertSelective(sysView);
    }

    /**
     * 获取日志的总数量
     * @return
     */
    @Override
    public int getLogCount() {
        return sysLogMapper.select(c -> c.where()).size();
    }

    /**
     * 返回当前网站的访问量
     * @return
     */
    @Override
    public int getViewCount() {
        return sysViewMapper.select(c -> c.where()).size();
    }

    /**
     * 返回所有的日志信息
     * @return
     */
    @Override
    public List<SysLog> listAllLog() {
        return sysLogMapper.select(c -> c.where());
    }

    /**
     * 返回所有的访问信息
     * @return
     */
    @Override
    public List<SysView> listAllView() {
        return sysViewMapper.select(c -> c.where());
    }
}
