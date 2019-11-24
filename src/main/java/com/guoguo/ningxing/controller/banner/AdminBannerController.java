package com.guoguo.ningxing.controller.banner;

import com.guoguo.ningxing.entity.banner.Banner;
import com.guoguo.ningxing.service.banner.BannerService;
import com.guoguo.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminBannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/bannerModify")
    public String bannerModify(HttpServletRequest request) {
        Banner banner = bannerService.getBanner();
        request.setAttribute("banner", banner);
        return "admin/banner/bannerModify";
    }

    @RequestMapping("/ajax/bannerModify")
    @ResponseBody
    public Json bannerModify(@RequestParam("url") String url, Long id) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setUrl(url);
        if (id == null) {
            bannerService.addBanner(banner);
        } else {
            bannerService.updateBannerById(banner);
        }
        return Json.jsonTrue("操作成功");
    }
}
