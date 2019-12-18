package com.service.impl;


import com.dao.MainPostsAndUsersMapper;
import com.dao.MainpostsMapper;
import com.dto.MainPostsAndUsers;
import com.entity.Mainposts;
import com.entity.MainpostsExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IMainPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPostsService implements IMainPostsService {

    @Autowired
    private MainPostsAndUsersMapper mainPostsAndUsersMapper;
    @Autowired
    private MainPostsAndUsers mainPostsAndUsers;


    @Override
    public PageInfo<MainPostsAndUsers> sgetMainPostsAndUsers(Integer nowPage,Integer count){
        PageHelper.startPage(nowPage,count);
        List<MainPostsAndUsers> list=mainPostsAndUsersMapper.selectAllInfo(mainPostsAndUsers);
        PageInfo<MainPostsAndUsers> pageInfo=new PageInfo<MainPostsAndUsers>(list);

        return pageInfo;
    }
}
