package com.example.pms.config;

import com.example.pms.util.LogDetail;
import com.example.pms.util.Method;
import com.example.pms.util.OidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class GeneralConfig {

    @Bean
    public RestTemplate getRestTemp() throws Exception {
        return new RestTemplate();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public LogDetail logDetail() {
        LogDetail logDetail = new LogDetail();
        logDetail.setRequestKey(OidGenerator.generateOid());
        HttpServletRequest httpServletRequest = Method.getCurrentRequest();
        if (httpServletRequest != null) {
            logDetail.setIp(Method.getClientIp(httpServletRequest));
            logDetail.setRequestPath(Method.getRequestPath(httpServletRequest));
        }
        return logDetail;
    }

}
