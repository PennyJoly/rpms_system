package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.basic.util.PageList;
import cn.itsource.rpms.common.domain.Parts;
import cn.itsource.rpms.common.query.PartsQuery;
import cn.itsource.rpms.service.IPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/parts")
@CrossOrigin
public class PartsController {

    @Autowired
    private IPartsService partsService;

    /**
     * 查询所有
     * @return
     */

    @RequestMapping(value = "/list",method = RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public PageList<Parts> findList(@RequestBody PartsQuery partsQuery){
        return partsService.query(partsQuery);
    }

    /**
     * 查询无分页维修配件列表数据
     * @return
     */
    @RequestMapping(value="/page",method= RequestMethod.PATCH)
    @ResponseBody
    @CrossOrigin
    public List<Parts> list(){
        return partsService.findAll();
    }
    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Parts query(@PathVariable("id") Long id){
        return partsService.findOne(id);
    }

    /**
     * 保存
     * @param parts
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult save(@RequestBody Parts parts){
        try {
            parts.setCreateTime(new Date());
           partsService.save(parts);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败！");
        }
    }

    /**
     * 修改
     * @param parts
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestBody Parts parts){
        try {
          partsService.update(parts);
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
           partsService.delete(id);
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
            partsService.batchDelete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("批量删除失败！");
        }
    }
}
