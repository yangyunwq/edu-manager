package com.yuxiu.edu.controller;

import cn.dsna.util.images.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/**
 * @author yangyun
 * @date 2019-08-06 16:46
 */
@Controller
public abstract class BaseController<T> {
    protected static String MANAGE_PAGE;
    protected static String EDIT_PAGE;
    protected static String INFO_PAGE;
    protected static String UPDATE_PAGE;


    public BaseController() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<?> clazz = (Class<?>) type.getActualTypeArguments()[0];
        String modelName = clazz.getSimpleName().toLowerCase();
        MANAGE_PAGE = "Modules/" + modelName + "/" + modelName + "Manage";
        EDIT_PAGE = "Modules/" + modelName + "/" + modelName + "Edit";
        INFO_PAGE = "Modules/" + modelName + "/" + modelName + "Info";
        UPDATE_PAGE = "Modules/" + modelName + "/" + modelName + "Update";
    }

    @RequestMapping("login")
    public String login(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(100, 40, 4, 8);
        response.setContentType("image/png");
        request.getSession().setAttribute("code", code.getCode());
        try {
            code.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
