package com.goodsoft.hotel.domain.entity.dto;

import java.util.Objects;

/**
 * description:
 * ===>用户检索参数辅助实体
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2017-12-03 10:48
 * @version V1.0
 */
public class UserDTO implements java.io.Serializable {

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
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(keyWord, userDTO.keyWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyWord);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "keyWord='" + keyWord + '\'' +
                '}';
    }
}
