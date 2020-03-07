package cn.itsource.rpms.service;


import cn.itsource.basic.service.IBaseService;
import cn.itsource.rpms.common.domain.User;

public interface IUserService extends IBaseService<User> {
   User findByUserName(String userName);
}
