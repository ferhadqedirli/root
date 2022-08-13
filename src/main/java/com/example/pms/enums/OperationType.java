package com.example.pms.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum OperationType {

    CASH_INCOME_OPERATION(1),
    CASH_EXPENSE_OPERATION(2),
    OTHER_INCOME_OPERATION(3),
    OTHER_EXPENSE_OPERATION(4),
    CASH_TRANSFER_OPERATION(5),
    SALE_OPERATION(6),
    RETURN_FROM_BUYER_OPERATION(7),
    PURCHASE_OPERATION(8),
    RETURN_TO_SUPPLIER_OPERATION(9),
    IMPORT_OF_GOODS_OPERATION(10),
    REMOVAL_OF_GOODS_OPERATION(11),
    MOVEMENT_OF_GOODS_OPERATION(12);

    private final Integer value;

    private static final Map<Integer, OperationType> VALUES = new ConcurrentHashMap<>();

    OperationType(Integer enumValue) {
        this.value = enumValue;
    }

    static {
        for (OperationType type : OperationType.values()) {
            VALUES.put(type.value, type);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static OperationType getEnum(Integer value) {
        if (value == null) {
            return null;
        }
        return VALUES.get(value);
    }

}
