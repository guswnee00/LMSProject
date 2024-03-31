package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.MemberLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLoginHistoryRepository extends JpaRepository<MemberLoginHistory, String> {

    List<MemberLoginHistory> findByUserId(String userId);
    Long countByUserId(String userId);
}
