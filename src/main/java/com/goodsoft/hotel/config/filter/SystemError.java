package com.goodsoft.hotel.config.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * function 资源不存或服务器内部发生错误时跳转
 * Created by  manjusaka[manjusakachn@gmail.com] on 2017/8/24.
 *
 * @version v1.0
 */
/*@Controller*/
public class SystemError implements ErrorController {
    private static final String ERRORPAHT = "/error";

    @RequestMapping(value = ERRORPAHT)
    public String handleError() {
        return "redirect:/home.html";
    }

    @Override
    public String getErrorPath() {
        return ERRORPAHT;
    }

}
