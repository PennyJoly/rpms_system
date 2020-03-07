package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.PayType;
import cn.itsource.rpms.common.query.PayTypeQuery;
import cn.itsource.rpms.common.query.RepairdOrderQuery;
import cn.itsource.rpms.service.IPayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payType")
@CrossOrigin
public class PayTypeController {

    @Autowired
    private IPayTypeService payTypeService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    public PageList<PayType> findList(@RequestBody PayTypeQuery payTypeQuery){
        return payTypeService.query(payTypeQuery);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.PATCH)
    @ResponseBody
    public List<PayType> findPage(){
        return payTypeService.findAll();
    }

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public PayType query(@PathVariable("id") Long id){
        return payTypeService.findOne(id);
    }

    /**
     * 保存
     * @param 
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody PayType payType){
        try {
           payTypeService.save(payType);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param payType
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody PayType payType){
        try {
           payTypeService.update(payType);
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
           payTypeService.delete(id);
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
           payTypeService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
