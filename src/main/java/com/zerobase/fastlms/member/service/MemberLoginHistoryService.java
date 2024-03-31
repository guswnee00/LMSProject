package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberLoginHistoryDto;
import com.zerobase.fastlms.member.model.MemberLoginHistoryInput;

import java.util.List;

public interface MemberLoginHistoryService {

    /**
     * 로그인 히스토리 저장
     */
    void save(String userId, String ip, String userAgent);
    
    /**
     * 로그인 목록 리턴(관리자에서만 사용 가능)
     */
    List<MemberLoginHistoryDto> list(String userId);

}
