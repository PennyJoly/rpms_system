package cn.itsource.rpms.mapper;

import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.rpms.common.domain.Permission;
import cn.itsource.rpms.common.domain.Role;

import java.util.List;

/*
*  系统权限管理
* */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> roleFindpermission(Long id);
    //查询menu对应的permission
    List<Permission> finds(Long id);

}
