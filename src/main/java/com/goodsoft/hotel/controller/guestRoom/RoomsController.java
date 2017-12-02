package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.restaurantReservation.PageBean;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.formula.functions.T;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 王智 on 2017/11/9/009.
 *
 * 房态信息
 */

@RestController
public class RoomsController {


    @Resource
    private RoomSDao roomSDao;

    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);


    /**
     * 添加实时房间价格
     * @param rtrp
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("floor/realTime/price")
    public Object realTimePrice(@RequestBody RealTimeRoomParameter rtrp){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RoomSDao mapper = sqlSession.getMapper(RoomSDao.class);
        //插入list
        List<RealTimeRoomPrice> realTimeRoomPrices=new ArrayList<RealTimeRoomPrice>(100);

        for(int i=0;i<rtrp.getMsg().size();i++){
            for(int j=0;j<rtrp.getMsg().get(i).getRealTimeRooms().size();j++){
                rtrp.getMsg().get(i).getRealTimeRooms().get(j).setTime(rtrp.getMsg().get(i).getTime());
                realTimeRoomPrices.add(rtrp.getMsg().get(i).getRealTimeRooms().get(j));
            }
        }

        try {
            Integer deleteNum = mapper.deleteAllRealTimePrice();
            Integer insertNum = mapper.insertRoomRealTimePrice(realTimeRoomPrices);
            mapper.deleteErrorRoomRealTimePrice();
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
    }


    /**
     * 查询所有实时房价设置
     * @param time
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/select/RealTimePrice")
    public Object selectRealTimePrice(String time){
        List<RealTimeRoomPriceParam> realTimeRoomPriceParamList=null;
        try {
            List<RealTimeRoomPrice> realTimeRoomPrices = roomSDao.selectRoomRealTimePrice(null);
            realTimeRoomPriceParamList = joinRealTimePrice(realTimeRoomPrices);
        }catch (Exception e){
            e.printStackTrace();
        }
        return realTimeRoomPriceParamList;
    }


    //分类实时房价信息
    private List<RealTimeRoomPriceParam> joinRealTimePrice(List<RealTimeRoomPrice> reals){

        List<RealTimeRoomPriceParam> returnList=new LinkedList<RealTimeRoomPriceParam>();
        for(int i=0;i<reals.size();i++){

            if(reals.get(i)!=null){
                List<RealTimeRoomPrice> real=new LinkedList<RealTimeRoomPrice>();
                RealTimeRoomPriceParam realtime=new RealTimeRoomPriceParam();
                realtime.setTime(reals.get(i).getTime());
                real.add(reals.get(i));
                for (int j = i + 1; j < reals.size(); j++) {
                    if(reals.get(j)!=null) {
                        if (reals.get(j).getTime() != null && reals.get(j).getTime().equals(reals.get(i).getTime())) {
                            real.add(reals.get(j));
                            reals.set(j, null);
                        }
                    }
                }
                realtime.setRealTimeRooms(real);
                returnList.add(realtime);
                reals.set(i,null);
            }
        }

        return returnList;
    }



    /**
     * ****************************************************************************************
     *                                      房态信息  开始
     * *****************************************************************************************
     */

    /**
     * 房态:获取房间房态信息 --主页面
     *
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomType")
    public Object getFang(){
        List<Map<String, Object>> list = null;

        //参数map
        Map<String,Object> paramMap =new HashMap<String,Object>();

        try {
            List<Map<String, Object>> list1 = roomSDao.queryFloorRoomMapper(paramMap);
            return joinTypeRoom(list1);
        } catch (Exception e) {
            e.printStackTrace();
           return new Status(StatusEnum.ERROR.getCODE(),StatusEnum.ERROR.getEXPLAIN());
        }

    }



    /**
     * 2017-11-30 分类?
     * @param list
     * @return
     */
    private List<Map> joinTypeRoom(List<Map<String,Object>> list) {

        List<Map> returnList=new LinkedList<Map>();

        for(int i=0;i<list.size();i++){
            if(list.get(i)!=null) {

                Map typeMap =new HashMap();
                List typeList =new LinkedList();
                typeList.add(list.get(i));
                for (int j = i + 1; j < list.size(); j++) {
                if(list.get(j)!=null && list.get(i).get("floorname").equals(list.get(j).get("floorname"))){
                    typeList.add(list.get(j));
                    list.set(j,null);
                }
                }
                typeMap.put("type",list.get(i).get("floorname"));
                typeMap.put("typeList",typeList);
                list.set(i,null);
                returnList.add(typeMap);
            }
        }


        return returnList;
    }


    /**
     *房态 : 返回房态右边的楼层信息
     * @return 右边下拉框中 楼层的信信息 OR 错误状态码
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/floorName/FangTai")
    public Object findFloorAll(){
        try {
            List<Floors> list = this.roomSDao.findFloorAllMapper();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }



    /**
     * 房态 : 通过右边楼层名 获取到房间信息  --不合理
     * @param floorCode 下拉框中的楼层名字对应的编号
     * @return 房间信息 OR 错误代码
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/floorName/room")
    public Object findRoomGetFloorName(String floorCode){
        try {
            return this.roomSDao.findFloorNameGetRoomMapper(floorCode);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 房间类型所有信息
     *房态右边下拉框房间类型
     * @return 房间类型
     * 2017-11-29
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName")
    public Object getAllRoomType() {
        try {
            return this.roomSDao.queryRoomTypeMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 房态 : 通过右边房间类型 获取到房间信息  --不合理
     * @param roomType 获取到右边下拉框信息
     * @return 返回房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/roomTypeName/room")
    public Object findRoomGetRoomType(String roomType){
        try {
            return this.roomSDao.queryRoomTypeGetRoomMapper(roomType);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 房态:前台查询的获取--还没编写
     *
     * @param strs  前台传递的参数
     * @return  房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/find")
    public Object findFangTai(@Param("strs") String strs) {
        String str = "";
        if(strs != null && !("".equals(strs))){
            str = strs.trim();
        }
        System.out.println(str);
        StringBuffer sb = new StringBuffer("");
        for(int i = 0;i<str.length();i++){
            sb.append(str.charAt(i));
            if(i<str.length()-1){
                sb.append("%");
            }
        }
        System.out.println(String.valueOf(sb));
        try {
            return this.roomSDao.queryFuzzyRoomMapper(String.valueOf(sb));
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }

    }


    /**
     * ****************************************************************************************
     *                                      房态信息 结束
     * *****************************************************************************************
     */

    /**
     * ****************************************************************************************
     *                                      预定房态  开始
     * *****************************************************************************************
     */



    /**
     * 预定:预定页面中 点击房间号之后显示的页面,左边的列表
     *
     * @return 房间类型信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/room")
    public Object findRoomType() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return this.roomSDao.queryRoomALLMapper();
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * * 预定:预定页面中 点击房间号之后显示的页面,右边的房间号
     * 预定:传递空房信息  获取类型id 动态传递
     * 根据选择的房间类型 查看空房信息
     * @param typeId 预定页面中 点击房间号之后显示的页面,左边的列表 复选框中的ID
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/kong")
    public Object getKongAll(@Param("typeId") String typeId) {
        List<Map<String, Object>> list = null;
        List<Map<String, Object>> map = new ArrayList<>();
        List<Integer> typeIds = null;
        try {
            String[] arr = {};
            if (typeId.trim() != null && typeId.trim() != ""){
                arr = typeId.split(",");
            }
            typeIds = new ArrayList<Integer>();
            for (int i = 0; i < arr.length; i++) {
                int s = Integer.parseInt(arr[i]);
                typeIds.add(s);
            }
            map = this.roomSDao.selectKongMapper(typeIds);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        return map;
    }


    /**
     * ****************************************************************************************
     *                                      预定房态  结束
     * *****************************************************************************************
     */

    /**
     * 添加建筑--未完成
     *
     * @param buildingCode 自己编的代码
     * @param buildingName 建筑的名称
     * @throws Exception
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertBuilding")
    public void insertBuild(String buildingCode, String buildingName) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        Building buildings = new Building();
        buildings.setId(ID);
        buildings.setBuildingCode(buildingCode);
        buildings.setBuildingName(buildingName);
        this.roomSDao.insertBuild(buildings);
    }

    /**
     * 添加楼层信息---未完成
     *
     * @param floorCode 楼层的编号代码
     * @param floorName 楼层的名称
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertFloor")
    public void insertFloor(String floorCode, String floorName) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        Floors floors = new Floors();
        floors.setId(ID);
        floors.setFloorCode(floorCode);
        floors.setFloorName(floorName);
        this.roomSDao.insertFloor(floors);
    }

    /**
     * 添加房间类型信息--未完成
     *
     * @param roomType
     * @param roomName
     * @param housePrices
     * @throws Exception
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("insertRoomType")
    public void insertRoomType(String roomType, String roomName, String housePrices) throws Exception {
        String ID = UUIDUtil.getInstance().getUUID().toString();
        RoomType room = new RoomType();
        room.setId(ID);
        room.setRoomType(roomType.trim());
        room.setTypeName(roomName.trim());
        room.setHousePrices(housePrices.trim());
        this.roomSDao.insertRoomType(room);
    }

    /**
     * 测试接口--添加房间详细信息--未完成
     *
     *
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("insertRoom")
    public void insertRoom(@RequestBody Room room) {
        String uuid = UUIDUtil.getInstance().getUUID().toString();

        room.setId(uuid);


    }


    /**
     * 修改建筑--未完成
     *
     * @param map
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("updateBuilding")
    public Status updateBuild(@RequestBody Building map) {
        try {
            System.out.println(map.getBuildingName());
            return new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(),StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * ****************************************************************************************
     *                                      快速分房  开始
     * *****************************************************************************************
     */
    /**
     * 快速分房右边的房类信息的接口  快速分房 (页面修改为工作流展示该接口联通但未使用)
     * @return 房类信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/roomType")
    public List<RoomType> fenFangFangLei(){
        List<RoomType> list = this.roomSDao.findRoomTypeFenFangMapper();
        return list;
    }

    /**
     * 快速分房右边的建筑的接口  快速分房 (页面修改为工作流展示该接口联通但未使用)
     * @param roomType 房类的类型编号
     * @return 建筑信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Building")
    public List<Building> fenFangBuild(@Param("roomType") String roomType){
        List<Building> list = null;
        if(roomType !=null && !("".equals(roomType))){
            list = this.roomSDao.findBuildingFenFangMapper(roomType);
        }
        return list;
    }

    /**
     * 快速分房右边的楼层的接口 快速分房 (页面修改为工作流展示该接口联通但未使用)
     * @param buildingCode 建筑的编号
     * @return 楼层信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Floors")
    public List<Floors> fenFangFloors(String buildingCode ) {
        System.out.println(buildingCode);
        List<Floors> list = null;
        if(buildingCode !=null && !("".equals(buildingCode))){
            list = this.roomSDao.findFloorsFenFangMapper(buildingCode);
        }
        return list;
    }

    /**
     *
     *快速分房筛选的房态信息  快速分房 (页面修改为工作流展示该接口没有联通使用)
     *
     * @param roomType  房间类型
     * @param buildingCode 建筑编号
     * @param floorCode 楼层编号
     * @param flag 状态
     * @param startDate 预抵日期
     * @param endDate 离店日期
     * @return  房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Rooms")
    public Map fenFangRooms(String roomType,String buildingCode,String floorCode,String flag,String sflag, String startDate,String endDate){
            Map<String,String> map = new HashMap<String, String>();
            if(roomType !=null && !("".equals(roomType))){
                map.put("roomType",roomType);
            }
            if(buildingCode !=null && !("".equals(buildingCode))){
                map.put("buildingCode",buildingCode);
            }
            if(floorCode !=null && !("".equals(floorCode))){
                map.put("floorCode",floorCode);
            }
            if(flag !=null && !("".equals(flag))){
                map.put("flag",flag);
            }
            if(sflag !=null && !("".equals(sflag))){
                map.put("sflag",sflag);
            }
            if(startDate !=null && !("".equals(startDate))){
                map.put("startDate",startDate);
            }
            if(endDate !=null && !("".equals(endDate))){
                map.put("endDate",endDate);
            }

        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
            this.roomSDao.findRoomFenFangMapper(map);
            return map;
    }

    /**
     * ****************************************************************************************
     *                                      快速分房  ENDS
     * *****************************************************************************************
     */



    /**
     * 判断当前日期是星期几
     * @param pTime 需要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public  static  int  dayForWeek(String pTime) throws  Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd" );
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int  dayForWeek = 0 ;
        if (c.get(Calendar.DAY_OF_WEEK) == 1 ){
            dayForWeek = 7 ;
        }else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1 ;
        }
        return  dayForWeek;
    }


    /**
     * 保存房价信息---没有接通  房价政策
     * @param roomPrices
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("rooms/roomsPrices")
    public Map addRoomPrices(@RequestBody List<RoomPrices> roomPrices){
        String uuid = UUIDUtil.getInstance().getUUID().toString();
//        roomPrices.setId(uuid);
        for (RoomPrices r:roomPrices
             ) {
            System.out.println(r.toString());
        }
        Map<String,String> map = null;
        System.out.println(roomPrices.toString());
        map.put("success","数据获取");
        try {
//            this.roomSDao.addRoomPricesMapper(roomPrices);
//            map.put("success","0");
//            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
//            map.put("error","500");
//            map.put("msg",e.getMessage());
        }
        return map;
    }
}
