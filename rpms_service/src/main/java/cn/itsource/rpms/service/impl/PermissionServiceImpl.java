package cn.itsource.rpms.service.impl;

import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.rpms.common.domain.Permission;
import cn.itsource.rpms.mapper.PermissionMapper;
import cn.itsource.rpms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> roleFindpermission(Long id) {
        return permissionMapper.roleFindpermission(id);
    }
}
