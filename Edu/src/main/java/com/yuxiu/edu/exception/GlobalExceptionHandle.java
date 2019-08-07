package com.yuxiu.edu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yangyun
 * @date 2019-08-06 20:11
 */
@ControllerAdvice
public class GlobalExceptionHandle{
    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandle(Model model,Exception e){
        if(e instanceof UserException){
            UserException exception= (UserException) e;
            String error=exception.getMessage();
            model.addAttribute("error",error);
            return "login";
        }
        model.addAttribute("error","服务器崩溃了，请稍后在访问！！！");
        return "error";
    }
}
