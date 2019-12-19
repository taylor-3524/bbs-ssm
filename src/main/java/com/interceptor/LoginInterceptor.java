package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

       String url = httpServletRequest.getRequestURI();
       System.out.println("url:"+url);
         if (!url.equals("/bbs_ssm_war_exploded/login/index")
         &&!url.equals("/bbs_ssm_war_exploded/login/login")
         ) {
            //不是登录页面
            HttpSession session = httpServletRequest.getSession();
            if (session.getAttribute("user") != null) {
                //已登录
                return true;
            }else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/index");
                //未登录
                return false;
            }
        }
         //是登录页面
        return true;
    }

    /**
     * 在处理过程中，执行拦截
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 执行完毕，返回前拦截
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
