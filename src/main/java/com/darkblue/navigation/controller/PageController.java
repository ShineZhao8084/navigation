package com.darkblue.navigation.controller;

import com.alibaba.fastjson.JSON;
import com.darkblue.navigation.utils.MonitorUtil;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;

@Controller
public class PageController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
