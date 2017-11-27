package com.goodsoft.hotel.domain.entity.restaurantReservation;

/**
 * Created by duyuxiang on 2017/11/24.
 * 餐饮酒席预订
 */
public class BanquetReservation {

    private String id;
    private String customerType;
    private String entryDate;
    private String customerName;
    private Integer peopleNumber;
    private String salesManager;
    private String contacts;
    private String contactsNumber;
    private String appointmentLength;
    private String attheTime;
    private String endDate;
    private String memberCard;
    private String contractUnit;
    private String corporateName;
    private Integer seatsNum;
    private String winePosition;
    private String isbilling;
    private String floatNum;
    private String invitationNum;
    private String floatCharge;
    private String invitationCharge;
    private String corsagesCharge;
    private String artlayoutCharge;
    private String cakeCharge;
    private String meloncandyCharge;
    private String drinksDiscount;
    private String attendancebookCharge;
    private String ceremoniesCharge;
    private String temporaryworkerCharge;
    private String lightingCharge;
    private String loadingCharge;
    private String paymentMethod;
    private String cancellationReasons;
    private String authorizedPerson;
    private String dish;
    private String drinks;
    private String flower;
    private String cigarette;
    private String gift;
    private String printMenu;
    private String roomProgram;
    private String auditoriumProgram;
    private String siteLayout;
    private String frozenTowel;
    private String others;
    private String remarks;
    private String monogram;
    private String tableCard;
    private String indicator;
    private String projector;
    private String paperandpen;
    private String parkingLot;
    private String backgroundFrame;
    private String floralPlantBack;
    private String teaBreak;
    private String etiquetteService;
    private String lnkjetInstallation;
    private String ledScreen;
    private String welcomePlaque;
    private String revolvingStage;
    private String tableSign;
    private String liCard;
    private String perform;
    private String clothField;
    private String rentalFee;
    private String gateAdvertisement;
    private String rainbowArchedEntrance;
    private String flyingBalloon;
    private String romeFlag;
    private String rentIncluded;
    private String videoAndAudio;
    private String otherRequirements;
    private String state;


    @Override
    public String toString() {
        return "BanquetReservation{" +
                "id='" + id + '\'' +
                ", customerType='" + customerType + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", customerName='" + customerName + '\'' +
                ", peopleNumber=" + peopleNumber +
                ", salesManager='" + salesManager + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactsNumber='" + contactsNumber + '\'' +
                ", appointmentLength='" + appointmentLength + '\'' +
                ", attheTime='" + attheTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", memberCard='" + memberCard + '\'' +
                ", contractUnit='" + contractUnit + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", seatsNum=" + seatsNum +
                ", winePosition='" + winePosition + '\'' +
                ", isbilling='" + isbilling + '\'' +
                ", floatNum='" + floatNum + '\'' +
                ", invitationNum='" + invitationNum + '\'' +
                ", floatCharge='" + floatCharge + '\'' +
                ", invitationCharge='" + invitationCharge + '\'' +
                ", corsagesCharge='" + corsagesCharge + '\'' +
                ", artlayoutCharge='" + artlayoutCharge + '\'' +
                ", cakeCharge='" + cakeCharge + '\'' +
                ", meloncandyCharge='" + meloncandyCharge + '\'' +
                ", drinksDiscount='" + drinksDiscount + '\'' +
                ", attendancebookCharge='" + attendancebookCharge + '\'' +
                ", ceremoniesCharge='" + ceremoniesCharge + '\'' +
                ", temporaryworkerCharge='" + temporaryworkerCharge + '\'' +
                ", lightingCharge='" + lightingCharge + '\'' +
                ", loadingCharge='" + loadingCharge + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cancellationReasons='" + cancellationReasons + '\'' +
                ", authorizedPerson='" + authorizedPerson + '\'' +
                ", dish='" + dish + '\'' +
                ", drinks='" + drinks + '\'' +
                ", flower='" + flower + '\'' +
                ", cigarette='" + cigarette + '\'' +
                ", gift='" + gift + '\'' +
                ", printMenu='" + printMenu + '\'' +
                ", roomProgram='" + roomProgram + '\'' +
                ", auditoriumProgram='" + auditoriumProgram + '\'' +
                ", siteLayout='" + siteLayout + '\'' +
                ", frozenTowel='" + frozenTowel + '\'' +
                ", others='" + others + '\'' +
                ", remarks='" + remarks + '\'' +
                ", monogram='" + monogram + '\'' +
                ", tableCard='" + tableCard + '\'' +
                ", indicator='" + indicator + '\'' +
                ", projector='" + projector + '\'' +
                ", paperandpen='" + paperandpen + '\'' +
                ", parkingLot='" + parkingLot + '\'' +
                ", backgroundFrame='" + backgroundFrame + '\'' +
                ", floralPlantBack='" + floralPlantBack + '\'' +
                ", teaBreak='" + teaBreak + '\'' +
                ", etiquetteService='" + etiquetteService + '\'' +
                ", lnkjetInstallation='" + lnkjetInstallation + '\'' +
                ", ledScreen='" + ledScreen + '\'' +
                ", welcomePlaque='" + welcomePlaque + '\'' +
                ", revolvingStage='" + revolvingStage + '\'' +
                ", tableSign='" + tableSign + '\'' +
                ", liCard='" + liCard + '\'' +
                ", perform='" + perform + '\'' +
                ", clothField='" + clothField + '\'' +
                ", rentalFee='" + rentalFee + '\'' +
                ", gateAdvertisement='" + gateAdvertisement + '\'' +
                ", rainbowArchedEntrance='" + rainbowArchedEntrance + '\'' +
                ", flyingBalloon='" + flyingBalloon + '\'' +
                ", romeFlag='" + romeFlag + '\'' +
                ", rentIncluded='" + rentIncluded + '\'' +
                ", videoAndAudio='" + videoAndAudio + '\'' +
                ", otherRequirements='" + otherRequirements + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ID
     *
     * @return the value of gs_banquet_reservation.ID
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ID
     *
     * @param id the value for gs_banquet_reservation.ID
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CUSTOMER_TYPE
     *
     * @return the value of gs_banquet_reservation.CUSTOMER_TYPE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CUSTOMER_TYPE
     *
     * @param customerType the value for gs_banquet_reservation.CUSTOMER_TYPE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ENTRY_DATE
     *
     * @return the value of gs_banquet_reservation.ENTRY_DATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ENTRY_DATE
     *
     * @param entryDate the value for gs_banquet_reservation.ENTRY_DATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate == null ? null : entryDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CUSTOMER_NAME
     *
     * @return the value of gs_banquet_reservation.CUSTOMER_NAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CUSTOMER_NAME
     *
     * @param customerName the value for gs_banquet_reservation.CUSTOMER_NAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PEOPLE_NUMBER
     *
     * @return the value of gs_banquet_reservation.PEOPLE_NUMBER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PEOPLE_NUMBER
     *
     * @param peopleNumber the value for gs_banquet_reservation.PEOPLE_NUMBER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.SALES_MANAGER
     *
     * @return the value of gs_banquet_reservation.SALES_MANAGER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getSalesManager() {
        return salesManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.SALES_MANAGER
     *
     * @param salesManager the value for gs_banquet_reservation.SALES_MANAGER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setSalesManager(String salesManager) {
        this.salesManager = salesManager == null ? null : salesManager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CONTACTS
     *
     * @return the value of gs_banquet_reservation.CONTACTS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CONTACTS
     *
     * @param contacts the value for gs_banquet_reservation.CONTACTS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CONTACTS_NUMBER
     *
     * @return the value of gs_banquet_reservation.CONTACTS_NUMBER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getContactsNumber() {
        return contactsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CONTACTS_NUMBER
     *
     * @param contactsNumber the value for gs_banquet_reservation.CONTACTS_NUMBER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setContactsNumber(String contactsNumber) {
        this.contactsNumber = contactsNumber == null ? null : contactsNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.APPOINTMENT_LENGTH
     *
     * @return the value of gs_banquet_reservation.APPOINTMENT_LENGTH
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getAppointmentLength() {
        return appointmentLength;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.APPOINTMENT_LENGTH
     *
     * @param appointmentLength the value for gs_banquet_reservation.APPOINTMENT_LENGTH
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setAppointmentLength(String appointmentLength) {
        this.appointmentLength = appointmentLength == null ? null : appointmentLength.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ATTHE_TIME
     *
     * @return the value of gs_banquet_reservation.ATTHE_TIME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getAttheTime() {
        return attheTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ATTHE_TIME
     *
     * @param attheTime the value for gs_banquet_reservation.ATTHE_TIME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setAttheTime(String attheTime) {
        this.attheTime = attheTime == null ? null : attheTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.END_DATE
     *
     * @return the value of gs_banquet_reservation.END_DATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.END_DATE
     *
     * @param endDate the value for gs_banquet_reservation.END_DATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.MEMBER_CARD
     *
     * @return the value of gs_banquet_reservation.MEMBER_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getMemberCard() {
        return memberCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.MEMBER_CARD
     *
     * @param memberCard the value for gs_banquet_reservation.MEMBER_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setMemberCard(String memberCard) {
        this.memberCard = memberCard == null ? null : memberCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CONTRACT_UNIT
     *
     * @return the value of gs_banquet_reservation.CONTRACT_UNIT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getContractUnit() {
        return contractUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CONTRACT_UNIT
     *
     * @param contractUnit the value for gs_banquet_reservation.CONTRACT_UNIT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setContractUnit(String contractUnit) {
        this.contractUnit = contractUnit == null ? null : contractUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CORPORATE_NAME
     *
     * @return the value of gs_banquet_reservation.CORPORATE_NAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCorporateName() {
        return corporateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CORPORATE_NAME
     *
     * @param corporateName the value for gs_banquet_reservation.CORPORATE_NAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName == null ? null : corporateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.SEATS_NUM
     *
     * @return the value of gs_banquet_reservation.SEATS_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public Integer getSeatsNum() {
        return seatsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.SEATS_NUM
     *
     * @param seatsNum the value for gs_banquet_reservation.SEATS_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setSeatsNum(Integer seatsNum) {
        this.seatsNum = seatsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.WINE_POSITION
     *
     * @return the value of gs_banquet_reservation.WINE_POSITION
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getWinePosition() {
        return winePosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.WINE_POSITION
     *
     * @param winePosition the value for gs_banquet_reservation.WINE_POSITION
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setWinePosition(String winePosition) {
        this.winePosition = winePosition == null ? null : winePosition.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ISBILLING
     *
     * @return the value of gs_banquet_reservation.ISBILLING
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getIsbilling() {
        return isbilling;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ISBILLING
     *
     * @param isbilling the value for gs_banquet_reservation.ISBILLING
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setIsbilling(String isbilling) {
        this.isbilling = isbilling == null ? null : isbilling.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FLOAT_NUM
     *
     * @return the value of gs_banquet_reservation.FLOAT_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFloatNum() {
        return floatNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FLOAT_NUM
     *
     * @param floatNum the value for gs_banquet_reservation.FLOAT_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFloatNum(String floatNum) {
        this.floatNum = floatNum == null ? null : floatNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.INVITATION_NUM
     *
     * @return the value of gs_banquet_reservation.INVITATION_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getInvitationNum() {
        return invitationNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.INVITATION_NUM
     *
     * @param invitationNum the value for gs_banquet_reservation.INVITATION_NUM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setInvitationNum(String invitationNum) {
        this.invitationNum = invitationNum == null ? null : invitationNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FLOAT_CHARGE
     *
     * @return the value of gs_banquet_reservation.FLOAT_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFloatCharge() {
        return floatCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FLOAT_CHARGE
     *
     * @param floatCharge the value for gs_banquet_reservation.FLOAT_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFloatCharge(String floatCharge) {
        this.floatCharge = floatCharge == null ? null : floatCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.INVITATION_CHARGE
     *
     * @return the value of gs_banquet_reservation.INVITATION_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getInvitationCharge() {
        return invitationCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.INVITATION_CHARGE
     *
     * @param invitationCharge the value for gs_banquet_reservation.INVITATION_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setInvitationCharge(String invitationCharge) {
        this.invitationCharge = invitationCharge == null ? null : invitationCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CORSAGES_CHARGE
     *
     * @return the value of gs_banquet_reservation.CORSAGES_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCorsagesCharge() {
        return corsagesCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CORSAGES_CHARGE
     *
     * @param corsagesCharge the value for gs_banquet_reservation.CORSAGES_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCorsagesCharge(String corsagesCharge) {
        this.corsagesCharge = corsagesCharge == null ? null : corsagesCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ARTLAYOUT_CHARGE
     *
     * @return the value of gs_banquet_reservation.ARTLAYOUT_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getArtlayoutCharge() {
        return artlayoutCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ARTLAYOUT_CHARGE
     *
     * @param artlayoutCharge the value for gs_banquet_reservation.ARTLAYOUT_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setArtlayoutCharge(String artlayoutCharge) {
        this.artlayoutCharge = artlayoutCharge == null ? null : artlayoutCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CAKE_CHARGE
     *
     * @return the value of gs_banquet_reservation.CAKE_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCakeCharge() {
        return cakeCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CAKE_CHARGE
     *
     * @param cakeCharge the value for gs_banquet_reservation.CAKE_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCakeCharge(String cakeCharge) {
        this.cakeCharge = cakeCharge == null ? null : cakeCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.MELONCANDY_CHARGE
     *
     * @return the value of gs_banquet_reservation.MELONCANDY_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getMeloncandyCharge() {
        return meloncandyCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.MELONCANDY_CHARGE
     *
     * @param meloncandyCharge the value for gs_banquet_reservation.MELONCANDY_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setMeloncandyCharge(String meloncandyCharge) {
        this.meloncandyCharge = meloncandyCharge == null ? null : meloncandyCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.DRINKS_DISCOUNT
     *
     * @return the value of gs_banquet_reservation.DRINKS_DISCOUNT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getDrinksDiscount() {
        return drinksDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.DRINKS_DISCOUNT
     *
     * @param drinksDiscount the value for gs_banquet_reservation.DRINKS_DISCOUNT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setDrinksDiscount(String drinksDiscount) {
        this.drinksDiscount = drinksDiscount == null ? null : drinksDiscount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ATTENDANCEBOOK_CHARGE
     *
     * @return the value of gs_banquet_reservation.ATTENDANCEBOOK_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getAttendancebookCharge() {
        return attendancebookCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ATTENDANCEBOOK_CHARGE
     *
     * @param attendancebookCharge the value for gs_banquet_reservation.ATTENDANCEBOOK_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setAttendancebookCharge(String attendancebookCharge) {
        this.attendancebookCharge = attendancebookCharge == null ? null : attendancebookCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CEREMONIES_CHARGE
     *
     * @return the value of gs_banquet_reservation.CEREMONIES_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCeremoniesCharge() {
        return ceremoniesCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CEREMONIES_CHARGE
     *
     * @param ceremoniesCharge the value for gs_banquet_reservation.CEREMONIES_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCeremoniesCharge(String ceremoniesCharge) {
        this.ceremoniesCharge = ceremoniesCharge == null ? null : ceremoniesCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.TEMPORARYWORKER_CHARGE
     *
     * @return the value of gs_banquet_reservation.TEMPORARYWORKER_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getTemporaryworkerCharge() {
        return temporaryworkerCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.TEMPORARYWORKER_CHARGE
     *
     * @param temporaryworkerCharge the value for gs_banquet_reservation.TEMPORARYWORKER_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setTemporaryworkerCharge(String temporaryworkerCharge) {
        this.temporaryworkerCharge = temporaryworkerCharge == null ? null : temporaryworkerCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.LIGHTING_CHARGE
     *
     * @return the value of gs_banquet_reservation.LIGHTING_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getLightingCharge() {
        return lightingCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.LIGHTING_CHARGE
     *
     * @param lightingCharge the value for gs_banquet_reservation.LIGHTING_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setLightingCharge(String lightingCharge) {
        this.lightingCharge = lightingCharge == null ? null : lightingCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.LOADING_CHARGE
     *
     * @return the value of gs_banquet_reservation.LOADING_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getLoadingCharge() {
        return loadingCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.LOADING_CHARGE
     *
     * @param loadingCharge the value for gs_banquet_reservation.LOADING_CHARGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setLoadingCharge(String loadingCharge) {
        this.loadingCharge = loadingCharge == null ? null : loadingCharge.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PAYMENT_METHOD
     *
     * @return the value of gs_banquet_reservation.PAYMENT_METHOD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PAYMENT_METHOD
     *
     * @param paymentMethod the value for gs_banquet_reservation.PAYMENT_METHOD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CANCELLATION_REASONS
     *
     * @return the value of gs_banquet_reservation.CANCELLATION_REASONS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCancellationReasons() {
        return cancellationReasons;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CANCELLATION_REASONS
     *
     * @param cancellationReasons the value for gs_banquet_reservation.CANCELLATION_REASONS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCancellationReasons(String cancellationReasons) {
        this.cancellationReasons = cancellationReasons == null ? null : cancellationReasons.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.AUTHORIZED_PERSON
     *
     * @return the value of gs_banquet_reservation.AUTHORIZED_PERSON
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.AUTHORIZED_PERSON
     *
     * @param authorizedPerson the value for gs_banquet_reservation.AUTHORIZED_PERSON
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson == null ? null : authorizedPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.DISH
     *
     * @return the value of gs_banquet_reservation.DISH
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getDish() {
        return dish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.DISH
     *
     * @param dish the value for gs_banquet_reservation.DISH
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setDish(String dish) {
        this.dish = dish == null ? null : dish.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.DRINKS
     *
     * @return the value of gs_banquet_reservation.DRINKS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getDrinks() {
        return drinks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.DRINKS
     *
     * @param drinks the value for gs_banquet_reservation.DRINKS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setDrinks(String drinks) {
        this.drinks = drinks == null ? null : drinks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FLOWER
     *
     * @return the value of gs_banquet_reservation.FLOWER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFlower() {
        return flower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FLOWER
     *
     * @param flower the value for gs_banquet_reservation.FLOWER
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFlower(String flower) {
        this.flower = flower == null ? null : flower.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CIGARETTE
     *
     * @return the value of gs_banquet_reservation.CIGARETTE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getCigarette() {
        return cigarette;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CIGARETTE
     *
     * @param cigarette the value for gs_banquet_reservation.CIGARETTE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setCigarette(String cigarette) {
        this.cigarette = cigarette == null ? null : cigarette.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.GIFT
     *
     * @return the value of gs_banquet_reservation.GIFT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getGift() {
        return gift;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.GIFT
     *
     * @param gift the value for gs_banquet_reservation.GIFT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setGift(String gift) {
        this.gift = gift == null ? null : gift.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PRINT_MENU
     *
     * @return the value of gs_banquet_reservation.PRINT_MENU
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getPrintMenu() {
        return printMenu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PRINT_MENU
     *
     * @param printMenu the value for gs_banquet_reservation.PRINT_MENU
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setPrintMenu(String printMenu) {
        this.printMenu = printMenu == null ? null : printMenu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ROOM_PROGRAM
     *
     * @return the value of gs_banquet_reservation.ROOM_PROGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRoomProgram() {
        return roomProgram;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ROOM_PROGRAM
     *
     * @param roomProgram the value for gs_banquet_reservation.ROOM_PROGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRoomProgram(String roomProgram) {
        this.roomProgram = roomProgram == null ? null : roomProgram.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.AUDITORIUM_PROGRAM
     *
     * @return the value of gs_banquet_reservation.AUDITORIUM_PROGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getAuditoriumProgram() {
        return auditoriumProgram;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.AUDITORIUM_PROGRAM
     *
     * @param auditoriumProgram the value for gs_banquet_reservation.AUDITORIUM_PROGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setAuditoriumProgram(String auditoriumProgram) {
        this.auditoriumProgram = auditoriumProgram == null ? null : auditoriumProgram.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.SITE_LAYOUT
     *
     * @return the value of gs_banquet_reservation.SITE_LAYOUT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getSiteLayout() {
        return siteLayout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.SITE_LAYOUT
     *
     * @param siteLayout the value for gs_banquet_reservation.SITE_LAYOUT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setSiteLayout(String siteLayout) {
        this.siteLayout = siteLayout == null ? null : siteLayout.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FROZEN_TOWEL
     *
     * @return the value of gs_banquet_reservation.FROZEN_TOWEL
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFrozenTowel() {
        return frozenTowel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FROZEN_TOWEL
     *
     * @param frozenTowel the value for gs_banquet_reservation.FROZEN_TOWEL
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFrozenTowel(String frozenTowel) {
        this.frozenTowel = frozenTowel == null ? null : frozenTowel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.OTHERS
     *
     * @return the value of gs_banquet_reservation.OTHERS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getOthers() {
        return others;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.OTHERS
     *
     * @param others the value for gs_banquet_reservation.OTHERS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.REMARKS
     *
     * @return the value of gs_banquet_reservation.REMARKS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.REMARKS
     *
     * @param remarks the value for gs_banquet_reservation.REMARKS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.MONOGRAM
     *
     * @return the value of gs_banquet_reservation.MONOGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getMonogram() {
        return monogram;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.MONOGRAM
     *
     * @param monogram the value for gs_banquet_reservation.MONOGRAM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setMonogram(String monogram) {
        this.monogram = monogram == null ? null : monogram.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.TABLE_CARD
     *
     * @return the value of gs_banquet_reservation.TABLE_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getTableCard() {
        return tableCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.TABLE_CARD
     *
     * @param tableCard the value for gs_banquet_reservation.TABLE_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setTableCard(String tableCard) {
        this.tableCard = tableCard == null ? null : tableCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.INDICATOR
     *
     * @return the value of gs_banquet_reservation.INDICATOR
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.INDICATOR
     *
     * @param indicator the value for gs_banquet_reservation.INDICATOR
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator == null ? null : indicator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PROJECTOR
     *
     * @return the value of gs_banquet_reservation.PROJECTOR
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getProjector() {
        return projector;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PROJECTOR
     *
     * @param projector the value for gs_banquet_reservation.PROJECTOR
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setProjector(String projector) {
        this.projector = projector == null ? null : projector.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PAPERANDPEN
     *
     * @return the value of gs_banquet_reservation.PAPERANDPEN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getPaperandpen() {
        return paperandpen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PAPERANDPEN
     *
     * @param paperandpen the value for gs_banquet_reservation.PAPERANDPEN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setPaperandpen(String paperandpen) {
        this.paperandpen = paperandpen == null ? null : paperandpen.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PARKING_LOT
     *
     * @return the value of gs_banquet_reservation.PARKING_LOT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getParkingLot() {
        return parkingLot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PARKING_LOT
     *
     * @param parkingLot the value for gs_banquet_reservation.PARKING_LOT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot == null ? null : parkingLot.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.BACKGROUND_FRAME
     *
     * @return the value of gs_banquet_reservation.BACKGROUND_FRAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getBackgroundFrame() {
        return backgroundFrame;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.BACKGROUND_FRAME
     *
     * @param backgroundFrame the value for gs_banquet_reservation.BACKGROUND_FRAME
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setBackgroundFrame(String backgroundFrame) {
        this.backgroundFrame = backgroundFrame == null ? null : backgroundFrame.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FLORAL_PLANT_BACK
     *
     * @return the value of gs_banquet_reservation.FLORAL_PLANT_BACK
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFloralPlantBack() {
        return floralPlantBack;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FLORAL_PLANT_BACK
     *
     * @param floralPlantBack the value for gs_banquet_reservation.FLORAL_PLANT_BACK
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFloralPlantBack(String floralPlantBack) {
        this.floralPlantBack = floralPlantBack == null ? null : floralPlantBack.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.TEA_BREAK
     *
     * @return the value of gs_banquet_reservation.TEA_BREAK
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getTeaBreak() {
        return teaBreak;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.TEA_BREAK
     *
     * @param teaBreak the value for gs_banquet_reservation.TEA_BREAK
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setTeaBreak(String teaBreak) {
        this.teaBreak = teaBreak == null ? null : teaBreak.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ETIQUETTE_SERVICE
     *
     * @return the value of gs_banquet_reservation.ETIQUETTE_SERVICE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getEtiquetteService() {
        return etiquetteService;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ETIQUETTE_SERVICE
     *
     * @param etiquetteService the value for gs_banquet_reservation.ETIQUETTE_SERVICE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setEtiquetteService(String etiquetteService) {
        this.etiquetteService = etiquetteService == null ? null : etiquetteService.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.LNKJET_INSTALLATION
     *
     * @return the value of gs_banquet_reservation.LNKJET_INSTALLATION
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getLnkjetInstallation() {
        return lnkjetInstallation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.LNKJET_INSTALLATION
     *
     * @param lnkjetInstallation the value for gs_banquet_reservation.LNKJET_INSTALLATION
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setLnkjetInstallation(String lnkjetInstallation) {
        this.lnkjetInstallation = lnkjetInstallation == null ? null : lnkjetInstallation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.LED_SCREEN
     *
     * @return the value of gs_banquet_reservation.LED_SCREEN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getLedScreen() {
        return ledScreen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.LED_SCREEN
     *
     * @param ledScreen the value for gs_banquet_reservation.LED_SCREEN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setLedScreen(String ledScreen) {
        this.ledScreen = ledScreen == null ? null : ledScreen.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.WELCOME_PLAQUE
     *
     * @return the value of gs_banquet_reservation.WELCOME_PLAQUE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getWelcomePlaque() {
        return welcomePlaque;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.WELCOME_PLAQUE
     *
     * @param welcomePlaque the value for gs_banquet_reservation.WELCOME_PLAQUE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setWelcomePlaque(String welcomePlaque) {
        this.welcomePlaque = welcomePlaque == null ? null : welcomePlaque.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.REVOLVING_STAGE
     *
     * @return the value of gs_banquet_reservation.REVOLVING_STAGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRevolvingStage() {
        return revolvingStage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.REVOLVING_STAGE
     *
     * @param revolvingStage the value for gs_banquet_reservation.REVOLVING_STAGE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRevolvingStage(String revolvingStage) {
        this.revolvingStage = revolvingStage == null ? null : revolvingStage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.TABLE_SIGN
     *
     * @return the value of gs_banquet_reservation.TABLE_SIGN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getTableSign() {
        return tableSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.TABLE_SIGN
     *
     * @param tableSign the value for gs_banquet_reservation.TABLE_SIGN
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setTableSign(String tableSign) {
        this.tableSign = tableSign == null ? null : tableSign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.LI_CARD
     *
     * @return the value of gs_banquet_reservation.LI_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getLiCard() {
        return liCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.LI_CARD
     *
     * @param liCard the value for gs_banquet_reservation.LI_CARD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setLiCard(String liCard) {
        this.liCard = liCard == null ? null : liCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.PERFORM
     *
     * @return the value of gs_banquet_reservation.PERFORM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getPerform() {
        return perform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.PERFORM
     *
     * @param perform the value for gs_banquet_reservation.PERFORM
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setPerform(String perform) {
        this.perform = perform == null ? null : perform.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.CLOTH_FIELD
     *
     * @return the value of gs_banquet_reservation.CLOTH_FIELD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getClothField() {
        return clothField;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.CLOTH_FIELD
     *
     * @param clothField the value for gs_banquet_reservation.CLOTH_FIELD
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setClothField(String clothField) {
        this.clothField = clothField == null ? null : clothField.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.RENTAL_FEE
     *
     * @return the value of gs_banquet_reservation.RENTAL_FEE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRentalFee() {
        return rentalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.RENTAL_FEE
     *
     * @param rentalFee the value for gs_banquet_reservation.RENTAL_FEE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRentalFee(String rentalFee) {
        this.rentalFee = rentalFee == null ? null : rentalFee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.GATE_ADVERTISEMENT
     *
     * @return the value of gs_banquet_reservation.GATE_ADVERTISEMENT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getGateAdvertisement() {
        return gateAdvertisement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.GATE_ADVERTISEMENT
     *
     * @param gateAdvertisement the value for gs_banquet_reservation.GATE_ADVERTISEMENT
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setGateAdvertisement(String gateAdvertisement) {
        this.gateAdvertisement = gateAdvertisement == null ? null : gateAdvertisement.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.RAINBOW_ARCHED_ENTRANCE
     *
     * @return the value of gs_banquet_reservation.RAINBOW_ARCHED_ENTRANCE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRainbowArchedEntrance() {
        return rainbowArchedEntrance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.RAINBOW_ARCHED_ENTRANCE
     *
     * @param rainbowArchedEntrance the value for gs_banquet_reservation.RAINBOW_ARCHED_ENTRANCE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRainbowArchedEntrance(String rainbowArchedEntrance) {
        this.rainbowArchedEntrance = rainbowArchedEntrance == null ? null : rainbowArchedEntrance.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.FLYING_BALLOON
     *
     * @return the value of gs_banquet_reservation.FLYING_BALLOON
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getFlyingBalloon() {
        return flyingBalloon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.FLYING_BALLOON
     *
     * @param flyingBalloon the value for gs_banquet_reservation.FLYING_BALLOON
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setFlyingBalloon(String flyingBalloon) {
        this.flyingBalloon = flyingBalloon == null ? null : flyingBalloon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.ROME_FLAG
     *
     * @return the value of gs_banquet_reservation.ROME_FLAG
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRomeFlag() {
        return romeFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.ROME_FLAG
     *
     * @param romeFlag the value for gs_banquet_reservation.ROME_FLAG
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRomeFlag(String romeFlag) {
        this.romeFlag = romeFlag == null ? null : romeFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.RENT_INCLUDED
     *
     * @return the value of gs_banquet_reservation.RENT_INCLUDED
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getRentIncluded() {
        return rentIncluded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.RENT_INCLUDED
     *
     * @param rentIncluded the value for gs_banquet_reservation.RENT_INCLUDED
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setRentIncluded(String rentIncluded) {
        this.rentIncluded = rentIncluded == null ? null : rentIncluded.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.VIDEO_AND_AUDIO
     *
     * @return the value of gs_banquet_reservation.VIDEO_AND_AUDIO
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getVideoAndAudio() {
        return videoAndAudio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.VIDEO_AND_AUDIO
     *
     * @param videoAndAudio the value for gs_banquet_reservation.VIDEO_AND_AUDIO
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setVideoAndAudio(String videoAndAudio) {
        this.videoAndAudio = videoAndAudio == null ? null : videoAndAudio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.OTHER_REQUIREMENTS
     *
     * @return the value of gs_banquet_reservation.OTHER_REQUIREMENTS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getOtherRequirements() {
        return otherRequirements;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.OTHER_REQUIREMENTS
     *
     * @param otherRequirements the value for gs_banquet_reservation.OTHER_REQUIREMENTS
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setOtherRequirements(String otherRequirements) {
        this.otherRequirements = otherRequirements == null ? null : otherRequirements.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gs_banquet_reservation.STATE
     *
     * @return the value of gs_banquet_reservation.STATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gs_banquet_reservation.STATE
     *
     * @param state the value for gs_banquet_reservation.STATE
     *
     * @mbggenerated Fri Nov 17 10:34:22 CST 2017
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

}
