package com.zerobase.fastlms.member.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

//TODO
public interface MemberLoginHistoryService extends UserDetailsService {

    /**
     * 로그인 히스토리 저장
     */
    boolean save();
    
    /**
     * 로그인 목록 리턴(관리자에서만 사용 가능)
     */
    List<?> list();

}
