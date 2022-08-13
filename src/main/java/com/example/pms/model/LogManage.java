package com.example.pms.model;

import com.example.pms.enums.EnumLogAction;
import com.example.pms.enums.EnumLogLevel;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;


@Document(collection = "LogManage")
public class LogManage {

    @Id
    private String id;
    private String requestKey;
    private String requestPath;
    private String ip;
    private EnumLogAction logAction;
    private String logText;
    private EnumLogLevel logLevel;
    private Date logDate;

    public LogManage() {
    }

    public LogManage(EnumLogAction logAction, EnumLogLevel logLevel, Object logText) {
        this.logAction = logAction;
        this.logText = logText == null ? null : logText.toString();
        this.logLevel = logLevel;
        this.logDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public EnumLogAction getLogAction() {
        return logAction;
    }

    public void setLogAction(EnumLogAction logAction) {
        this.logAction = logAction;
    }

    public String getLogText() {
        return logText;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }

    public EnumLogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(EnumLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}
