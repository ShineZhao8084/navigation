package com.darkblue.navigation.controller;

import com.alibaba.fastjson.JSON;
import com.darkblue.navigation.bean.AjaxResponseBody;
import com.darkblue.navigation.utils.MonitorUtil;
import org.hyperic.sigar.SigarException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
public class SystemController {

    @RequestMapping(path = "/system", method = RequestMethod.POST)
    public String getSystemProperty() throws SigarException, UnknownHostException {
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        ajaxResponseBody.setMsg("获取系统信息成功！");
        ajaxResponseBody.setResult(MonitorUtil.getSystemProperty());
        return JSON.toJSONString(ajaxResponseBody);
    }

    @RequestMapping(path = "/monitor", method = RequestMethod.POST)
    public String getMonitorProperty() throws SigarException, UnknownHostException {
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        ajaxResponseBody.setMsg("获取系统信息成功！");
        ajaxResponseBody.setResult(MonitorUtil.getDynamicProperties());
        return JSON.toJSONString(ajaxResponseBody);
    }

}
