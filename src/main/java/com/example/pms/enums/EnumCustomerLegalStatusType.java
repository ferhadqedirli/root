package com.example.pms.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumCustomerLegalStatusType {

    JURIDICAL(1),
    INDIVIDUAL(2),
    SIMPLE(3);

    private final Integer value;

    private static final Map<Integer, EnumCustomerLegalStatusType> VALUES = new ConcurrentHashMap<>();

    EnumCustomerLegalStatusType(Integer enumValue) {
        this.value = enumValue;
    }

    static {
        for (EnumCustomerLegalStatusType type : EnumCustomerLegalStatusType.values()) {
            VALUES.put(type.value, type);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static EnumCustomerLegalStatusType getEnum(Integer value) {
        if (value == null) {
            return null;
        }
        return VALUES.get(value);
    }

}
