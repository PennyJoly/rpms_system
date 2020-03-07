package cn.itsource.rpms.service.impl;

import cn.itsource.basic.service.impl.BaseServiceImpl;
import cn.itsource.rpms.common.domain.Menu;
import cn.itsource.rpms.common.domain.Permission;
import cn.itsource.rpms.mapper.MenuMapper;
import cn.itsource.rpms.mapper.PermissionMapper;
import cn.itsource.rpms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    @Override
    public List<Menu> parent() {
        return menuMapper.parent();
    }

    @Override
    public void deletes(Serializable[] ids) {
        for (Serializable id : ids) {
            String s = id.toString();
            Long aLong = Long.valueOf(s);
            deletePlus(aLong);
        }
    }

    @Override
    public StringBuilder findAllByPermission() {
        List<Menu> list = menuMapper.findAllMenu();
        HashSet<Menu> children = new HashSet<>();
        HashSet<Menu> parent = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        list.stream().filter(p -> p.getParent_id() != null).forEach(children::add
        );

        list.stream().filter(p -> p.getParent_id() == null).forEach(parent::add
        );
        builder.append("[");
        for (Menu s:parent) {
            builder.append("{path: '").append("/").append("',component:`./views/").append("Home").append(".vue`,name: '").append(s.getName()).append("',iconCls: '").append(s.getIcon()).append("',children: [");
            for (Menu c:children) {
                if(c.getParent_id().getName().equals(s.getName()))
                    builder.append("{ path: '").append(c.getSn()).append("', component:`./views").append(c.getUrl()).append(".vue`, name: '").append(c.getName()).append("',iconCls: '").append(c.getIcon()).append("' },");
            }
            builder.append("]},");
        }
        builder.append("]");
        return builder;
    }

    @Override
    public void deletePlus(Long id) {
        Menu one = menuMapper.findOne(id);
        if(one.getParent_id()==null){
            List<Permission> finds = permissionMapper.finds(id);
            for (Permission find : finds) {
                Long id1 = find.getId();
                //先删除permission对应的中间表
                menuMapper.deleteBetween(id1);
            }
            //先删除父菜单对应的子菜单
            menuMapper.deletePermission(id);
            //先删除父菜单对应的子菜单
            menuMapper.deleteChildren(id);
            //最后删除自己
            menuMapper.delete(id);

        }else{
            menuMapper.delete(id);
        }
    }
}

