package cn.itsource.rpms.service.impl;

import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.rpms.common.domain.Permission;
import cn.itsource.rpms.common.domain.Role;
import cn.itsource.rpms.mapper.RoleMapper;
import cn.itsource.rpms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    /*
    *  保存角色的方法
    * */
    @Override
    public void saveRolePermisison(Role role) {
        //保存角色 role 这个表
        roleMapper.save(role);
        //方案二: 批量新增 insert into  t_role_permission(role_id,permission_id) values(1,1),(1,2)
        List<Map<String,Object>> rplist=new ArrayList<>();
        List<Permission> permissions=role.getPermissions();
        for (Permission permission : permissions) {
            Long pid=permission.getId();
            Long rid=role.getId();
            System.out.println(pid);
            System.out.println(rid);
            Map rpMap = new HashMap();
            rpMap.put("roleId",rid);
            rpMap.put("permissionId",pid);
            rplist.add(rpMap);
        }
        roleMapper.saveRolePermission(rplist);
    }
    /*
    *  批量删除角色
    * */

    /*
    *  删除角色的方法
    * */
    @Override
    public void deleteRole(Long roleId) {

        //删除角色对应的中间表
        roleMapper.deleteRolePermission(roleId);
        //删除角色 role
        roleMapper.delete(roleId);
    }
    /*
    *  修改角色的方法
    * */
    @Override
    public void updateRole(Role role) {
        //先删除角色
        deleteRole(role.getId());
        //再重新添加
        saveRolePermisison(role);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    public void deleteRolePermissions(Serializable[] ids) {

        for (Serializable id : ids) {
            String s = id.toString();
            Long aLong = Long.valueOf(s);
            deleteRole(aLong);
        }
        //再删除对应的role
        roleMapper.batchDelete(ids);
    }
}
