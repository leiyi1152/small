package com.icloud.font;

import cn.hutool.captcha.generator.RandomGenerator;
import com.icloud.basecommon.service.redis.RedisService;
import com.icloud.common.util.StringUtil;
import com.icloud.config.global.MyPropertitys;
import com.icloud.modules.wx.entity.WxUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 前后端分离之h5登陆
 */
@Slf4j
@Controller
@RequestMapping("/frontpage/h5login")
public class H5LoginController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MyPropertitys myPropertitys;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/login")
    public String login(String fromType){
        log.info("fromType=="+fromType);
        if(!StringUtil.checkStr(fromType)){
            log.info("fromType不能为空");
            return "modules/h5login/error";//
        }
        try {
            WxUser user = (WxUser)request.getSession().getAttribute("wx_user");
            Map<String,String> map = myPropertitys.getThirdloginUrlMap();
            if(!map.containsKey(fromType)){
                log.info("未授权的请求地址");
                return "modules/h5login/error";//
            }
            String h5token = new RandomGenerator(12).generate();
            redisService.set(h5token,user,3000L);//兼容h5、APP 前端服务 登陆

            String redirectUrl = map.get(fromType).toString();
            log.info("redirectUrl=="+ redirectUrl);
            response.sendRedirect(redirectUrl+"?token="+ h5token);
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "modules/h5login/error";
    }
}
