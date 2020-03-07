package cn.itsource.rpms.service;

import cn.itsource.basic.service.IBaseService;
import cn.itsource.rpms.common.domain.Role;

import java.io.Serializable;
import java.util.List;

public interface IRoleService extends IBaseService<Role> {
    //新增
    void saveRolePermisison(Role role);
    //删除
    void deleteRole(Long roleId);
    //修改
    void updateRole(Role role);
    //查询全部包括permission
    List<Role> findAllRole();

    //批量删除角色
    void deleteRolePermissions(Serializable[] ids);
}
