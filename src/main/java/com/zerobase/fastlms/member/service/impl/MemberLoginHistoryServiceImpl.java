package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.MemberLoginHistoryDto;
import com.zerobase.fastlms.member.entity.MemberLoginHistory;
import com.zerobase.fastlms.member.repository.MemberLoginHistoryRepository;
import com.zerobase.fastlms.member.service.MemberLoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberLoginHistoryServiceImpl implements MemberLoginHistoryService {

    private final MemberLoginHistoryRepository historyRepository;

    @Override
    public void save(String userId, String ip, String userAgent) {
        historyRepository.save(
                MemberLoginHistory.builder()
                        .userId(userId)
                        .logDt(LocalDateTime.now())
                        .ip(ip)
                        .userAgent(userAgent)
                        .build()
        );
    }

    @Override
    public List<MemberLoginHistoryDto> list(String userId) {

        long totalCount = historyRepository.countByUserId(userId);
        List<MemberLoginHistory> historyList = historyRepository.findByUserId(userId);
        List<MemberLoginHistoryDto> historyDtoList = new ArrayList<>();

        for (MemberLoginHistory history : historyList) {
            historyDtoList.add(MemberLoginHistoryDto.of(history));
        }
        if (!CollectionUtils.isEmpty(historyList)) {
            int i = 0;
            for (MemberLoginHistoryDto x: historyDtoList) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - i);
                i++;
            }
        }

        return historyDtoList;
    }
}