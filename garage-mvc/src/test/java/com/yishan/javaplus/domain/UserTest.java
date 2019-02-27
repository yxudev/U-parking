//package com.yishan.javaplus.domain;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.springframework.expression.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.StringContains.containsString;
//
//public class UserTest {
//
//    @Test
//    public void whenUsingCustomDateSerializer_thenCorrect()
//            throws JsonProcessingException, ParseException {
//
//        UserTest userTest = new UserTest("party", userTest);
//
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//
//        String toParse = "20-12-2014";
//        Date date = null;
//        try {
//            date = df.parse(toParse);
//        } catch (java.text.ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        String result = mapper.writeValueAsString(userTest);
//        assertThat(result, containsString(toParse));
//    }
//}
