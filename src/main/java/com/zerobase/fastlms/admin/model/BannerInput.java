package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class BannerInput {
    Long id;

    String bannerName;
    String bannerUrl;

    int openCase;
    int order;
    boolean displayYn;

    String fileName;
    String urlFileName;

    String ids;
}
