package com.example.pms.enums;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ToString
@NoArgsConstructor
public enum EnumExceptions {

    INTERNAL_EXCEPTION(100, "Internal exception"),
    INVALID_REQUEST_DATA(101, "Invalid request data"),
    GETTING_DATA_FAILED(102, "Getting data failed");

    private Integer code;
    private String message;

    private static final Map<Integer, EnumExceptions> INTEGER_KEYS_MAP = new ConcurrentHashMap<>();

    private static final Map<String, EnumExceptions> STRING_KEYS_MAP = new ConcurrentHashMap<>();

    static {
        for (EnumExceptions type : EnumExceptions.values()) {
            INTEGER_KEYS_MAP.put(type.code, type);
        }
        for (EnumExceptions type : EnumExceptions.values()) {
            STRING_KEYS_MAP.put(type.message, type);
        }
    }

    EnumExceptions(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static EnumExceptions getEnum(Integer value) {
        if (value == null)
            return null;
        return INTEGER_KEYS_MAP.get(value);
    }

    public static EnumExceptions getEnum(String value) {
        if (value == null)
            return null;
        return STRING_KEYS_MAP.get(value);
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
