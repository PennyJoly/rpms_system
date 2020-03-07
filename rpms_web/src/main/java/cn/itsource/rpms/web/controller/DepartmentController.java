package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.Department;
import cn.itsource.rpms.common.query.DepartmentQuery;
import cn.itsource.rpms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<Department> findList(@RequestBody DepartmentQuery departmentQuery){
        return departmentService.query(departmentQuery);
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Department query(@PathVariable("id") Long id){
        return departmentService.findOne(id);
    }

    /**
     * 保存
     * @param department
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody Department department){
        try {
            departmentService.save(department);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param department
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody Department department){
        try {
            departmentService.update(department);
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
            departmentService.delete(id);
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
            departmentService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
