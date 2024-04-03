package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto {

    Long id;

    String bannerName;
    String bannerUrl;

    int openCase;
    int sort;
    boolean displayYn;

    LocalDateTime regDt;

    String fileName;
    String urlFileName;

    long totalCount;
    long seq;

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return regDt != null ? regDt.format(formatter) : "";
    }

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .bannerUrl(banner.getBannerUrl())
                .openCase(banner.getOpenCase())
                .sort(banner.getSort())
                .displayYn(banner.isDisplayYn())
                .regDt(banner.getRegDt())
                .fileName(banner.getFileName())
                .urlFileName(banner.getUrlFileName())
                .build();
    }
}
