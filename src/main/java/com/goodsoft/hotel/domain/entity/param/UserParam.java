package com.goodsoft.hotel.domain.entity.param;

import java.util.Objects;

/**
 * description:
 * ===>用户检索参数辅助实体
 *
 * @author 严彬荣 Created on 2017-12-03 10:48
 * @version V1.0
 */
public class UserParam implements java.io.Serializable {

    private static final long serialVersionUID = 8354815646373900929L;

    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserParam)) return false;
        UserParam userParam = (UserParam) o;
        return Objects.equals(keyWord, userParam.keyWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyWord);
    }
}
