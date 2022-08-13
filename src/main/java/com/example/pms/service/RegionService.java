package com.example.pms.service;

import com.example.pms.model.Region;
import com.example.pms.request.ReqRegion;
import com.example.pms.response.RespStatus;

import java.util.List;

public interface RegionService {

    RespStatus addRegion(ReqRegion reqRegion);

    RespStatus updateRegion(ReqRegion reqRegion);

    Region getById(Integer id);

    List<Region> getAll();

    List<Region> getAllByCityId(Integer cityId);

}
