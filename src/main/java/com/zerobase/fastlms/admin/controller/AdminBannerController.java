package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import com.zerobase.fastlms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController {

    private final BannerService bannerService;

    @GetMapping("/admin/banner/list.do")
    public String list(Model model, BannerParam parameter) {
        parameter.init();
        List<BannerDto> bannerlist = bannerService.list(parameter);

        long totalCount = 0;
        if (!CollectionUtils.isEmpty(bannerlist)) {
            totalCount = bannerlist.get(0).getTotalCount();
        }
        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", bannerlist);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/banner/list";
    }

    @GetMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
    public String add(Model model, HttpServletRequest request, BannerInput parameter) {
        boolean editMode = request.getRequestURI().contains("/edit.do");
        BannerDto detail = new BannerDto();

        if (editMode) {
            long id = parameter.getId();
            BannerDto existBanner = bannerService.detail(id);
            if (existBanner == null) {
                model.addAttribute("message", "배너 정보가 존재하지 않습니다.");
                return "common/error";
            }
            detail = existBanner;
        }
        model.addAttribute("editMode", editMode);
        model.addAttribute("detail", detail);

        return "admin/banner/add";
    }

    //TODO
    // -banner에 맞게 수정하기
    @PostMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
    public String addSubmit(Model model, HttpServletRequest request
            , MultipartFile file, BannerInput parameter) {

        String saveFilename = "";
        String urlFilename = "";

        if (file != null) {
            String originalFilename = file.getOriginalFilename();

            String baseLocalPath = "/Users/hyunjulee/Desktop/zerobase/LMSProject/src/main/webapp/banner";
            String baseUrlPath = "/banner";

            String[] arrFilename = FileUtil.getNewSaveFile(baseLocalPath, baseUrlPath, originalFilename);

            saveFilename = arrFilename[0];
            urlFilename = arrFilename[1];

            try {
                File newFile = new File(saveFilename);
                FileCopyUtils.copy(file.getInputStream(), Files.newOutputStream(newFile.toPath()));
            } catch (IOException e) {
                log.info("############################ - 1");
                log.info(e.getMessage());
            }
        }

        parameter.setFileName(saveFilename);
        parameter.setUrlFileName(urlFilename);

        boolean editMode = request.getRequestURI().contains("/edit.do");

        if (editMode) {
            long id = parameter.getId();
            BannerDto existCourse = bannerService.detail(id);
            if (existCourse == null) {
                // error 처리
                model.addAttribute("message", "배너정보가 존재하지 않습니다.");
                return "common/error";
            }

            boolean result = bannerService.update(parameter);

        } else {
            boolean result = bannerService.add(parameter);
        }

        return "redirect:/admin/banner/list.do";
    }


    @PostMapping("/admin/banner/delete.do")
    public String del(Model model, HttpServletRequest request, BannerInput parameter) {

        boolean result = bannerService.del(parameter.getIds());

        return "redirect:/admin/banner/list.do";
    }

}
