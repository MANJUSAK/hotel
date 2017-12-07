package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * Created by duyuxiang on 2017/12/6.
 * 房态返回信息
 */
public class RealStateResult {

    private String     id      ;       // 房间id
    private String     buildingname;   //建筑名
    private String     floorname;      //楼层名
    private String     typeid ;        // 类型id
    private String     typename  ;     //类型名
    private String     houseprices;    //房间价格
    private String     roomno  ;       //房间号
    private String     stdpax ;        //房间人数
    private String     maxpax   ;      //最大人数
    private String     doorlockid  ;   //门锁id
    private String     flag ;          //标识(空房,散客,团体 ... ) 除空房以外  其余都是入住状态
    private String     sflag  ;        // 标识(净房 , 脏房 )
    private String     cflag  ;        // 标识(预抵 , 预离 )
    private String     yflag ="0" ;        //标识(预留 ?)

    //以下不确定数据   cflag为预抵 附带以下信息
    private String     bookingno ;   //预订单号
    private String     guestname ;   //预订客人名
    private String     startdate;    //预订入住时间
    private String     enddate ;     //预订离开时间
    private String     teamname ;    //业务员
    private String     remark ;      //备注
    private String     roomid ;      //房间id
    private String     bookingflag;  //预订单状态


    public RealStateResult(){
    }

    public String getYflag() {
        return yflag;
    }

    public void setYflag(String yflag) {
        this.yflag = yflag;
    }

    public String getBookingflag() {
        return bookingflag;
    }

    public void setBookingflag(String bookingflag) {
        this.bookingflag = bookingflag;
    }

    public String getBuildingname(){
        return buildingname;
    }

    public void setBuildingname(String buildingname){
        this.buildingname = buildingname;
    }

    public String getFloorname(){
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getHouseprices() {
        return houseprices;
    }

    public void setHouseprices(String houseprices) {
        this.houseprices = houseprices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getStdpax() {
        return stdpax;
    }

    public void setStdpax(String stdpax) {
        this.stdpax = stdpax;
    }

    public String getMaxpax() {
        return maxpax;
    }

    public void setMaxpax(String maxpax) {
        this.maxpax = maxpax;
    }

    public String getDoorlockid() {
        return doorlockid;
    }

    public void setDoorlockid(String doorlockid) {
        this.doorlockid = doorlockid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSflag() {
        return sflag;
    }

    public void setSflag(String sflag) {
        this.sflag = sflag;
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag;
    }

    public String getBookingno() {
        return bookingno;
    }

    public void setBookingno(String bookingno) {
        this.bookingno = bookingno;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    @Override
    public String toString() {
        return "RealStateResult{" +
                "buildingname='" + buildingname + '\'' +
                ", floorname='" + floorname + '\'' +
                ", typeid='" + typeid + '\'' +
                ", typename='" + typename + '\'' +
                ", houseprices='" + houseprices + '\'' +
                ", id='" + id + '\'' +
                ", roomno='" + roomno + '\'' +
                ", stdpax='" + stdpax + '\'' +
                ", maxpax='" + maxpax + '\'' +
                ", doorlockid='" + doorlockid + '\'' +
                ", flag='" + flag + '\'' +
                ", sflag='" + sflag + '\'' +
                ", cflag='" + cflag + '\'' +
                ", bookingno='" + bookingno + '\'' +
                ", guestname='" + guestname + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", teamname='" + teamname + '\'' +
                ", remark='" + remark + '\'' +
                ", roomid='" + roomid + '\'' +
                '}';
    }
}
