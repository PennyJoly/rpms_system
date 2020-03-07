package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.Menu;
import cn.itsource.rpms.common.domain.Permission;
import cn.itsource.rpms.common.query.PermissionQuery;
import cn.itsource.rpms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    /*
    *  不分页查询全部
    * */
    @RequestMapping(value = "/all",method = RequestMethod.PATCH)
    @ResponseBody
    public List<Permission> findAll(){
        return permissionService.findAll();
    }
    /*
    *   查询角色对应的权限
    * */
    @RequestMapping(value = "/role",method = RequestMethod.PATCH)
    @ResponseBody
    public List<Permission> roleFindpermission(@PathVariable("id") Long id){
        System.out.println(id);
        return permissionService.roleFindpermission(id);
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<Permission> findList(@RequestBody PermissionQuery permissionQuery){
        System.out.println(permissionService.query(permissionQuery));
        return permissionService.query(permissionQuery);
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Permission query(@PathVariable("id") Long id){
        return permissionService.findOne(id);
    }
    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody Permission permission){
        //System.out.println(permission);

        try {
            Long menu = permission.getMenu();
            Menu menu1 = new Menu(menu);
            permission.setMn(menu1);
            System.out.println(menu);
            System.out.println("----------");
           // permission.setMn(menu);


            //System.out.println(mn);
            permissionService.save(permission);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }
    /**
     * 修改
     * @param permission
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody Permission permission){
        try {
            permissionService.update(permission);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("修改失败！");
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            permissionService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败！");
        }
    }

    //批量删除
    @RequestMapping(value = "/batchDelete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult batchDelete(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id = ids.split(",");
        try {
            permissionService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}

