package cn.itsource.rpms.service.impl;

import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.basic.util.MD5Util;
import cn.itsource.rpms.common.domain.User;
import cn.itsource.rpms.mapper.UserMapper;
import cn.itsource.rpms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        //密码加盐
        user.setPassword(MD5Util.createMd5(user.getPassword()));
        super.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
