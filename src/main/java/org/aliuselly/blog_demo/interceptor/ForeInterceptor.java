package org.aliuselly.blog_demo.interceptor;

import com.alibaba.druid.util.StringUtils;
import org.aliuselly.blog_demo.entity.SysLog;
import org.aliuselly.blog_demo.entity.SysView;
import org.aliuselly.blog_demo.service.SysService;
import org.aliuselly.blog_demo.util.BrowserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 前台拦截器
 * 说明：用于对访问数量进行统计
 */
@Component
public class ForeInterceptor implements HandlerInterceptor {

    @Autowired
    private SysService sysService;

    private SysLog sysLog = new SysLog();
    private SysView sysView = new SysView();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        访问者 ip
        String ip = request.getRemoteAddr();
//        访问地址
        String url = request.getRequestURL().toString();
//        得到用户的浏览器名
        String userBrowser = BrowserUtil.getOsAndBrowserInfo(request);

//        给 SysLog 增加字段
        sysLog.setIp(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
        sysLog.setOperateBy(StringUtils.isEmpty(userBrowser) ? "获取浏览器名失败" : userBrowser);
        sysLog.setOperateUrl(StringUtils.isEmpty(url) ? "获取 URL 失败" : url);

//        增加访问量
        sysView.setIp(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
        sysService.addView(sysView);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        postHandle 就是渲染前，方法调用后才作用的，因此 handler 参数里边其实就是 controller 调用的方法
        if (handler instanceof HandlerMethod)
        {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
//            保存日志信息
            sysLog.setRemark(method.getName());
        }
        else
        {
            String uri = request.getRequestURI();
            sysLog.setRemark(uri);
        }
        sysService.addLog(sysLog);
    }
}
