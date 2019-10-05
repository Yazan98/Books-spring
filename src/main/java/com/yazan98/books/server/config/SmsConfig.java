package com.yazan98.books.server.config;

import com.yazan98.books.server.utils.ApplicationConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class SmsConfig {

    public void sendSms(String senderContent , String content , String reciver) {
        try {
            // Construct data
            String apiKey = "apikey=" + ApplicationConstants.SMS_API_KEY;
            String message = "&message=" + content;
            String sender = "&sender=" + senderContent;
            String numbers = "&numbers=" + reciver;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuilder stringBuffer = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

        } catch (Exception e) {
            System.out.println("Error SMS "+e);
        }
    }

    @Bean
    public SmsConfig getSendSMS(){
        return new SmsConfig();
    }

}
