package com.example.app.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/11/12
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class indexControl {
    @RequestMapping("index")
    public String index(){
        return "index.html";
    }
}
