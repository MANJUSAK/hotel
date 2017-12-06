package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.entity.param.UserParam;
import com.goodsoft.hotel.domain.entity.restaurantReservation.*;
import com.goodsoft.hotel.service.UserService;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by duyuxiang on 2017/11/13.
 * 餐饮预订
 */

@Controller
public class CyReserveController {

    @Resource
    CyReserveDao cyReserveDao;

    @Resource
    UserService userService;

    //预订主页面
    @RequestMapping("/reserve")
    public ModelAndView reserveHome(PageBean<FitReservation> pageBean,Integer sign,String state,String staetTime,String loginUser){
        ModelAndView model=new ModelAndView("views/restaurantReservation.jsp");
        UserParam userParam=new UserParam();
        userParam.setKeyWord("前台业务员");
        try {
            model.addObject("salesman", userService.queryUserMsgService(userParam));
        } catch (Exception e){
            e.printStackTrace();
        }

        model.addObject("loginUser",loginUser);
        //参数map
        Map<String,Object> paramMap =new HashMap<String,Object>();
        //返回list
        List<FitReservation> returnList =null;
        if(state!=null && !"".equals(state)){
            paramMap.put("state",state);
            model.addObject("state",state);
        }else {
            paramMap.put("state", "1");
        }

        if(staetTime==null){
            paramMap.put("staetTime",formatDate(new Date()));
        }else{
            model.addObject("staetTime",staetTime);
        }

        paramMap.put("limit",pageBean.getCurrentPage()*pageBean.getPageSize()-pageBean.getPageSize());
        paramMap.put("length",pageBean.getPageSize());

        if(sign==null){
            pageBean.setRecordTotal(cyReserveDao.selectSkReservesNum(paramMap));pageBean.otherAttr();
            List<FitReservation> fitReservations = cyReserveDao.selectSkReserves(paramMap);
            returnList=fitReservations;
        }else{
            switch (sign){
                case 1:
                    pageBean.setRecordTotal(cyReserveDao.selectSkReservesNum(paramMap));
                    returnList = cyReserveDao.selectSkReserves(paramMap);
                    break;
                case 2:
                    pageBean.setRecordTotal(cyReserveDao.selectJxReservesNum(paramMap));
                    returnList = cyReserveDao.selectJxReserves(paramMap);
                    break;
                case 3:
                    pageBean.setRecordTotal(cyReserveDao.selectYhReservesNum(paramMap));
                    returnList = cyReserveDao.selectYhReserves(paramMap);
                    break;
            }
            model.addObject("sign",sign);
        }

        pageBean.setContent(returnList);
        model.addObject("pageBean",pageBean);
        return model;
    }


    //查询预订信息
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("/restaurantReservation/select/reserves")
    @ResponseBody
    public List<FitReservation> selectreserves(PageBean<FitReservation> pageBean,Integer sign,String staetTime){
     //参数map
     Map paramMap =new HashMap();
     //返回list
     List<FitReservation> returnList =null;

     if(staetTime==null){
         paramMap.put("staetTime",formatDate(new Date()));
     }


     paramMap.put("state","1");
     paramMap.put("limit",pageBean.getCurrentPage());
     paramMap.put("length",pageBean.getPageSize());

     switch (sign){
         case 1 :returnList=cyReserveDao.selectSkReserves(paramMap);break;
         case 2 :returnList=cyReserveDao.selectJxReserves(paramMap);break;
         case 3 :returnList=cyReserveDao.selectYhReserves(paramMap);break;
     }
        return returnList;
    }


     //查询单条预订信息
     @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
     @RequestMapping("/restaurantReservation/selectReserveInfo")
     @ResponseBody
     public Object selectReserveInfo(String reserveId){

         Map map=new HashMap();
         FitReservation fitReservation = cyReserveDao.selectSkReserveById(reserveId);
         List<ReservationHalls> reservationHalls = cyReserveDao.selectReserveHalls(reserveId);
         map.put("reserve",fitReservation);
         map.put("halls",reservationHalls);
         return map;
     }

    //查询单条酒席预订信息
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/restaurantReservation/selectJxReserveInfo")
    @ResponseBody
    public Object selectJxReserveInfo(String reserveId){

        Map map=new HashMap();
        BanquetReservation banquetReservation = cyReserveDao.selectJxReserveById(reserveId);
        List<ReservationHalls> reservationHalls = cyReserveDao.selectReserveHalls(reserveId);
        map.put("reserve",banquetReservation);
        map.put("halls",reservationHalls);
        return map;
    }

    //查询单条酒席预订信息
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/restaurantReservation/selectYhReserveInfo")
    @ResponseBody
    public Object selectYhReserveInfo(String reserveId){

        Map map=new HashMap();
        YanhuiReservation yanhuiReservation = cyReserveDao.selectYhReserveById(reserveId);
        List<ReservationHalls> reservationHalls = cyReserveDao.selectReserveHalls(reserveId);
        map.put("reserve",yanhuiReservation);
        map.put("halls",reservationHalls);
        return map;
    }




    //新增散客预订提交
    @RequestMapping("/addreserve")
    public String addreserve(FitReservation fitReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
    , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model){

        StringBuilder uuid = UUIDUtil.getInstance().getUUID();
        fitReservation.setId(uuid.toString());
        fitReservation.setState("1");
        //插入预订信息
        Integer integer = cyReserveDao.insertReserveInfo(fitReservation);
        System.out.println("插入预订信息:"+integer);
        if(integer!=null && integer!=0){
            List<ReservationHalls> list=new LinkedList<ReservationHalls>();
            Integer integer1=0;
            if(reserve_hall!=null && reserve_hall.length!=0) {
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res=new ReservationHalls();
                    res.setReserve_id(uuid.toString());
                    res.setReserve_hall(reserve_hall[i]);
                    res.setTable_id(reserve_table[i]);
                    res.setReserve_start_time(reserve_start_time[i]);
                    res.setReserve_end_time(reserve_end_time[i]);
                    res.setShibie(shibie[i]);
                    res.setReserve_hall_status("1");
                    System.out.println(res);
                    list.add(res);
                }
                integer1 = cyReserveDao.insertReserveHalls(list);
            }
            System.out.println("插入厅台:"+integer1);
            model.addAttribute("addResult","添加成功");
        }else{
            model.addAttribute("addResult","添加失败");
        }

        return "forward:/reserve";
    }


    //新增酒席预订提交
    @RequestMapping("/addJxreserve")
    public String addJxreserve(BanquetReservation banquetReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
            , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model) {
        StringBuilder uuid = UUIDUtil.getInstance().getUUID();
        banquetReservation.setId(uuid.toString());
        banquetReservation.setState("1");
        Integer integer = cyReserveDao.insertJxReserveInfo(banquetReservation);
        if (integer > 0){
        List list = new LinkedList();
        System.out.println(banquetReservation);
            if(reserve_hall!=null && reserve_hall.length!=0) {
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res = new ReservationHalls();
                    res.setReserve_id(uuid.toString());
                    res.setReserve_hall(reserve_hall[i]);
                    res.setTable_id(reserve_table[i]);
                    res.setReserve_start_time(reserve_start_time[i]);
                    res.setShibie(shibie[i]);
                    res.setReserve_hall_status("1");
                    res.setReserve_end_time(reserve_end_time[i]);
                    list.add(res);
                }
                Integer integer1 = cyReserveDao.insertReserveHalls(list);
            }

           if(integer>0){
               model.addAttribute("addResult","添加成功");
           }else{
               model.addAttribute("addResult","添加失败");
           }
        }
        return "forward:/reserve?sign=2";
    }


    //新增宴会预订提交
    @RequestMapping("/addYhreserve")
    public String addYhreserve(YanhuiReservation yanhuiReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
            , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model){

        StringBuilder uuid = UUIDUtil.getInstance().getUUID();
        yanhuiReservation.setId(uuid.toString());
        yanhuiReservation.setState("1");
        Integer integer = cyReserveDao.insertYhReserveInfo(yanhuiReservation);
        if (integer > 0){
            List list = new LinkedList();
            if(reserve_hall!=null && reserve_hall.length!=0) {
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res = new ReservationHalls();
                    res.setTable_id(reserve_table[i]);
                    res.setReserve_start_time(reserve_start_time[i]);
                    res.setReserve_end_time(reserve_end_time[i]);
                    res.setShibie(shibie[i]);
                    res.setReserve_id(uuid.toString());
                    res.setReserve_hall(reserve_hall[i]);
                    res.setReserve_hall_status("1");
                    list.add(res);
                }
                Integer integer1 = cyReserveDao.insertReserveHalls(list);
            }

            if(integer>0){
                model.addAttribute("addResult","添加成功");
            }else{
                model.addAttribute("addResult","添加失败");
            }
        }
        return "forward:/reserve?sign=3";
    }



    //修改散客预订信息
    @RequestMapping("updateReserve")
    public String updatereserve(FitReservation fitReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
            , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model) {

        Integer integer = cyReserveDao.updateReserveInfo(fitReservation);

            List<ReservationHalls> list = new LinkedList<ReservationHalls>();
            Integer integer1 = 0;
            if (reserve_hall != null && reserve_hall.length != 0) {
                cyReserveDao.deleteReserveHalls(fitReservation.getId());
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res = new ReservationHalls();
                    res.setReserve_hall(reserve_hall[i]);
                    res.setReserve_table("");
                    res.setTable_id(reserve_table[i]);
                    res.setReserve_id(fitReservation.getId());
                    res.setReserve_start_time(reserve_start_time[i]);
                    res.setReserve_end_time(reserve_end_time[i]);
                    res.setShibie(shibie[i]);
                    res.setReserve_hall_status("1");
                    System.out.println(res.toString());
                    list.add(res);
                }
                Integer integer2 = cyReserveDao.insertReserveHalls(list);
                if(integer2!=0){
                model.addAttribute("addResult","修改成功");
                }else{
                model.addAttribute("addResult","修改失败");
                }
            }

        return "forward:/reserve";
    }


    //修改酒席预订信息
    @RequestMapping("updateJxReserve")
    public String updateJxreserve(BanquetReservation banquetReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
            , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model) {

        Integer integer = cyReserveDao.updateJxReserveInfo(banquetReservation);

        LinkedList list = new LinkedList();
        if (integer > 0) {
            cyReserveDao.deleteReserveHalls(banquetReservation.getId());
            if (reserve_hall != null && reserve_hall.length != 0) {
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res1 = new ReservationHalls();
                    res1.setReserve_hall(reserve_hall[i]);
                    res1.setReserve_table("");
                    res1.setTable_id(reserve_table[i]);
                    res1.setReserve_id(banquetReservation.getId());
                    res1.setReserve_start_time(reserve_start_time[i]);
                    res1.setReserve_end_time(reserve_end_time[i]);
                    res1.setShibie(shibie[i]);
                    res1.setReserve_hall_status("1");
                    list.add(res1);
                }
                Integer integer1 = cyReserveDao.insertReserveHalls(list);
                if(integer1!=0){
                    model.addAttribute("addResult","修改成功");
                }else{
                    model.addAttribute("addResult","修改失败");
                }
            }
        }
        return "forward:/reserve?sign=2";
    }


    //修改宴会预订信息
    @RequestMapping("updateYhReserve")
    public String updateYhReserve(YanhuiReservation yanhuiReservation, String reserve_hall[], String reserve_table[], String reserve_start_time[]
            , String [] reserve_end_time, String [] shibie, String [] reserve_hall_status, Model model) {

        Integer integer = cyReserveDao.updateYhReserveInfo(yanhuiReservation);
        LinkedList list = new LinkedList();
        if (integer > 0) {
            cyReserveDao.deleteReserveHalls(yanhuiReservation.getId());
            if (reserve_hall != null && reserve_hall.length != 0) {
                for (int i = 0; i < reserve_hall.length; i++) {
                    ReservationHalls res1 = new ReservationHalls();
                    res1.setReserve_hall(reserve_hall[i]);
                    res1.setReserve_table("");
                    res1.setReserve_end_time(reserve_end_time[i]);
                    res1.setShibie(shibie[i]);
                    res1.setReserve_hall_status("1");
                    res1.setTable_id(reserve_table[i]);
                    res1.setReserve_id(yanhuiReservation.getId());
                    res1.setReserve_start_time(reserve_start_time[i]);
                    list.add(res1);
                }
                Integer integer1 = cyReserveDao.insertReserveHalls(list);
                if(integer1!=0){
                    model.addAttribute("addResult","修改成功");
                }else{
                    model.addAttribute("addResult","修改失败");
                }
            }
        }
        return "forward:/reserve?sign=3";
    }



    //修改散客预订单状态
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateReserveState")
    @ResponseBody
    public Object updateReserveState(String state,String [] reserveIds){
       Map paramMap=new HashMap();
       List<String> paramList=new ArrayList<String>();
       for(int i=0;i<reserveIds.length;i++){
           paramList.add(reserveIds[i]);
       }
       paramMap.put("state",state);
       paramMap.put("reserveIds",paramList);
        Integer integer = cyReserveDao.updateReserveState(paramMap);
        Map returnMap=new HashMap();
        if(integer!=0){
            returnMap.put("result","修改成功");
        }else{
            returnMap.put("result","修改失败");
        }
        return returnMap;
    }

    //修改酒席预订单状态
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateJxReserveState")
    @ResponseBody
    public Object updateJxReserveState(String state,String [] reserveIds){
        Map paramMap=new HashMap();
        List<String> paramList=new ArrayList<String>();
        for(int i=0;i<reserveIds.length;i++){
            paramList.add(reserveIds[i]);
        }
        paramMap.put("state",state);
        paramMap.put("reserveIds",paramList);
        Integer integer = cyReserveDao.updateJxReserveState(paramMap);
        Map returnMap=new HashMap();
        if(integer!=0){
            returnMap.put("result","修改成功");
        }else{
            returnMap.put("result","修改失败");
        }
        return returnMap;
    }

    //修改宴会预订单状态
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateYhReserveState")
    @ResponseBody
    public Object updateYhReserveState(String state,String [] reserveIds){
        Map paramMap=new HashMap();
        List<String> paramList=new ArrayList<String>();
        for(int i=0;i<reserveIds.length;i++){
            paramList.add(reserveIds[i]);
        }
        paramMap.put("state",state);
        paramMap.put("reserveIds",paramList);
        Integer integer = cyReserveDao.updateYhReserveState(paramMap);
        Map returnMap=new HashMap();
        if(integer!=0){
            returnMap.put("result","修改成功");
        }else{
            returnMap.put("result","修改失败");
        }
        return returnMap;
    }



    //修改散客预订单取消原因
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateReserveReason")
    @ResponseBody
    public Object updateReserveReason(String cancellationReason ,String [] reserveIds){
        Map paramMap =new HashMap();
        List list=new LinkedList();
        paramMap.put("cancellationReason",cancellationReason);
        for(int i=0;i<reserveIds.length;i++){
            list.add(reserveIds[i]);
            cyReserveDao.updateReserveHallState("0",reserveIds[i]);
        }
        paramMap.put("reserveIds",list);
        Integer integer = cyReserveDao.updateReserveReason(paramMap);
        return integer;
    }

    //修改酒席预订单取消原因
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateJxReserveReason")
    @ResponseBody
    public Object updateJxReserveReason(String cancellationReason ,String [] reserveIds){
        Map paramMap =new HashMap();
        List list=new LinkedList();
        paramMap.put("cancellationReasons",cancellationReason);
        for(int i=0;i<reserveIds.length;i++){
            list.add(reserveIds[i]);
            cyReserveDao.updateReserveHallState("0",reserveIds[i]);
        }
        paramMap.put("reserveIds",list);
        Integer integer = cyReserveDao.updateJxReserveReason(paramMap);

        return integer;
    }

    //修改宴会预订单取消原因
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateYhReserveReason")
    @ResponseBody
    public Object updateYhReserveReason(String cancellationReason ,String [] reserveIds){
        Map paramMap =new HashMap();
        List list=new LinkedList();
        paramMap.put("cancellationReasons",cancellationReason);
        for(int i=0;i<reserveIds.length;i++){
            list.add(reserveIds[i]);
            cyReserveDao.updateReserveHallState("0",reserveIds[i]);
        }
        paramMap.put("reserveIds",list);
        Integer integer = cyReserveDao.updateYhReserveReason(paramMap);
        return integer;
    }



    //判断预订厅台时间是否重复
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/restaurantReservation/joinTableAndDate")
    @ResponseBody
    public Object joinTableAndDate(String tableId,String startTime){
        Integer integer = cyReserveDao.joinTableAndDate(tableId, startTime);
        return integer;
    }


    //获取所有分厅
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/restaurantReservation/selectHalls")
    @ResponseBody
    public Object  selectHalls(){
        List<Map> maps = cyReserveDao.selectHalls();
        return maps;
    }


    //获取分厅所有餐台
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/restaurantReservation/selectTablesByHall")
    @ResponseBody
    public Object  selectTablesByHall(String hallId){
        return cyReserveDao.selectTablesByHall(hallId);
    }


   private String formatDate(Date date){
       SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd 00:00");
        return sf.format(date);
   }

}
