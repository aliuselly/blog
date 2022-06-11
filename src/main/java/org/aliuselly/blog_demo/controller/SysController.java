package org.aliuselly.blog_demo.controller;

import io.swagger.annotations.ApiOperation;
import org.aliuselly.blog_demo.entity.SysLog;
import org.aliuselly.blog_demo.entity.SysView;
import org.aliuselly.blog_demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统 controller
 */
@RestController
@RequestMapping("/admin")
public class SysController {

    @Autowired
    private SysService sysService;

    /**
     * 返回所有的系统日志记录信息
     * @return
     */
    @ApiOperation("返回所有的 SysLog 信息")
    @GetMapping("/sys/log")
    public List<SysLog> listAllLog()
    {
        return sysService.listAllLog();
    }

    /**
     * 返回所有的系统浏览记录信息
     * @return
     */
    @ApiOperation("返回所有的 SysView 信息")
    @GetMapping("/sys/view")
    public List<SysView> listAllView()
    {
        return sysService.listAllView();
    }
}
