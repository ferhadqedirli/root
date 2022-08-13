package com.example.pms.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateDeserializer extends JsonDeserializer<Date> {

    public static final SimpleDateFormat DATE = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    @SneakyThrows
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        String dateAsString = jsonParser.getText().trim();
            try {
                return DateUtils.parseDate(dateAsString,
                        "dd.MM.yyyy",
                        "dd.MM.yyyy HH:mm:ss",
                        "yyyy-MM-dd",
                        "yyyy-MM-dd HH:mm:ss",
                        "dd-MM-yyyy",
                        "dd-MM-yyyy HH:mm:ss"
                );
            } catch (Exception e) {
                return new Date(jsonParser.getValueAsLong());
            }
    }
}
