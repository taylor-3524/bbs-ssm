package com.controller;

import com.dto.MainPostsAndUsers;
import com.entity.Mainposts;
import com.github.pagehelper.PageInfo;
import com.service.IMainPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView cshow(@RequestParam(value = "nowPage",required = false) Integer c_nowPage){
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
}
