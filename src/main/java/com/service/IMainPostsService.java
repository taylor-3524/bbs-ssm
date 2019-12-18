package com.service;

import com.dto.MainPostsAndUsers;
import com.entity.Mainposts;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMainPostsService {
    public PageInfo<MainPostsAndUsers> sgetMainPostsAndUsers(Integer nowPage, Integer count);
}
