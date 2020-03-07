package cn.itsource.rpms.service;

import cn.itsource.basic.service.IBaseService;
import cn.itsource.rpms.common.domain.Menu;
import cn.itsource.rpms.common.domain.Permission;
import java.io.Serializable;
import java.util.List;

public interface IMenuService extends IBaseService<Menu> {
    //查询所有菜单分页
    List<Menu> findAllMenu();
    //查询所有的父菜单
    List<Menu> parent();
    //删除包括关联
    void deletePlus(Long id);
    //批量删除
    void deletes(Serializable[] ids);
    //动态路由
    StringBuilder findAllByPermission();

}
