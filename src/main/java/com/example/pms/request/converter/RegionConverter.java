package com.example.pms.request.converter;

import com.example.pms.model.Region;
import com.example.pms.request.ReqRegion;
import org.springframework.stereotype.Component;

@Component
public class RegionConverter {

    public Region requestToRegion(ReqRegion reqRegion) {
        Region region = new Region();
        region.setId(reqRegion.getId());
        region.setCityId(reqRegion.getCityId());
        region.setName(reqRegion.getName());
        region.setPostalCode(reqRegion.getPostalCode());
        return region;
    }

}
