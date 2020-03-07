package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.RepairdOrderItems;
import cn.itsource.rpms.common.query.RepairdOrderItemsQuery;
import cn.itsource.rpms.service.IRepairdOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/repairdOrderItems")
@CrossOrigin
public class RepairdOrderItemsController {

    @Autowired
    private IRepairdOrderItemsService repairdOrderItemsService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public PageList<RepairdOrderItems> findList(@RequestBody RepairdOrderItemsQuery repairdOrderItemsQuery){
        return repairdOrderItemsService.query(repairdOrderItemsQuery);
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public RepairdOrderItems query(@PathVariable("id") Long id){
        return repairdOrderItemsService.findOne(id);
    }

    /**
     * 保存
     * @param repairdOrderItems
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public AjaxResult save(@RequestBody RepairdOrderItems repairdOrderItems){
        try {
            repairdOrderItemsService.save(repairdOrderItems);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param repairdOrderItems
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public AjaxResult update(@RequestBody RepairdOrderItems repairdOrderItems){
        try {
            repairdOrderItemsService.update(repairdOrderItems);
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
    @CrossOrigin
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            repairdOrderItemsService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败！");
        }
    }

    //批量删除
    @RequestMapping(value = "/batchDelete",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public AjaxResult batchDelete(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id = ids.split(",");
        try {
            repairdOrderItemsService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
