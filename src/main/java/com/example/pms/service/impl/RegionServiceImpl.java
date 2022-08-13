package com.example.pms.service.impl;

import com.example.pms.enums.EnumLogAction;
import com.example.pms.enums.EnumLogLevel;
import com.example.pms.exception.ExceptionConstants;
import com.example.pms.model.LogManage;
import com.example.pms.model.Region;
import com.example.pms.repository.RegionRepository;
import com.example.pms.request.ReqRegion;
import com.example.pms.request.converter.RegionConverter;
import com.example.pms.response.RespStatus;
import com.example.pms.service.RegionService;
import com.example.pms.util.LogDetail;
import com.example.pms.util.NumberFunctions;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.pms.util.LogUtil.*;
import static com.example.pms.util.PrintStackTrace.printStackTraceString;
import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
@Log4j2
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
public class RegionServiceImpl implements RegionService {

    private static final Logger LOGGER = LogManager.getLogger(RegionServiceImpl.class);

    private final RegionRepository regionRepository;
    private final LogDetail logDetail;
    private final RegionConverter regionConverter;

    @Transactional
    @Override
    public RespStatus addRegion(ReqRegion reqRegion) {
        logging(new LogManage(EnumLogAction.REQUEST, EnumLogLevel.INFO, reqRegion));
        LOGGER.info("requestKey = '" + logDetail.getRequestKey() + "',ip='" + logDetail.getIp() + "', requestPath = '"
                + logDetail.getRequestPath() + "', method calling with parameter(s) : reqRegion = " + reqRegion);
        Integer cityId = reqRegion.getCityId();
        String name = reqRegion.getName();
        String postalCode = reqRegion.getPostalCode();
        try {
            if (isNull(cityId) || isNull(name)) {
                LOGGER.info(calling());
                logging(new LogManage(EnumLogAction.RESPONSE, EnumLogLevel.WARN, "Invalid request data"));
                return new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Region region = regionConverter.requestToRegion(reqRegion);
            regionRepository.save(region);
            logging(new LogManage(EnumLogAction.RESPONSE, EnumLogLevel.INFO, "success"));
            LOGGER.info(response("response: success"));
        } catch (Exception e) {
            if (e instanceof UncategorizedSQLException) {
                logging(new LogManage(EnumLogAction.RESPONSE, EnumLogLevel.ERROR,
                        "Adding region failed " + printStackTraceString(e)));
                LOGGER.error(response("Adding region failed"), e);
                return new RespStatus(ExceptionConstants.ADDING_REGION_FAILED, "db response: Adding region failed");
            }
            int randomNumber = NumberFunctions.getRandomNumber();
            logging(new LogManage(EnumLogAction.RESPONSE, EnumLogLevel.ERROR,
                    "Internal exception " + randomNumber + printStackTraceString(e)));
            LOGGER.error(response("response: Internal exception " + randomNumber), e);
            return new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal exception");
        }
        return RespStatus.getSuccessMessage();
    }

    @Override
    public RespStatus updateRegion(ReqRegion reqRegion) {
        return null;
    }

    @Override
    public Region getById(Integer id) {
        return null;
    }

    @Override
    public List<Region> getAll() {
        return null;
    }

    @Override
    public List<Region> getAllByCityId(Integer cityId) {
        return null;
    }

    public RegionRepository getRegionRepository() {
        return regionRepository;
    }
}
