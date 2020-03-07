package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.Menu;
import cn.itsource.rpms.common.query.MenuQuery;
import cn.itsource.rpms.service.IMenuService;
import javafx.beans.binding.StringBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private IMenuService menuService;
    /*
    *   所有的菜单不分页  //查询所有菜单分页
    List<Menu> findAllMenu();
    * */
    @RequestMapping(value = "/permission",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public StringBuilder permission(){
       return menuService.findAllByPermission();
    }
    /*
     *  下拉列表的查询所有父菜单
     * */
    @RequestMapping(value = "parent",method = RequestMethod.PATCH)
    @ResponseBody
    public List<Menu> parent(){
        return menuService.parent();
    }
    /*
    *  下拉列表的查询所有
    * */
    @RequestMapping(value = "all",method = RequestMethod.PATCH)
    @ResponseBody
    public List<Menu> all(){
        return menuService.findAll();
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<Menu> findList(@RequestBody MenuQuery MenuQuery){

        return menuService.query(MenuQuery);
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Menu query(@PathVariable("id") Long id){
        return menuService.findOne(id);
    }

    /**
     * 保存
     * @param menu
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody Menu menu){
        try {
            menuService.save(menu);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param Menu
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody Menu Menu){
        try {
            menuService.update(Menu);
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
            menuService.deletePlus(id);
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
            menuService.deletes(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
