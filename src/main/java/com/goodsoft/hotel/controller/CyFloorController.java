package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.dao.CyReserveDao;
import com.goodsoft.hotel.domain.dao.CyFloorDao;
import com.goodsoft.hotel.domain.dao.RepastOrderDao;
import com.goodsoft.hotel.domain.entity.floor.Diningtable;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Cache;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by duyuxiang on 2017/11/17
 * 餐饮楼面
 */
@Controller
public class CyFloorController {


    @Resource
    private CyFloorDao cyFloorDao;

    @Resource
    private CyReserveDao cyReserveDao;

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Resource
    private RepastOrderDao repastOrderDao;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Calendar calendar=Calendar.getInstance();

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
        List<Map> infos = cyFloorDao.selectTableInfos(paramMap);
        System.out.println(infos.toString());
        List<Map> returnList=new LinkedList<Map>();

        for(int i=0;i<infos.size();i++){
            Map returnMap =new HashMap();
            if(infos.get(i)!=null){
                List<Map> fMap =new LinkedList<Map>();
                fMap.add(infos.get(i));
                for (int j = i + 1; j < infos.size(); j++){
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


    //查询楼面信息
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/select/halls")
    @ResponseBody
    public Object selectHalls(String hallId,String hallName,String state,String timeZone){
        Map<String,Object> paramMap =new HashMap<String,Object>();
        List<Map> infos =null;

        if(hallId!=null && !"".equals(hallId)){
            paramMap.put("hallId",hallId);
        }
        if(hallName!=null && !"".equals(hallName)){
            paramMap.put("hallName",hallName);
        }
        if(state!=null && !"".equals(state)){
            paramMap.put("state",state);
        }
        if(timeZone!=null &&!"".equals(timeZone)){
            paramMap.put("timeZone",timeZone);
        }
        try {
            infos = cyFloorDao.selectTableInfos(paramMap);
        }catch (Exception e){
            return new Status(StatusEnum.DEFEAT.getCODE(),StatusEnum.DEFEAT.getEXPLAIN());
        }

        List<Map> returnList=arrangementHalls(infos);
        return  new Result(StatusEnum.SUCCESS.getCODE(),returnList);
    }


    //查询餐台各状态数量
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/select/table/stateNumber")
    @ResponseBody
    public Object tableStateNumber(){
        Map<String, Integer> stringIntegerMap=null;
        try {
             stringIntegerMap = cyFloorDao.selectTableStateForNumber();
        }catch (Exception e){
            return new Status(StatusEnum.DEFEAT.getCODE(),StatusEnum.DEFEAT.getEXPLAIN());
        }
            return new Result(StatusEnum.SUCCESS.getCODE(),stringIntegerMap);
    }



    //分类厅堂信息
    public List<Map> arrangementHalls(List<Map> infos){
        //返回list
        List<Map> returnList=new LinkedList<Map>();

        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        CyFloorDao mapper = sqlSession.getMapper(CyFloorDao.class);
        try {
            for (int i = 0; i < infos.size(); i++){
                Map returnMap = new HashMap();
                if (infos.get(i) != null){
                    List<Map> fMap = new LinkedList<Map>();
                    //判断餐台是否有预订信息
                    if(infos.get(i).get("reserveId")!=null&&!"".equals(infos.get(i).get("reserveId")) ){
                        if(String.valueOf(infos.get(i).get("status")).equals("1")) {
                            infos.get(i).put("status", "3");
                            mapper.updateTableState(String.valueOf(infos.get(i).get("id")), "3");
                        }
                    }
                    //判断超过预定时间 未开台
                    if(String.valueOf(infos.get(i).get("status")).equals("3") && infos.get(i).get("reserveId")==null){
                        infos.get(i).put("status", "1");
                        mapper.updateTableState(String.valueOf(infos.get(i).get("id")), "1");
                    }
                    //判断订单超时未买单
                    if(infos.get(i).get("orderNumber")!=null&&!"".equals(infos.get(i).get("orderNumber")) && infos.get(i).get("ktTime")!=null ){
                        String ktTime=String.valueOf(infos.get(i).get("ktTime"));
                        Date parse = sf.parse(ktTime);
                        if(joinDateOfHour(parse)){
                            infos.get(i).put("status","6");
                            mapper.updateOrderStatusDao(String.valueOf(infos.get(i).get("orderNumber")));
                            mapper.updateTableState(String.valueOf(infos.get(i).get("id")), "6");
                        }
                    }

                    fMap.add(infos.get(i));
                    for (int j = i + 1; j < infos.size(); j++){
                        if (infos.get(j) != null && infos.get(i).get("hall_name").equals(infos.get(j).get("hall_name"))) {
                            //判断餐台是否有预订信息
                            if(infos.get(j).get("reserveId")!=null&&!"".equals(infos.get(j).get("reserveId"))){
                                if(String.valueOf(infos.get(j).get("status")).equals("1")) {
                                    infos.get(j).put("status", "3");
                                    mapper.updateTableState(String.valueOf(infos.get(j).get("id")), "3");
                                }
                            }
                            //判断超过预定时间 未开台
                            if(String.valueOf(infos.get(j).get("status")).equals("3") && infos.get(j).get("reserveId")==null) {
                                infos.get(j).put("status", "1");
                                mapper.updateTableState(String.valueOf(infos.get(j).get("id")), "1");
                            }
                            //判断餐台订单是否买单超时
                            if(infos.get(j).get("orderNumber")!=null&&!"".equals(infos.get(j).get("orderNumber")) && infos.get(j).get("ktTime")!=null ){
                                String ktTime=String.valueOf(infos.get(j).get("ktTime"));
                                Date parse = sf.parse(ktTime);
                                if(joinDateOfHour(parse)){
                                    infos.get(j).put("status","6");
                                    mapper.updateTableState(String.valueOf(infos.get(j).get("id")), "6");
                                    mapper.updateOrderStatusDao(String.valueOf(infos.get(j).get("orderNumber")));
                                }
                            }
                            fMap.add(infos.get(j));
                            infos.set(j, null);
                        }
                    }
                    returnMap.put("hall_name", infos.get(i).get("hall_name"));
                    returnMap.put("hallList", fMap);
                    returnList.add(returnMap);
                    infos.set(i, null);
                }
            }
        sqlSession.commit();
        }catch (Exception e){
         e.printStackTrace();
         logger.error("分类餐台信息出错");
         sqlSession.rollback();
        }finally {
         sqlSession.close();
        }
        return returnList;
    }



    //判断传入时间与当前时间相差5小时
    private boolean joinDateOfHour(Date date){
        Date da=new Date();
      if((da.getTime()-date.getTime())/(3600*1000)>5){
          return true;
      }
          return false;
    }



    //修改餐台状态与订单状态
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/update/table/state")
    @ResponseBody
    public Object updateTableState(String tableId ,String orderId){
        try {
            cyFloorDao.updateTableState(tableId, "1");
            repastOrderDao.deleteRepastOrderDao(orderId);
        }catch (Exception e){
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }


    /**
     * 获取当前厅台所有空闲餐厅
     * @param tableId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/select/freeTable")
    @ResponseBody
    public Object selectFreeTable(String tableId){

         if(tableId!=null && !"".equals(tableId)) {
             try {
                 List<Diningtable> diningtables = cyFloorDao.selectFreeTables(tableId);
                 return new Result(StatusEnum.SUCCESS.getCODE(), diningtables);
             } catch (Exception e) {
                 e.printStackTrace();
                 return new Result(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
             }
         }else{
             return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
         }
    }


    /**
     *
     * @param orderId      订单编号
     * @param currentTable 当前餐台id
     * @param transTable   换至餐台id
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/update/transform")
    @ResponseBody
    public Object transformTable(String orderId,String currentTable,String transTable){
        if(orderId!=null && currentTable!=null && transTable!=null){
            SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
            CyFloorDao mapper = sqlSession.getMapper(CyFloorDao.class);
            try{
                mapper.updateOrderTable(transTable,orderId);
                mapper.updateTableState(currentTable,"1");
                mapper.updateTableState(transTable,"8");
                sqlSession.commit();
                return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
            }catch (Exception e){
                e.printStackTrace();
                sqlSession.rollback();
                return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
            }
        }else{
            return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }

    }

}
