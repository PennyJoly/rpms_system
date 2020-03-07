package cn.itsource.rpms.mapper;


import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.rpms.common.domain.User;

/**
 * 用户mapper
 */
public interface UserMapper extends BaseMapper<User> {
    //根据用户查询用户
    User findByUserName(String userName);
}
