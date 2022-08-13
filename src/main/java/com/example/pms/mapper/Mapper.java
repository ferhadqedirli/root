package com.example.pms.mapper;

import com.example.pms.exception.ParseException;
import com.example.pms.util.LogDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
@PropertySource(value = {"classpath:config.properties"}, encoding = "UTF-8")
public class Mapper<T> {

    private final Environment env;
    private final LogDetail logDetail;

    private static final Logger LOGGER = LogManager.getLogger(Mapper.class);
    private static final DateFormat dft = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Mapper(Environment env, LogDetail logDetail) {
        this.env = env;
        this.logDetail = logDetail;
    }

    public String toStr(T data/*, Class<T> tClass*/) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ParseException("Mapping error , message : " + e.getMessage());
        }
    }

    public String toStr(T data, Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ParseException("Mapping error , message : " + e.getMessage());
        }
    }

    public <T> T toObj(String data, Class<T> tClass) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            return mapper.readValue(data, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException("Mapping error , message : " + e.getMessage());
        }
    }

    public Long extractIdFromLink(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            String href = jsonObject.getJSONObject("_links").getJSONObject("self").getString("href");
            return Long.valueOf(href.replaceAll("[^0-9]", ""));
        } catch (Exception ex){
            return null;
        }
    }

}
