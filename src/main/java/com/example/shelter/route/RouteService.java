package com.example.shelter.route;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class RouteService {

    @Value("${naver.route.key_id}")
    private String keyId;
    @Value("${naver.route.key}")
    private String key;
    @Value("${naver.route.url}")
    private String url;

    public DirectRes findPath(String startLat,String startLot,String goalLat, String goalLot){
        StringBuilder urlBuilder = new StringBuilder(url);
        urlBuilder.append("start=").append(startLot).append(",").append(startLat);
        urlBuilder.append("&goal=").append(goalLot).append(",").append(goalLat);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", keyId);
        headers.set("X-NCP-APIGW-API-KEY", key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DirectRes> response = restTemplate.exchange(
                URI.create(urlBuilder.toString()),
                HttpMethod.GET,
                entity,
                DirectRes.class
        );


        return response.getBody();
    }
}
