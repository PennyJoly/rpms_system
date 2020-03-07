package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.RepairdOrder;
import cn.itsource.rpms.common.domain.SettledOrder;
import cn.itsource.rpms.common.query.SettledOrderQuery;
import cn.itsource.rpms.service.ISettledOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/settledOrder")
@CrossOrigin
public class SettledOrderController {

    @Autowired
    private ISettledOrderService settledOrderService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<SettledOrder> findList(@RequestBody SettledOrderQuery settledOrderQuery){
       return settledOrderService.query(settledOrderQuery);
    }

    /**
     * 查询所有已录入结算单
     * @return
     */
    @RequestMapping(value = "/exist",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<SettledOrder> findExist(@RequestBody SettledOrderQuery settledOrderQuery){
        return settledOrderService.query(settledOrderQuery);
    }

    /**
     * 保存结算维修单
     * @param settledOrder
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody SettledOrder settledOrder){
        try {
            //settledOrderService.save(settledOrder);
            settledOrderService.updateStatusAndSave(settledOrder);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("结算失败！");
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
            settledOrderService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("取消失败！");
        }
    }

    //批量删除
    @RequestMapping(value = "/batchDelete",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult batchDelete(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id = ids.split(",");
        try {
            settledOrderService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量取消失败！");
        }
    }
}
