package com.drpeng.pengxin.common.intercepter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drpeng.pengxin.common.util.ObjectUtils;
import com.drpeng.pengxin.common.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by huan.liu on 2016/4/13.
 */

public class LoggerIntercepter
        extends HandlerInterceptorAdapter
{
    private static Logger logger = LoggerFactory.getLogger(LoggerIntercepter.class);
    private String[] excludeUrls;

    public String[] getExcludeUrls()
    {
        return this.excludeUrls;
    }

    public void setExcludeUrls(String[] excludeUrls)
    {
        this.excludeUrls = excludeUrls;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        super.afterCompletion(request, response, handler, ex);
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception
    {
        super.postHandle(request, response, handler, modelAndView);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        String ip = WebUtils.getIpAddr(request);

        String path = request.getContextPath() + request.getServletPath();
        if (!ObjectUtils.isNull(this.excludeUrls)) {
            for (String url : this.excludeUrls) {
                if (path.contains(url)) {
                    return true;
                }
            }
        }
        StringBuffer buffer = new StringBuffer("");
        Enumeration<String> enume = request.getParameterNames();
        while (enume.hasMoreElements())
        {
            String key = (String)enume.nextElement();
            String[] value = request.getParameterValues(key);
            if (buffer.toString().length() > 0) {
                buffer.append("  ");
            }
            buffer.append(key).append("=").append(Arrays.toString(value));
        }
        logger.info("++user_access_log,ip=" + ip +  ",url=" + path + ",parameter:" + buffer);
        return true;
    }
}
