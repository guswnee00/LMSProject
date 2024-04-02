package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        return null;
    }

    @Override
    public boolean add(BannerInput parameter) {
        return false;
    }

    @Override
    public boolean update(BannerInput parameter) {
        return false;
    }

    @Override
    public boolean del(String ids) {
        return false;
    }

    @Override
    public BannerDto detail(long id) {
        return null;
    }

    @Override
    public List<BannerDto> frontList(BannerParam parameter) {
        return null;
    }

}
