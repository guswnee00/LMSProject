package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);
        List<BannerDto> bannerList = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(bannerList)) {
            int i = 0;
            for (BannerDto x: bannerList) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return bannerList;
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .bannerUrl(parameter.getBannerUrl())
                .openCase(parameter.getOpenCase())
                .order(parameter.getOrder())
                .displayYn(parameter.isDisplayYn())
                .regDt(LocalDateTime.now())
                .fileName(parameter.getFileName())
                .urlFileName(parameter.getUrlFileName())
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean update(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setBannerUrl(parameter.getBannerUrl());
        banner.setOpenCase(parameter.getOpenCase());
        banner.setOrder(parameter.getOrder());
        banner.setDisplayYn(parameter.isDisplayYn());
        banner.setFileName(parameter.getFileName());
        banner.setUrlFileName(parameter.getUrlFileName());
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean del(String ids) {
        if (ids != null && !ids.isEmpty()) {
            String[] idList = ids.split(",");
            for (String s: idList) {
                long id = 0L;
                try {
                    id = Long.parseLong(s);
                } catch (Exception e) {

                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }

    @Override
    public BannerDto detail(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public List<BannerDto> frontList(BannerParam parameter) {
        return bannerMapper.showList(parameter);
    }

}
