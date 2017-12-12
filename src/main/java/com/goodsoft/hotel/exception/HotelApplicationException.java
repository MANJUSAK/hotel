package com.goodsoft.hotel.exception;

/**
 * description:
 * ===>系统应用程序异常处理类
 *
 * @author  manjusaka[manjusakachn@gmail.com] Created on 2017-11-28 17:14
 * @version V1.0
 */
public class HotelApplicationException extends Exception {

    private static final long serialVersionUID = -2440988263352092995L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public HotelApplicationException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public HotelApplicationException(String message) {
        super(message);
    }
}
