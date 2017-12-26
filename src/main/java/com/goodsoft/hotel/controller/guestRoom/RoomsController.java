package com.goodsoft.hotel.controller.guestRoom;

import com.goodsoft.hotel.controller.CookBookController;
import com.goodsoft.hotel.domain.dao.guestRoom.BookingDao;
import com.goodsoft.hotel.domain.dao.guestRoom.KfCheckOutDao;
import com.goodsoft.hotel.domain.dao.guestRoom.RoomSDao;
import com.goodsoft.hotel.domain.entity.guestRoom.*;
import com.goodsoft.hotel.domain.entity.restaurantReservation.PageBean;
import com.goodsoft.hotel.domain.entity.result.Result;
import com.goodsoft.hotel.domain.entity.result.Status;
import com.goodsoft.hotel.domain.entity.result.StatusEnum;
import com.goodsoft.hotel.util.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 王智 on 2017/11/9/009.
 * <p>
 * 房态信息
 */

@RestController
public class RoomsController {


    @Resource
    private RoomSDao roomSDao;

    @Resource
    private BookingDao bookingDao;

    @Resource
    private KfCheckOutDao kfCheckOutDao;

    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    //实例化日志管理工具类
    private Logger logger = LoggerFactory.getLogger(CookBookController.class);

    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 添加实时房间价格
     *
     * @param rtrp
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("floor/realTime/price")
    public Object realTimePrice(@RequestBody RealTimeRoomParameter rtrp) {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        RoomSDao mapper = sqlSession.getMapper(RoomSDao.class);
        //插入list
        List<RealTimeRoomPrice> realTimeRoomPrices = new ArrayList<RealTimeRoomPrice>(100);

        for (int i = 0; i < rtrp.getMsg().size(); i++) {
            for (int j = 0; j < rtrp.getMsg().get(i).getRealTimeRooms().size(); j++) {
                rtrp.getMsg().get(i).getRealTimeRooms().get(j).setTime(rtrp.getMsg().get(i).getTime());
                realTimeRoomPrices.add(rtrp.getMsg().get(i).getRealTimeRooms().get(j));
            }
        }

        try {
            Integer deleteNum = mapper.deleteAllRealTimePrice();
            Integer insertNum = mapper.insertRoomRealTimePrice(realTimeRoomPrices);
            mapper.deleteErrorRoomRealTimePrice();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }finally {
            sqlSession.close();
        }
        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
    }


    /**
     * 查询所有实时房价设置
     *
     * @param time
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/select/RealTimePrice")
    public Object selectRealTimePrice(String time) {
        List<RealTimeRoomPriceParam> realTimeRoomPriceParamList = null;
        try {
            List<RealTimeRoomPrice> realTimeRoomPrices = roomSDao.selectRoomRealTimePrice(null);
            realTimeRoomPriceParamList = joinRealTimePrice(realTimeRoomPrices);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realTimeRoomPriceParamList;
    }


    //分类实时房价信息
    private List<RealTimeRoomPriceParam> joinRealTimePrice(List<RealTimeRoomPrice> reals) {

        List<RealTimeRoomPriceParam> returnList = new LinkedList<RealTimeRoomPriceParam>();
        for (int i = 0; i < reals.size(); i++) {

            if (reals.get(i) != null) {
                List<RealTimeRoomPrice> real = new LinkedList<RealTimeRoomPrice>();
                RealTimeRoomPriceParam realtime = new RealTimeRoomPriceParam();
                realtime.setTime(reals.get(i).getTime());
                real.add(reals.get(i));
                for (int j = i + 1; j < reals.size(); j++) {
                    if (reals.get(j) != null) {
                        if (reals.get(j).getTime() != null && reals.get(j).getTime().equals(reals.get(i).getTime())) {
                            real.add(reals.get(j));
                            reals.set(j, null);
                        }
                    }
                }
                realtime.setRealTimeRooms(real);
                returnList.add(realtime);
                reals.set(i, null);
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
    @RequestMapping("floor/select/roomInfo")
    public Object getFang(String floorId, String typeId, String price, Integer sign, String selectedDate, Integer sflag, Integer cflag, Integer flag, Integer yflag) {

        if (sign != null && sign <= 3 && sign > 0) {
            //获取所有楼层id
            List<Integer> integers = roomSDao.selectFloorIdAll();
            if (integers.size() > 30) {
                int y = sign == 1 ? 10 : sign == 2 ? 20 : integers.size();
                int m = sign == 1 ? 0 : sign == 2 ? 10 : 20;
                floorId = "";
                for (int x = m; x < y; x++) {
                    floorId += (integers.get(x) + (x == (y - 1) ? "" : ","));
                }
            }
        }

        List<Map<String, Object>> list = null;
        //参数map
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (floorId != null && !"".equals(floorId)) {
            paramMap.put("floorId", floorId);
        }
        if (typeId != null && !"".equals(typeId)) {
            paramMap.put("typeId", typeId);
        }
        List<RealStateResult> list1 = new ArrayList<RealStateResult>(1000);

        try {
            list1 = roomSDao.queryFloorRoomMapper(paramMap);
            List<Map<String, String>> strings = roomSDao.selectRoomReservesAll();
            if (list1.size() == 0) {
                return new Result(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
            List<Map> maps = joinTypeRoom(list1, price, strings, sflag, cflag, flag, yflag, selectedDate);
            if (maps.size() == 0) {
                return new Result(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            }
            return new Result(StatusEnum.SUCCESS.getCODE(), maps);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }


    /**
     * 分类客房信息
     *
     * @param list
     * @return
     */
    private List<Map> joinTypeRoom(List<RealStateResult> list, String price, List<Map<String, String>> reserveRooms, Integer sflag, Integer cflag, Integer flag, Integer yflag, String selectedDate) {
        List<Map> returnList = new LinkedList<Map>();
        String day = sf.format(new Date());
        //实时房价
        ArrayList<Map> maps = roomSDao.selectImmediateRoomPrice();
        Object realPrice = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                //判断是否有实时房价
                realPrice = judgeRealTimePrice(maps, list.get(i).getTypeid());
                if (realPrice != null) {
                    list.get(i).setHouseprices(String.valueOf(realPrice));
                }
                //判断是否区分价格
                if (price != null && !price.equals(list.get(i).getHouseprices())) {
                    continue;
                }
                //判断是否区分脏房净房
                if (sflag != null) {
                    if (sflag == 1) {
                        if (!"净房".equals(list.get(i).getSflag())) {
                            continue;
                        }
                    } else if (sflag == 2) {
                        if (!"脏房".equals(list.get(i).getSflag())) {
                            continue;
                        }
                    }
                }
                //客房是否有预订信息 并判断时间
                if ("明确预定".equals(list.get(i).getBookingflag()) && list.get(i).getStartdate() != null && list.get(i).getStartdate().equals(day)) {
                    list.get(i).setCflag("预抵");
                } else {
                    if (cflag != null && cflag == 1) {
                        continue;
                    }
                }
                if (list.get(i).getEnddate() != null && list.get(i).getBookingflag() != null && list.get(i).getEnddate().equals(day) && (list.get(i).getBookingflag().equals("部分入住") || list.get(i).getBookingflag().equals("全部入住"))) {
                    list.get(i).setCflag("预离");
                } else {
                    if (cflag != null && cflag == 2) {
                        continue;
                    }
                }

                //判断客房今天以后是否有预订
                for (int s = 0; s < reserveRooms.size(); s++) {
                    if (selectedDate == null) {
                        if (list.get(i).getRoomno().equals(reserveRooms.get(s).get("roomno"))) {
                            list.get(i).setYflag("1");
                            s = 99999;
                        }
                    } else {
                        if (list.get(i).getRoomno().equals(reserveRooms.get(s).get("roomno")) && selectedDate.equals(reserveRooms.get(s).get("startdate"))) {
                            list.get(i).setYflag("1");
                            s = 99999;
                        }
                    }
                }
                //判断是否过滤预留
                if (yflag != null && yflag == 1) {
                    if ("0".equals(list.get(i).getYflag())) {
                        continue;
                    }
                }
                //判断是否过滤flag
                if (flag != null) {
                    if (flag == 1) {
                        if (!"空房".equals(list.get(i).getFlag()))
                            continue;
                    } else if (flag == 2) {
                        if (!"散客".equals(list.get(i).getFlag()) && !"团体".equals(list.get(i).getFlag()))
                            continue;
                    } else if (flag == 3) {
                        if (!"维修".equals(list.get(i).getFlag()))
                            continue;
                    } else if (flag == 4) {
                        if (!"停用".equals(list.get(i).getFlag()))
                            continue;
                    }
                }


                Map typeMap = new HashMap();
                List typeList = new LinkedList();
                typeList.add(list.get(i));
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) != null && list.get(i).getFloorname().equals(list.get(j).getFloorname())) {

                        //判断是否有实时房价
                        realPrice = judgeRealTimePrice(maps, list.get(j).getTypeid());
                        if (realPrice != null) {
                            list.get(j).setHouseprices(String.valueOf(realPrice));
                        }
                        //判断是否区分价格
                        if (price != null && !price.equals(list.get(j).getHouseprices())) {
                            continue;
                        }
                        //判断是否区分脏房净房
                        if (sflag != null) {
                            if (sflag == 2) {
                                if (!"脏房".equals(list.get(j).getSflag())) {
                                    continue;
                                }
                            } else if (sflag == 1) {
                                if (!"净房".equals(list.get(j).getSflag())) {
                                    continue;
                                }
                            }
                        }

                        //客房是否有预订信息 并判断时间
                        if ("明确预定".equals(list.get(j).getBookingflag()) && list.get(j).getStartdate() != null && list.get(j).getStartdate().equals(day)) {
                            list.get(j).setCflag("预抵");
                        } else {
                            if (cflag != null && cflag == 1) {
                                continue;
                            }
                        }
                        if (list.get(j).getEnddate() != null && list.get(j).getBookingflag() != null && list.get(j).getEnddate().equals(day) && (list.get(j).getBookingflag().equals("部分入住") || list.get(j).getBookingflag().equals("全部入住"))) {
                            list.get(j).setCflag("预离");
                        } else {
                            if (cflag != null && cflag == 2) {
                                continue;
                            }
                        }

                        //客房今天以后是否有预订
                        for (int s = 0; s < reserveRooms.size(); s++) {
                            if (selectedDate == null) {
                                if (list.get(j).getRoomno().equals(reserveRooms.get(s).get("roomno"))) {
                                    list.get(j).setYflag("1");
                                    s = 99999;
                                }
                            } else {
                                if (selectedDate.equals(reserveRooms.get(s).get("startdate")) && list.get(j).getRoomno().equals(reserveRooms.get(s).get("roomno"))) {
                                    list.get(j).setYflag("1");
                                    s = 99999;
                                }
                            }
                        }
                        //判断是否过滤预留
                        if (yflag != null && yflag == 1) {
                            if ("0".equals(list.get(j).getYflag())) {
                                continue;
                            }
                        }
                        //判断是否过滤flag
                        if (flag != null) {
                            if (flag == 1) {
                                if (!"空房".equals(list.get(j).getFlag()))
                                    continue;
                            } else if (flag == 3) {
                                if (!"维修".equals(list.get(j).getFlag()))
                                    continue;
                            } else if (flag == 4) {
                                if (!"停用".equals(list.get(j).getFlag()))
                                    continue;
                            } else if (flag == 2) {
                                if (!"散客".equals(list.get(j).getFlag()) && !"团体".equals(list.get(j).getFlag()))
                                    continue;
                            }
                        }
                        typeList.add(list.get(j));
                        list.set(j, null);
                    }
                }
                typeMap.put("type", list.get(i).getFloorname());
                typeMap.put("typeList", typeList);
                list.set(i, null);
                returnList.add(typeMap);
            }
        }
        return returnList;
    }


    /**
     * 判断是否有实时房价
     */
    private Object judgeRealTimePrice(List<Map> list, Object typeid) {
        String type = typeid.toString();
        for (int i = 0; i < list.size(); i++) {
            if (type.equals(list.get(i).get("typeid"))) {
                return list.get(i).get("price");
            }
        }
        return null;
    }


//    查询房间所有基本信息与预订单信息
      @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
      @RequestMapping("room/details")
      public Object getRoomDetails(String roomid){
        if(roomid==null){
            return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
          Map returnMap =new HashMap();
        try {
            //查询房间所有基本信息
            Map map = roomSDao.selectRoomBaseInfo(roomid);
            if(map==null){
                return new Result(StatusEnum.NO_DATA.getCODE(),"房间ID无效");
            }
            returnMap.put("room",map);
            //查询房间所有预订信息
            List<Quickbooking> quickbookings = roomSDao.selectRoomRetBooking(roomid);
            returnMap.put("booking",quickbookings);


            return new Result(StatusEnum.SUCCESS.getCODE(),returnMap);

        }catch (Exception e){
            e.printStackTrace();
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

      }



    /**
     * 房态 : 返回房态右边的楼层信息
     *
     * @return 右边下拉框中 楼层的信信息 OR 错误状态码
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/floorName/FangTai")
    public Object findFloorAll() {
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
     *
     * @param floorCode 下拉框中的楼层名字对应的编号
     * @return 房间信息 OR 错误代码
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/floorName/room")
    public Object findRoomGetFloorName(String floorCode) {
        try {
            return this.roomSDao.findFloorNameGetRoomMapper(floorCode);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * 房间类型所有信息
     * 房态右边下拉框房间类型
     *
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
     *
     * @param roomType 获取到右边下拉框信息
     * @return 返回房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/roomTypeName/room")
    public Object findRoomGetRoomType(String roomType) {
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
     * @param strs 前台传递的参数
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/find")
    public Object findFangTai(@Param("strs") String strs) {
        String str = "";
        if (strs != null && !("".equals(strs))) {
            str = strs.trim();
        }
        System.out.println(str);
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (i < str.length() - 1) {
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
     * 获取所有空房
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
     *
     * 获取所有空房
     * @param typeId
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/kong")
    public Object getKongAll(String typeId, String startdate, String enddate) {
        List<Map<String, Object>> list = null;
        List<Map<String, Object>> map = new ArrayList<>();
        List<String> typeIds = null;
        if (typeId == null || startdate == null || enddate == null) {
            return map;
        } else if (typeId.length() == 0 || startdate.length() == 0 || enddate.length() == 0) {
            return map;
        }
        try {
            String[] arr = typeId.split(",");
            typeIds = new ArrayList<String>();
            for (int i = 0; i < arr.length; i++) {
                typeIds.add(arr[i]);
            }
            map = this.roomSDao.selectKongMapper(typeIds);
            System.out.println("map:" + map);
            List<String> roomnos = roomSDao.selectReserveRoomByDate(startdate, enddate);
            System.out.println("roomnos:" + roomnos);
            map = joinRepadbleResere(map, roomnos);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        return map;
    }


    /**
     * * 预定:预定页面中 点击房间号之后显示的页面,右边的房间号
     *
     *  获取所有已入住房间
     * @param typeId
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("floor/roomTypeName/notkong")
    public Object getnotKongAll(String typeId, String startdate, String enddate) {
        List<Map<String, Object>> list = null;
        List<Map<String, Object>> map = new ArrayList<>();
        List<String> typeIds = null;
        if (typeId == null || startdate == null || enddate == null) {
            return map;
        } else if (typeId.length() == 0 || startdate.length() == 0 || enddate.length() == 0) {
            return map;
        }
        try {
            String[] arr = typeId.split(",");
            typeIds = new ArrayList<String>();
            for (int i = 0; i < arr.length; i++) {
                typeIds.add(arr[i]);
            }
            map = this.roomSDao.selectKongMapperMarkets(typeIds);
            System.out.println("map:" + map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
        return map;
    }




    /**
     * 判断房间在时间段内是否有预订信息  修改返回状态
     *
     * @param rooms
     * @param reserveRooms
     * @return
     */
    private List<Map<String, Object>> joinRepadbleResere(List<Map<String, Object>> rooms, List<String> reserveRooms) {

        for (int i = 0; i < rooms.size(); i++) {

            for (int j = 0; j < reserveRooms.size(); j++) {
                if (String.valueOf(rooms.get(i).get("roomno")).equals(reserveRooms.get(j))) {
                    rooms.get(i).put("state", "2");
                }
            }

            if (rooms.get(i).get("state") == null) {
                rooms.get(i).put("state", "1");
            }
        }
        return rooms;
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
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            this.logger.error(e.toString());
            return new Status(StatusEnum.ERROR.getCODE(), StatusEnum.ERROR.getEXPLAIN());
        }
    }

    /**
     * ****************************************************************************************
     *                                      快速分房  开始
     * *****************************************************************************************
     */
    /**
     * 快速分房右边的房类信息的接口  快速分房 (页面修改为工作流展示该接口联通但未使用)
     *
     * @return 房类信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/roomType")
    public List<RoomType> fenFangFangLei() {
        List<RoomType> list = this.roomSDao.findRoomTypeFenFangMapper();
        return list;
    }

    /**
     * 快速分房右边的建筑的接口  快速分房 (页面修改为工作流展示该接口联通但未使用)
     *
     * @param roomType 房类的类型编号
     * @return 建筑信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Building")
    public List<Building> fenFangBuild(@Param("roomType") String roomType) {
        List<Building> list = null;
        if (roomType != null && !("".equals(roomType))) {
            list = this.roomSDao.findBuildingFenFangMapper(roomType);
        }
        return list;
    }

    /**
     * 快速分房右边的楼层的接口 快速分房 (页面修改为工作流展示该接口联通但未使用)
     *
     * @param buildingCode 建筑的编号
     * @return 楼层信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Floors")
    public List<Floors> fenFangFloors(String buildingCode) {
        System.out.println(buildingCode);
        List<Floors> list = null;
        if (buildingCode != null && !("".equals(buildingCode))) {
            list = this.roomSDao.findFloorsFenFangMapper(buildingCode);
        }
        return list;
    }

    /**
     * 快速分房筛选的房态信息  快速分房 (页面修改为工作流展示该接口没有联通使用)
     *
     * @param roomType     房间类型
     * @param buildingCode 建筑编号
     * @param floorCode    楼层编号
     * @param flag         状态
     * @param startDate    预抵日期
     * @param endDate      离店日期
     * @return 房间信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("fenFang/Rooms")
    public Map fenFangRooms(String roomType, String buildingCode, String floorCode, String flag, String sflag, String startDate, String endDate) {
        Map<String, String> map = new HashMap<String, String>();
        if (roomType != null && !("".equals(roomType))) {
            map.put("roomType", roomType);
        }
        if (buildingCode != null && !("".equals(buildingCode))) {
            map.put("buildingCode", buildingCode);
        }
        if (floorCode != null && !("".equals(floorCode))) {
            map.put("floorCode", floorCode);
        }
        if (flag != null && !("".equals(flag))) {
            map.put("flag", flag);
        }
        if (sflag != null && !("".equals(sflag))) {
            map.put("sflag", sflag);
        }
        if (startDate != null && !("".equals(startDate))) {
            map.put("startDate", startDate);
        }
        if (endDate != null && !("".equals(endDate))) {
            map.put("endDate", endDate);
        }

        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
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
     *
     * @param pTime 需要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }


    /**
     * 保存房价信息---没有接通  房价政策
     *
     * @param roomPrices
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("rooms/roomsPrices")
    public Map addRoomPrices(@RequestBody List<RoomPrices> roomPrices) {
        String uuid = UUIDUtil.getInstance().getUUID().toString();
//        roomPrices.setId(uuid);
        for (RoomPrices r : roomPrices
                ) {
            System.out.println(r.toString());
        }
        Map<String, String> map = null;
        System.out.println(roomPrices.toString());
        map.put("success", "数据获取");
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


    /**
     * 修改房间净房脏房状态
     *
     * @param roomnos
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("rooms/update/sflag")
    public Object updatesflag(String roomnos, String modifTime, String modifier, String roomServece, String roomRemark, String sflag) {
        try {
            String[] split = roomnos.split(",");
            List s = new ArrayList();
            for (int i = 0; i < split.length; i++) {
                s.add(split[i]);
            }
            roomSDao.updateRoomSflag(sflag, s);
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
        return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
    }


    /**
     * ****************************************************************************************
     *                                      消费项目
     * *****************************************************************************************
     */


    /**
     * 获取所有客房消费项目
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/project/getAll")
    public Object getProjects() {
        try {
            List<KfconsumerProjects> kfconsumerProjects = roomSDao.selectXfProjectAll();
            if (kfconsumerProjects.size() == 0) {
                return new Result(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
            } else {
                return new Result(StatusEnum.SUCCESS.getCODE(), kfconsumerProjects);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 插入客房消费信息
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("consume/record/insert")
    public Object insertRecord(@RequestBody KfconsumpRecord kfconsumpRecord){

        if ( kfconsumpRecord.getProject()==null || kfconsumpRecord.getRoomid()==null || kfconsumpRecord.getBookingno()==null) {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
        System.out.println(kfconsumpRecord);

        //获取ID
        StringBuilder uuid = UUIDUtil.getInstance().getUUID();
        kfconsumpRecord.setId(uuid.toString());
        //获取房间号
        String roomNo=roomSDao.selectRoomNoByRoomId(kfconsumpRecord.getRoomid());
        kfconsumpRecord.setRoomno(roomNo);
        //判断是否是录入押金
        if("押金".equals(kfconsumpRecord.getProject())) {
            //获取此订单所有消费信息
            List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectXfConsumptionInfo(roomNo);
            for (int i = 0; i < kfconsumpRecords.size(); i++) {
                if ("押金".equals(kfconsumpRecords.get(0).getProject())) {
                    return new Status(StatusEnum.DEFEAT.getCODE(), "不可重复录入押金");
                }
            }
        }

        try {
            List list=new ArrayList();
            list.add(kfconsumpRecord);
            roomSDao.insertXfConsumptionInfo(list);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 修改客房消费信息
     *
     * @param kfconsumpRecord
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("consume/record/update")
    public Object updateRecord(@RequestBody KfconsumpRecord kfconsumpRecord) {
        if (kfconsumpRecord.getRoomno() == null  || kfconsumpRecord.getRoomid()==null || kfconsumpRecord.getBookingno()==null) {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try {
            roomSDao.updateXfConsumptionInfo(kfconsumpRecord);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        } catch (Exception e) {
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
    }
    }


    /**
     * 删除单条消费信息
     * @param recordId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/record/deleteOne")
    public Object recordDelete(String recordId){
        if (recordId==null) {
            return new Status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            System.out.println("recordId:"+recordId);
            roomSDao.deleteOneXfConsumptionInfo(recordId);
            return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }catch (Exception e){
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 查询订单所有消费记录
     * @param bookingNo
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/record/select")
    public Object selectRecord(String bookingNo){

       if(bookingNo==null || "".equals(bookingNo)){
           return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
       }
       try{
           List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectXfConsumptionInfo(bookingNo);
           return kfconsumpRecords;
       }catch (Exception e){
           return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
       }
    }

    /**
     * 查询房间所有消费记录
     * @param bookingNo
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/roomRecord/select")
    public Object selectRoomRecord(String bookingNo,String roomId){

        if(bookingNo==null || "".equals(bookingNo)|| roomId==null || "".equals(roomId)){
            return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectXfRoomConsumptionInfo(bookingNo,roomId);
            return kfconsumpRecords;
        }catch (Exception e){
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 查询房间所有消费记录
     * @param bookId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/roomRecord/findRecord")
    public Object selectRoomRecordByid(String bookId,String roomId){

        if(bookId==null || "".equals(bookId)|| roomId==null || "".equals(roomId)){
            return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            String bookingNo=bookingDao.selectBookNoByBookId(bookId);
            List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectXfRoomConsumptionInfo(bookingNo,roomId);
            return kfconsumpRecords;
        }catch (Exception e){
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 查询房间所有消费记录
     * @param bookId
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("consume/roomRecord/findRecordMultiple")
    public Object selectRoomRecordByidMultiple(String bookId,String roomIds){

        if(bookId==null || "".equals(bookId)|| roomIds==null || "".equals(roomIds)){
            return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }
        try{
            List list=new ArrayList();
            String[] split = roomIds.split(",");
            if(split.length==0){
                return new Result(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
            }
            for(int i=0;i<split.length;i++){
                list.add(split[i]);
            }
            String bookingNo=bookingDao.selectBookNoByBookId(bookId);
            Map map=new HashMap();
            map.put("bookingNo",bookingNo);
            map.put("list",list);
            List<KfconsumpRecord> kfconsumpRecords = roomSDao.selectXfRoomConsumptionInfoMultiple(map);

            //获取入住时间  计算房费
            Map dates = kfCheckOutDao.selectBookingTime(bookingNo);
            String startdate = (String)dates.get("startdate");
            Date nowDate = new Date();
            Date startDate = sf.parse(startdate);
            Calendar calendar=Calendar.getInstance();
            Calendar newCalendar=Calendar.getInstance();
            calendar.setTime(startDate);
            newCalendar.setTime(nowDate);
            int i = newCalendar.get(Calendar.DAY_OF_MONTH);
            int x=calendar.get(Calendar.DAY_OF_MONTH);
            int checkTime=i-x >0? i-x :1;
            for(KfconsumpRecord cr:kfconsumpRecords){
                if("房费".equals(cr.getProject())){
                 cr.setTotalPrice(String.valueOf(Integer.valueOf(cr.getUnitprice())*checkTime));
                }
            }

            return kfconsumpRecords;
        }catch (Exception e){
            return new Result(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 修改房间状态
     * @param roomid  房间id
     * @param flag     空房 散客 团体 维修
     * @param sflag    脏房净房
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("room/updateFlags")
    public Object updateRoomSflagAndFlag(String roomid ,String flag ,String sflag){

        if(roomid==null || roomid.length()==0){
            System.out.println("1111");
            return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }else if(flag==null && sflag==null){
            System.out.println("2222");
            return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
        }

        try{
            Map<String,Object> param=new HashMap();
            List<String> roomids =new ArrayList<String>();
            String[] split = roomid.split(",");
            if(split.length==0){
                return new Status(StatusEnum.NO_PARAM.getCODE(),StatusEnum.NO_PARAM.getEXPLAIN());
            }
            for(int i=0;i<split.length;i++){
                roomids.add(split[i]);
            }

            param.put("roomids",roomids);
            param.put("flag",flag);
            param.put("sflag",sflag);
            Integer integer = roomSDao.updateRoomSflagAndFlag(param);
            if(integer>0){
                return  new Status(StatusEnum.SUCCESS.getCODE(),StatusEnum.SUCCESS.getEXPLAIN());
            }else{
                return  new Status(StatusEnum.DEFEAT.getCODE(),"修改失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            return new Status(StatusEnum.DATABASE_ERROR.getCODE(),StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }




}

