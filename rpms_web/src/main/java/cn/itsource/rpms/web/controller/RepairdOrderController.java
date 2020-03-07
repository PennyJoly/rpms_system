package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.RepairdOrder;
import cn.itsource.rpms.common.query.RepairdOrderQuery;
import cn.itsource.rpms.service.IRepairdOrderItemsService;
import cn.itsource.rpms.service.IRepairdOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/repairdOrder")
@CrossOrigin
public class RepairdOrderController {

    @Autowired
    private IRepairdOrderService repairdOrderService;
    @Autowired
    private IRepairdOrderItemsService repairdOrderItemsService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public PageList<RepairdOrder> findList(@RequestBody RepairdOrderQuery repairdOrderQuery){
        return repairdOrderService.query(repairdOrderQuery);
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public RepairdOrder query(@PathVariable("id") Long id){
        return repairdOrderService.findOne(id);
    }

    /**
     * 保存
     * @param repairdOrder
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public AjaxResult save(@RequestBody RepairdOrder repairdOrder){
        try {
            //设置时间
            repairdOrder.setCreateTime(new Date());
            repairdOrder.setStatus(false);
            repairdOrderService.save(repairdOrder);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param repairdOrder
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public AjaxResult update(@RequestBody RepairdOrder repairdOrder){
        try {
            repairdOrderService.update(repairdOrder);
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
            repairdOrderService.delete(id);
            //根据 维修单号 mainId，删除关联的明细
            repairdOrderItemsService.removeByMainId(id);
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
    public AjaxResult batchDelete(@RequestBody List<RepairdOrder> repairdOrders ){
        try {
            for (RepairdOrder repairdOrder : repairdOrders) {
                repairdOrderService.delete(repairdOrder.getId());
                //根据 维修单号 mainId，批量删除关联的明细
                repairdOrderItemsService.removeByMainId(repairdOrder.getId());
            }

            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }

}
