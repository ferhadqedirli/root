package com.example.pms.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> {

    public static final SimpleDateFormat DATE = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        if (date == null) {
            jsonGenerator.writeNull();
        } else {
            String dateStr = DATE_TIME.format(date);
            String subStr =dateStr.substring(11, 19);
            if (subStr.equals("00:00:00")) {
                jsonGenerator.writeString(DATE.format(date));
            } else {
                jsonGenerator.writeString(dateStr);
            }
        }

    }
}
