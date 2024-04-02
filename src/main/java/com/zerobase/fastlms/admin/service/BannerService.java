package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {
    /**
     * 배너 리스트
     */
    List<BannerDto> list(BannerParam parameter);

    /**
     * 배너 추가
     */
    boolean add(BannerInput parameter);

    /**
     * 배너 수정
     */
    boolean update(BannerInput parameter);

    /**
     * 배너 삭제(선택삭제)
     */
    boolean del(String ids);

    /**
     * 회원 상세 정보
     */
    BannerDto detail(long id);


    /**
     * 보여줄 배너 목록
     */
    List<BannerDto> frontList(BannerParam parameter);


}
