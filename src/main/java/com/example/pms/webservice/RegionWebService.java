package com.example.pms.webservice;

import com.example.pms.request.ReqRegion;
import com.example.pms.response.RespStatus;
import com.example.pms.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/region")
public class RegionWebService {

    private final RegionService regionService;

    @PostMapping("/addRegion")
    public RespStatus addRegion(@RequestBody ReqRegion reqRegion) {
        return regionService.addRegion(reqRegion);
    }
}
