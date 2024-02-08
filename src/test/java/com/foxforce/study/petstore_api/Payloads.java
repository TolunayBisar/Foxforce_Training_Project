package com.foxforce.study.petstore_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author : tolunaybisar
 * @created : 8.02.2024,19:50
 * @Email :tolunay.bisar@gmail.com
 **/
public class Payloads {
    public static String payload(){

        String payload = null;
        PayloadsObject payloadObject = new PayloadsObject(0,"string","string","string","available");
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(payloadObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;
    }
    public static String randomText(String a){
        String randomText = RandomStringUtils.randomAlphabetic(5);
        return a+randomText;

    }



}
