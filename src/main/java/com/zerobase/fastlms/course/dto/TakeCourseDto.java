package com.zerobase.fastlms.course.dto;

import com.zerobase.fastlms.course.entity.TakeCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TakeCourseDto {
    
    long id;
    long courseId;
    String userId;

    //결제금액
    long payPrice;

    //상태(수강신청, 결재완료, 수강취소)
    String status;

    //신청일
    LocalDateTime regDt;

    // JOIN
    String userName;
    String phone;
    String subject;

    //추가컬럼
    long totalCount;
    long seq;
    
    public static TakeCourseDto of(TakeCourse x) {
    
        return TakeCourseDto.builder()
                .id(x.getId())
                .courseId(x.getCourseId())
                .userId(x.getUserId())
                .payPrice(x.getPayPrice())
                .status(x.getStatus())
                .regDt(x.getRegDt())
                .build();
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = ofPattern("yyyy.MM.dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }
    
}
















