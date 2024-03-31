package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.MemberLoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberLoginHistoryDto {

    Long id;

    String userId;
    LocalDateTime logDt;
    String ip;
    String userAgent;

    //추가컬럼
    long totalCount;
    long seq;

    public static MemberLoginHistoryDto of(MemberLoginHistory memberLoginHistory) {
        return MemberLoginHistoryDto.builder()
                .userId(memberLoginHistory.getUserId())
                .logDt(memberLoginHistory.getLogDt())
                .ip(memberLoginHistory.getIp())
                .userAgent(memberLoginHistory.getUserAgent())
                .build();
    }
    
    public String getLogDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return logDt != null ? logDt.format(formatter) : "";
        
    }
    
}
