package com.zerobase.fastlms.member.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class MemberLoginHistoryInput {
    String userId;
    LocalDateTime logDt;
    String ip;
    String userAgent;
}
