package cn.itsource.rpms.service;

import cn.itsource.basic.service.IBaseService;
import cn.itsource.rpms.common.domain.Permission;

import java.util.List;

public interface IPermissionService extends IBaseService<Permission> {
    List<Permission> roleFindpermission(Long id);

}
