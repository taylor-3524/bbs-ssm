package com.controller;

import com.dto.MainPostsAndUsers;
import com.entity.Mainposts;
import com.entity.Users;
import com.github.pagehelper.PageInfo;
import com.service.IMainPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class MainPostsController {

    @Autowired
    private IMainPostsService mainPostsService;

    /**
     * 展示主贴
     * @param c_nowPage
     * @return
     */
    @RequestMapping("/show")
    public ModelAndView cshow(
            @RequestParam(value = "nowPage",required = false) Integer c_nowPage
            /*,HttpSession session*/){
        /*Users u=(Users) session.getAttribute("user");*/
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/mainPosts/index");
        Integer nowPage=1;
        Integer count=3;
        if(c_nowPage!=null){
            nowPage=c_nowPage;
        }
        PageInfo<MainPostsAndUsers> pageInfo=mainPostsService.sgetMainPostsAndUsers(nowPage,count);
        modelAndView.addObject("list",pageInfo.getList());
        modelAndView.addObject("allPages",pageInfo.getPages());
        return modelAndView;
    }

    /**
     * 发表主贴(coding)
     * @param c_title
     * @param c_content
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView cadd(
            @RequestParam(value = "title",required = true)String c_title,
            @RequestParam(value = "content",required = true)String c_content){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/discuss/index");


        return modelAndView;
    }
}
