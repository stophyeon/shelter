package com.example.shelter.route;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/path")
    @Operation(summary = "쉼터까지 최단 경로 찾기", description = "시작 위치부터 도착 위치까지의 최단거리 경로 탐색",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "startLat", description = "시작 위치 위도", required = true, example = "37.359708"),
                    @Parameter(in = ParameterIn.HEADER, name = "startLot", description = "시작 위치 경도", required = true, example = "127.1058342"),
                    @Parameter(in = ParameterIn.HEADER, name = "goalLat", description = "도착 위치 위도", required = true, example = "35.179470"),
                    @Parameter(in = ParameterIn.HEADER, name = "goalLot", description = "도착 위치 경도", required = true, example = "129.075986")
            })
    public DirectRes findShortestPath(@RequestParam(value = "startLat",required = true) String startLat,
                                      @RequestParam(value = "startLot",required = true)String startLot,
                                      @RequestParam(value = "goalLat",required = true)String goalLat,
                                      @RequestParam(value = "goalLot",required = true)String goalLot){
        return routeService.findPath(startLat,startLot,goalLat,goalLot);
    }

}
