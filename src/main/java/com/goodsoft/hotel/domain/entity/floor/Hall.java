package com.goodsoft.hotel.domain.entity.floor;

/**
 * Created by duyuxiang on 2017/11/17.
 * 餐饮分厅
 */
public class Hall {

    private String id;
    private String hallName; //厅名
    private String hallDescride; //厅堂描述
    private String hallPic;      //厅堂图片
    private String hallType;     //厅堂类型

    public Hall() {
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id='" + id + '\'' +
                ", hallName='" + hallName + '\'' +
                ", hallDescride='" + hallDescride + '\'' +
                ", hallPic='" + hallPic + '\'' +
                ", hallType='" + hallType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallDescride() {
        return hallDescride;
    }

    public void setHallDescride(String hallDescride) {
        this.hallDescride = hallDescride;
    }

    public String getHallPic() {
        return hallPic;
    }

    public void setHallPic(String hallPic) {
        this.hallPic = hallPic;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }
}
