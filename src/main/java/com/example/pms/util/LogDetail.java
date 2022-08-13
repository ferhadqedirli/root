package com.example.pms.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDetail {

    private String requestKey;
    private String requestPath;
    private String ip;

}
