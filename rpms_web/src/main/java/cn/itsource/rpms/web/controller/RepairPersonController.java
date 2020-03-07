package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.RepairPerson;
import cn.itsource.rpms.common.query.RepairPersonQuery;
import cn.itsource.rpms.service.IRepairPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/repairPerson")
@CrossOrigin
public class RepairPersonController {

    @Autowired
    private IRepairPersonService  repairPersonService;

    /**
     * 查询无分页维修人员列表数据
     * @return
     */
    @RequestMapping(value="/page",method= RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public List<RepairPerson> list(){
        return repairPersonService.findAll();
    }

    /**
     * 查询所有
     * @return
     */

    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public PageList<RepairPerson> findList(@RequestBody RepairPersonQuery repairPersonQuery){
        return repairPersonService.query(repairPersonQuery);
    }
    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public RepairPerson query(@PathVariable("id") Long id){
        return repairPersonService.findOne(id);
    }

    /**
     * 保存
     * @param repairPerson
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody RepairPerson repairPerson){
        try {
            repairPerson.setHireDate(new Date());
           repairPersonService.save(repairPerson);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param repairPerson
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody RepairPerson repairPerson){
        try {
          repairPersonService.update(repairPerson);
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
           repairPersonService.delete(id);
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
            repairPersonService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
