package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.member.service.MemberLoginHistoryService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberLoginHistoryService historyService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String userId = authentication.getName();
        String ip = RequestUtils.getClientIp(request);
        String userAgent = RequestUtils.getUserAgent(request);

        this.historyService.save(userId, ip, userAgent);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
