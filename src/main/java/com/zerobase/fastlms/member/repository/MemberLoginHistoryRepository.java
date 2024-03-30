package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLoginHistoryRepository extends JpaRepository<Member, String> {

}
