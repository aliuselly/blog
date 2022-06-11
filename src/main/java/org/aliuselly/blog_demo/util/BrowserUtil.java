package org.aliuselly.blog_demo.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户从 request 请求中获取客户端的操作系统、浏览器以及版本信息
 */
public class BrowserUtil {

    /**
     * 获取操作系统，浏览器及浏览器版本信息
     * @return
     */
    public static String getOsAndBrowserInfo(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");
        String user = userAgent.toLowerCase();

        String os = "";
        String browser = "";

//        os info
        if (user.indexOf("windows") >= 0)
        {
            os = "Windows";
        }
        else if (user.indexOf("mac") >= 0)
        {
            os = "Mac";
        }
        else if (user.indexOf("android") >= 0)
        {
            os = "Android";
        }
        else if (user.indexOf("iphone") >= 0)
        {
            os = "iphone";
        }
        else if (user.indexOf("x11") >= 0)
        {
            os = "Unix";
        }
        else
        {
            os = "UnKnown, More-Info: " + userAgent;
        }

//        browser info
        if (user.contains("edge"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
        }
        else if (user.contains("msie"))
        {
            String substring = (userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0]);
            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
        }
        else if (user.contains("safari") && user.contains("version"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                    + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[0];
        }
        else if (user.contains("opr") || user.contains("opera"))
        {
            if (user.contains("opera"))
            {
                browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                        + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            }
            else
            {
                browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                        .replace("OPR", "Opera");
            }
        }
        else if (user.contains("chrome"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        }
        else if ((userAgent.indexOf("mozilla/7.0") > -1) ||
                            (userAgent.indexOf("netscape6") != -1) ||
                            (userAgent.indexOf("mozilla/4.7") != -1) ||
                            (userAgent.indexOf("mozilla/4.78") != -1) ||
                            (userAgent.indexOf("mozilla/4.08") != -1) ||
                            (userAgent.indexOf("mozilla/3") != -1))
        {
            browser = "Netscape-?";
        }
        else if (user.contains("firefox"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        }
        else if (user.contains("rv"))
        {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            browser = "IE" + IEVersion.substring(0, IEVersion.length() - 1);
        }
        else
        {
            browser = "Unknown, More-Info: " + userAgent;
        }
        return os + "-" + browser;
    }
}
