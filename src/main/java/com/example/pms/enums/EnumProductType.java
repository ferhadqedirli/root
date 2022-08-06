package com.example.pms.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumProductType {

    FINISHED_PRODUCT(1),
    SEMI_FINISHED_PRODUCT(2),
    RAW_MATERIAL(3),
    COMMERCIAL_PRODUCT(4);

    private final Integer value;

    private static final Map<Integer, EnumProductType> VALUES = new ConcurrentHashMap<>();

    EnumProductType(Integer enumValue) {
        this.value = enumValue;
    }

    static {
        for (EnumProductType type : EnumProductType.values()) {
            VALUES.put(type.value, type);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static EnumProductType getEnum(Integer value) {
        if (value == null) {
            return null;
        }
        return VALUES.get(value);
    }

}
