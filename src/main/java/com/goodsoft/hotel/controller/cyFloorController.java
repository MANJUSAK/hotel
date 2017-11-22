package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.CyFloorDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/11/17.
 * 餐饮楼面
 */
@Controller
public class cyFloorController {


    @Resource
    CyFloorDao CyFloorDao;

    @Resource
    CyReserveDao cyReserveDao;


    //楼面主页面
    @RequestMapping("floor")
    public ModelAndView floorPage(String hallId,String hallName){
        ModelAndView model=new ModelAndView("floor/floor.jsp");
        Map paramMap =new HashMap();
        if(hallId!=null && !"".equals(hallId)){
            paramMap.put("hallId",hallId);
            model.addObject("optionHallId",hallId);
        }
        if(hallName!=null && !"".equals(hallName)){
            paramMap.put("hallName",hallName);
        }


        List<Map> infos = CyFloorDao.selectTableInfos(paramMap);
        System.out.println(infos.toString());

        List<Map> returnList=new LinkedList<Map>();

        for(int i=0;i<infos.size();i++){
            Map returnMap =new HashMap();
            if(infos.get(i)!=null) {
                List<Map> fMap =new LinkedList<Map>();
                fMap.add(infos.get(i));
                for (int j = i + 1; j < infos.size(); j++) {
                    if (infos.get(j)!=null && infos.get(i).get("hall_name").equals(infos.get(j).get("hall_name"))) {
                    fMap.add(infos.get(j));
                        infos.set(j,null);
                    }
                }
                returnMap.put("hall_name",infos.get(i).get("hall_name"));

                returnMap.put("hallList",fMap);
                returnList.add(returnMap);
                infos.set(i,null);
            }
        }
     System.out.println(returnList);
     model.addObject("halls",returnList);
     return model;
    }






}
