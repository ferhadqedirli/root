package com.example.pms.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumDocumentType {

    PURCHASE_DOC(1),
    SALE_DOC(2),
    STOCK_DOC(3),
    CASH_DOC(4);

    private final Integer value;

    private static final Map<Integer, EnumDocumentType> VALUES = new ConcurrentHashMap<>();

    EnumDocumentType(Integer enumValue) {
        this.value = enumValue;
    }

    static {
        for (EnumDocumentType type : EnumDocumentType.values()) {
            VALUES.put(type.value, type);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static EnumDocumentType getEnum(Integer value) {
        if (value == null) {
            return null;
        }
        return VALUES.get(value);
    }

}
