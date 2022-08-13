package com.example.pms.util;

import com.example.pms.model.LogManage;
import com.example.pms.service.LogManageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LogUtil {

    private static LogDetail logDetail;
    private static LogManageService logManageService;

    public LogUtil(LogDetail logDetail, LogManageService logManageService) {
        LogUtil.logDetail = logDetail;
        LogUtil.logManageService = logManageService;
    }

    public static LogManage logging(LogManage logManage) {
        logManage.setIp(logDetail.getIp());
        logManage.setRequestKey(logDetail.getRequestKey());
        logManage.setRequestPath(logDetail.getRequestPath());
        return logManageService.createLog(logManage);
    }

    public static String response(String message) {
        return  "requestKey = '" + logDetail.getRequestKey()
                + "', ip = '" + logDetail.getIp()
                + "', requestPath = '" + logDetail.getRequestPath()
                + "', function response: " + message;
    }

    public static String calling(Object... obj) {
        StringBuilder result = new StringBuilder(
            "requestKey ='" + logDetail.getRequestKey()
                + "', ip = '" + logDetail.getIp()
                + "', requestPath = '" + logDetail.getRequestPath());
        if (!Objects.isNull(obj)) {
            for (Object o : obj) {
                result.append("', function calling with parameter(s) : ");
                if (Objects.isNull(o)) {
                    result.append("Object");
                } else {
                    result.append(o.getClass().getSimpleName().substring(0, 1).toLowerCase())
                            .append(o.getClass().getSimpleName().substring(1));
                }
                result.append("=").append(toStr(o));
            }
        }
        return result.toString();
    }

    private static String toStr(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (Objects.isNull(data))
                return "NULL";
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Mapping error , message : " + e.getMessage());
        }
    }

}
