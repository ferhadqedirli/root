package com.example.pms.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RespRegion implements Serializable {

    private Integer id;
    private String name;
    private Integer cityId;
    private String postalCode;

}
