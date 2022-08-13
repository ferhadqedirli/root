package com.example.pms.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
@Component
public class Method {

    private final RestTemplate restTemplate;

    public Method(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            if (requestAttributes instanceof ServletRequestAttributes) {
                return ((ServletRequestAttributes) requestAttributes).getRequest();
            }
        }
        return null;
    }

    public static String getClientIp(HttpServletRequest request) {
        if (request != null) {
            String remoteAddr = request.getHeader("X-Forwarded-For");
            if (remoteAddr == null) {
                remoteAddr = request.getRemoteAddr();
            }
            return remoteAddr;
        } else {
            return null;
        }
    }

    public static String getRequestPath(HttpServletRequest httpServletRequest) {
        if (httpServletRequest != null) {
            String requrstUri = httpServletRequest.getRequestURI();
            String requestPath = requrstUri.substring(httpServletRequest.getContextPath().length());
            return requestPath;
        } else {
            return null;
        }

    }

    public ResponseEntity<String> sendGet(String url, HttpHeaders httpHeaders) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }

}
