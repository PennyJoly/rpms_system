package cn.itsource.rpms.web.controller;

import cn.itsource.rpms.common.domain.SettledOrderWs;
import cn.itsource.rpms.service.ISettledOrderWsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/settledOrderWs")
@CrossOrigin
public class SettledOrderWsController {

    @Autowired
    private ISettledOrderWsService settledOrderWsService;

    /**
     * 查询一条
     * @param id
     * @return
     */
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<SettledOrderWs> query(@PathVariable("id") Long id){
        List<SettledOrderWs> list = new ArrayList<>();
        list.add(settledOrderWsService.findOne(id));
        return list;
    }
}
