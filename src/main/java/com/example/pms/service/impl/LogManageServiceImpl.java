package com.example.pms.service.impl;

import com.example.pms.model.LogManage;
import com.example.pms.repository.LogManageRepository;
import com.example.pms.service.LogManageService;
import org.springframework.stereotype.Service;

@Service
public class LogManageServiceImpl implements LogManageService {

    private final LogManageRepository logManageRepository;

    public LogManageServiceImpl(LogManageRepository logManageRepository) {
        this.logManageRepository = logManageRepository;
    }

    @Override
    public LogManage createLog(LogManage logManage) {
        LogManage log = null;
        try {
            log = logManageRepository.insert(logManage);
        } catch (Exception e) {
            return log;
        }
        return log;
    }
}
