package org.aliuselly.blog_demo.service;

import org.aliuselly.blog_demo.entity.SysLog;
import org.aliuselly.blog_demo.entity.SysView;

import java.util.List;

/**
 * 日志/访问统计等系统相关 service
 */
public interface SysService {

    void addLog(SysLog sysLog);

    void addView(SysView sysView);

    int getLogCount();

    int getViewCount();

    List<SysLog> listAllLog();

    List<SysView> listAllView();
}
