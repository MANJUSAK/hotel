package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 客人信息表
 * Created by zhiWang on 2017/11/15/015.
 */

public class Guest {
    private String id;                  //ID
    private String guestName;           //客人名字
    private String nickName;            //客人称呼
    private String englishName;         //英文名
    private String marital;             //婚姻状况
    private String nationality;         //国籍
    private String languages;           //语言
    private String cardType;            //证件类型
    private String ethnic;              //民族
    private String documentNo;          //证件号码
    private String nativePlace;         //籍贯
    private String sex;                 //性别
    private String occupation;          //职业
    private String birthDay;            //生日
    private String workUnit;            //工作单位
    private String cityProper;          //城区
    private String post;                //职务
    private String regional;            //地区分类
    private String stopCause;           //经停事由
    private String postalCode;          //邮政编码
    private String address;             //住址
    private String officePhone;         //办公电话
    private String phoneNumber;         //手机号码
    private String telePhone;           //电话
    private String visaAgency;          //签证机关
    private String visaType;            //签证类型
    private String visaNumber;          //签证号码
    private String visaDate;            //签证日期
    private String periodValidity;      //有效期
    private String entryTime;           //入境时间
    private String entryPorts;          //入境口岸
    private String newsPaperType;       //报纸类型
    private String religiousBelief;     //宗教信仰
    private String secondCard;          //第二证件
    private String comeFrom;            //从何处来
    private String arrivalFlight;       //抵达航班
    private String whereToGo;           //到何处去
    private String leaveFlight;         //离开航班
    private String positions;           //位置
    private String carType;             //车型
    private String carPlateNumber;      //车牌号
    private String specialDemand;       //特殊要求
    private String hobby;               //兴趣爱好
    private String taboo;               //忌讳
    private String bookId;       //预定单编号
    private String vipId;        //会员卡ID
    private String customertype ="1";   //顾客类型
    private String roomId;           //房间id
    private String state="1";        //状态  (1:在住 0:已退房 )



    public String getNewsPaperType() {
        return newsPaperType;
    }

    public void setNewsPaperType(String newsPaperType) {
        this.newsPaperType = newsPaperType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getCityProper() {
        return cityProper;
    }

    public void setCityProper(String cityProper) {
        this.cityProper = cityProper;
    }

    public String getWork() {
        return post;
    }

    public void setWork(String work) {
        this.post = work;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getStopCause() {
        return stopCause;
    }

    public void setStopCause(String stopCause) {
        this.stopCause = stopCause;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getVisaAgency() {
        return visaAgency;
    }

    public void setVisaAgency(String visaAgency) {
        this.visaAgency = visaAgency;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public String getVisaDate() {
        return visaDate;
    }

    public void setVisaDate(String visaDate) {
        this.visaDate = visaDate;
    }

    public String getPeriodValidity() {
        return periodValidity;
    }

    public void setPeriodValidity(String periodValidity) {
        this.periodValidity = periodValidity;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryPorts() {
        return entryPorts;
    }

    public void setEntryPorts(String entryPorts) {
        this.entryPorts = entryPorts;
    }

    public String getNewspaperType() {
        return newsPaperType;
    }

    public void setNewspaperType(String newspaperType) {
        this.newsPaperType = newspaperType;
    }

    public String getReligiousBelief() {
        return religiousBelief;
    }

    public void setReligiousBelief(String religiousBelief) {
        this.religiousBelief = religiousBelief;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getArrivalFlight() {
        return arrivalFlight;
    }

    public void setArrivalFlight(String arrivalFlight) {
        this.arrivalFlight = arrivalFlight;
    }

    public String getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(String whereToGo) {
        this.whereToGo = whereToGo;
    }

    public String getLeaveFlight() {
        return leaveFlight;
    }

    public void setLeaveFlight(String leaveFlight) {
        this.leaveFlight = leaveFlight;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getSpecialDemand() {
        return specialDemand;
    }

    public void setSpecialDemand(String specialDemand) {
        this.specialDemand = specialDemand;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", guestName='" + guestName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", marital='" + marital + '\'' +
                ", nationality='" + nationality + '\'' +
                ", languages='" + languages + '\'' +
                ", cardType='" + cardType + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", documentNo='" + documentNo + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", sex='" + sex + '\'' +
                ", occupation='" + occupation + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", cityProper='" + cityProper + '\'' +
                ", work='" + post + '\'' +
                ", regional='" + regional + '\'' +
                ", stopCause='" + stopCause + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", address='" + address + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", visaAgency='" + visaAgency + '\'' +
                ", visaType='" + visaType + '\'' +
                ", visaNumber='" + visaNumber + '\'' +
                ", visaDate='" + visaDate + '\'' +
                ", periodValidity='" + periodValidity + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", entryPorts='" + entryPorts + '\'' +
                ", newspaperType='" + newsPaperType + '\'' +
                ", religiousBelief='" + religiousBelief + '\'' +
                ", secondCard='" + secondCard + '\'' +
                ", comeFrom='" + comeFrom + '\'' +
                ", arrivalFlight='" + arrivalFlight + '\'' +
                ", whereToGo='" + whereToGo + '\'' +
                ", leaveFlight='" + leaveFlight + '\'' +
                ", positions='" + positions + '\'' +
                ", carType='" + carType + '\'' +
                ", carPlateNumber='" + carPlateNumber + '\'' +
                ", specialDemand='" + specialDemand + '\'' +
                ", hobby='" + hobby + '\'' +
                ", taboo='" + taboo + '\'' +
                ", bookId='" + bookId + '\'' +
                ", vipId='" + vipId + '\'' +
                ", customertype='" + customertype + '\'' +
                '}';
    }



}
