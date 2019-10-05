package com.yazan98.books.server.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:16 AM
 */

@Configuration
public class FirebaseConfiguration {

    @Bean
    public FirebaseApp getFirebaseApplication() throws IOException {

        String firebaseServiceAccount = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"bookie-c01fa\",\n" +
                "  \"private_key_id\": \"2e8aa3e730aac0d8954432bb42eb37cadb565c1d\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDYHRK0CJ7gXyQ5\\n49z6KAr7supFmzBUDEfnQRsH6YwnEIdzGPzjK5ZEfHV/pSnHKlqF8R43DhtdaBZx\\nbjg4MXRLloOnhT53pamVcR9uwySFFBIUs4T9qls+svNOLYRo3kDAeAVOZkUNJ5XK\\n+XRHCNlidEprZYqc2wCfcUNeatfJoxnQW57dBgxuxm+Eqx+cqE8JFqsoh4Iobjrt\\non8PTzhj+b/dh6xzN95dWjn2V2fMm9DyTPFsoOF9B8Xa0ejCJ9mCVdtaO0Eira3z\\nx+QF2K7nqlBgbI49TYg0y4a/hpYPY8qtHxyPzxTgr0k5TzERYIKk8YZbqEiEXy+J\\nJ3d9IkN7AgMBAAECggEAAsfTRCMD+N01FcHhIwxCIaHqdwQXEwXDbaTHTS9Ck03P\\nWp7TnP4R7oZc2PDOJXI5ITp6LouWa4wHXnc/ylsDZPgmJxD8ByDH45SzYXmptyBV\\nVu+PgmoD69A9eLtjVfU49Q62RHrkzh6YVm+4gMZUA/rqoVmKwDxUQjjp6nxvAVQy\\nMN+CujFSba18+8VYV1yIKIiVhFzTP0rtS9GdKpD2SXl3148QLkYipHP/k7bZF6Pw\\niwuMKFgCdcd4HRx4sfEiPhEL+UxCdK/jLsSV2CoekXekbWAcRE5pXry+gFYFL/OJ\\n/rZB8awrK4OeT4aJOCUg9x3O9PTtkKD31BjLmo8vBQKBgQD250N3lnJgoa9Ftv/z\\nwRW1wZjThr3bFtvMcUbpyGVwi0sMtW8o/EeL+heGS9qIRV+ZLA/wybFlBCn0DNSq\\n9r190Tzh9+qv8fTLxmXLg9nHtKpMbwARtAgJ8V3ElpFjqIT+oXzbsCADcprlffjV\\nVZMF9z2OuAXZX0oUSgxZuc/WDwKBgQDgE2g1VNTBrqArDCzyskzDw3BLiWVSoctU\\nY2cwg4d6/WJKqqaiVFc++U4DOz23zbRB+KbaoflTdqeB9H+32LIah8kBsYbgv/Bf\\nmo30G7ygPSZuXwiftsz5t+lWh/TXw53SPIYDvcE+w0Knscx+Lj2y57dI4VJtzgai\\nIjnvkrlH1QKBgBMghUx9Xiz4OZDIBXoHqjvjXIh+drTDR5HF8L1ppdobIFxCrfLZ\\n4F0KqcnglHRcE3TVQgLgTRrLQMjEObFo3fMiQ3op74dj0hf7LaWfeD6NU2gKbVHx\\nxXGnviDdnTPAOVVUg0ytjz1VIoTGxoEYWQRsS9uDjAhz5lQ+DEjjKSOnAoGBAJgB\\nUk3rcDC7b3gEWHGDNsQOTp1PZWa6zx4+GIA2ma97ODSCs2unX1Ae+ycCBworBz9B\\nmJ70BhjygwuLeyCSZa/NsTPu5BqO2ldgly+jqT/ie7Gf0k/WSBKXCjljHVtJHkTC\\nPf9HuFIFT7BG0vw+DijRO+q6v5oxixptsXOtyvbJAoGBAMnKS5Qq1IxdLWnqhRO5\\nBqs0A/TixDdIimChoWo7ZfaDllUjhJbBLh6HSc5dWgDUBLLiOSvONKwQDl5rAXz0\\na+v0A0zYcKCMNflDxQlWbTG4eNPzz2o1orLSuGPWm10RZ6IRCiOG7C3PuUsne6Fu\\nl/4Bstiz4Ba325YRs78mllje\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-qyfbu@bookie-c01fa.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"100814905289799309321\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-qyfbu%40bookie-c01fa.iam.gserviceaccount.com\"\n" +
                "}\n";

        InputStream serviceAccount =
                new ByteArrayInputStream(firebaseServiceAccount.getBytes(StandardCharsets.UTF_8));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bookie-c01fa.firebaseio.com")
                .build();

        try {
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return FirebaseApp.getInstance();
    }

}
