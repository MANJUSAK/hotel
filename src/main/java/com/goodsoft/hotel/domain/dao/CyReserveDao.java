package com.goodsoft.hotel.domain.dao;

import com.goodsoft.hotel.domain.entity.restaurantReservation.FitReservation;
import com.goodsoft.hotel.domain.entity.restaurantReservation.ReservationHalls;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by duyuxiang on 2017/11/12.
 * 餐饮预订dao
 */
@Repository
public interface CyReserveDao {

  //获取所有厅
  public List<Map> selectHalls();

  //获取厅堂所有餐台
  public List<Map> selectTablesByHall(String hallId);

  //插入预订信息
  public Integer insertReserveInfo(FitReservation fitReservation);

  //插入预订分厅信息
  public Integer insertReserveHalls(List list);

  //查询散客预订信息
  public List<FitReservation> selectSkReserves(Map map);
  //查询酒席预订信息
  public List<FitReservation> selectJxReserves(Map map);
  //查询宴会预订信息
  public List<FitReservation> selectYhReserves(Map map);
  //查询散客预订信息总数量
  public Integer selectSkReservesNum(Map map);
  //查询酒席预订信息总数量
  public Integer selectJxReservesNum(Map map);
  //查询宴会预订信息总数量
  public Integer selectYhReservesNum(Map map);

  //修改散客预订信息
  public Integer updateReserveInfo(FitReservation fitReservation);

  //修改预订单状态
  public Integer updateReserveState(Map map);

  //查询单条散客预订全部信息
  public FitReservation selectSkReserveById(String id);
  //查询单条酒席预订全部信息
  public FitReservation selectJxReserveById(String id);
  //查询单条宴会预订全部信息
  public FitReservation selectYhReserveById(String id);

  //查询预订厅台
  public List<ReservationHalls> selectReserveHalls(String reserveId);
  //删除预订分厅信息
  public Integer deleteReserveHalls(String reserveId);

}


