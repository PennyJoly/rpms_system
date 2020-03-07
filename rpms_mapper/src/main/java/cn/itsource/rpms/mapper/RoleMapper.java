package cn.itsource.rpms.mapper;


import cn.itsource.basic.mapper.BaseMapper;
import cn.itsource.rpms.common.domain.Role;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role> {
    //保存方法 List<RolePermsion>
    void saveRolePermission(List<Map<String,Object>>list);
    //删除方法
    void deleteRolePermission(Long roleId);
    //查询所有包括角色对应的权限的方法
    List<Role> findAllRole();

}
