package org.aliuselly.blog_demo.interceptor;

import org.aliuselly.blog_demo.config.UserConfig;
import org.aliuselly.blog_demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台拦截器
 * 说明：对 /admin 开头的地址进行拦截必须经过验证之后才能够进行访问
 */
@Component
public class BackstageInterceptor extends UserConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        User user = (User) request.getSession().getAttribute("user");
        if (null == user)
        {
//            如果用户为空则跳转到 error 页面
//            修改 sendRedirect 方法为 getRequestDispatcher
//            目的保证地址栏不改变（与前台错误页面响应一致），这样用户就不知道后台的地址
//            其实就是将重定向变为了转发
//            个人更改了，那么就转发到登录页面吧
            request.setAttribute("msg", "请登录后重试！");
//            获取访问拦截到的 uri
            request.getSession().setAttribute("requestPath", request.getRequestURI());
//            注意，虽然是转发，但是呢，转发之后的 req 已经不是现在这个了，是服务端自己新建的 req 再次请求的
            request.getRequestDispatcher(request.getContextPath() + "/toLogin").forward(request, response);
        }
        else
        {
//            对用户帐号进行验证，是否正确
            if (USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword()))
            {
                flag = true;
            }
        }
        return flag;
    }
}
