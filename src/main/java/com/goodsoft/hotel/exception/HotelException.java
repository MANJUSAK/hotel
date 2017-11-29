package com.goodsoft.hotel.exception;

/**
 * description:
 * ===>系统异常统一处理类
 *
 * @author 严彬荣 Created on 2017-11-27 10:04
 * @version V1.0
 */
public class HotelException extends Exception {

    private static final long serialVersionUID = -7899357411871887321L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public HotelException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public HotelException(String message) {
        super(message);
    }

}
