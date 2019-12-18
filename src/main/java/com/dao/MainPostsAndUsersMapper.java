package com.dao;

import com.dto.MainPostsAndUsers;
import com.service.impl.MainPostsService;

import java.util.List;

public interface MainPostsAndUsersMapper {
    public List<MainPostsAndUsers> selectAllInfo(MainPostsAndUsers mainPostsAndUsers);

}
