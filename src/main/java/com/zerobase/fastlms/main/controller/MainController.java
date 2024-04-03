package com.zerobase.fastlms.main.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model, BannerParam param) {
        List<BannerDto> bannerDtoList = bannerService.frontList(param);
        model.addAttribute("list", bannerDtoList);
        return "index";
    }
    

    @RequestMapping("/error/denied")
    public String errorDenied() {
        
        return "error/denied";
    }
    
    
    
}
