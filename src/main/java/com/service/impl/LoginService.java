package com.service.impl;

import com.dao.UsersMapper;
import com.entity.Users;
import com.entity.UsersExample;

import com.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public boolean login(Users users) {
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria().andUsernameEqualTo(users.getUsername());
        List<Users> users1=usersMapper.selectByExample(usersExample);
        if(users1.isEmpty()){
            //没有这个用户名
            return false;
        }
        return users1.get(0).getPsw().equals(users.getPsw());
    }
}
