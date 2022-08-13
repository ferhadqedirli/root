package com.example.pms.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRegion implements Serializable {

    private Integer id;
    private String name;
    private Integer cityId;
    private String postalCode;

}
