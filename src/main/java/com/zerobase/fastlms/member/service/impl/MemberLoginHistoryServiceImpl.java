package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.member.service.MemberLoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO
@RequiredArgsConstructor
@Service
public class MemberLoginHistoryServiceImpl implements MemberLoginHistoryService {

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public List<?> list() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

}