package com.example.shelter.route;

import lombok.Data;

import java.util.List;

@Data
public class DirectRes {
    private int code;
    private String message;
    private String currentDateTime;
    private Route route;
}
@Data
class Route {
    private List<TraoptimalRoute> traoptimal;
}

@Data
class TraoptimalRoute {
    private List<GuideItem> guide;

    private List<List<Double>> path;
}

@Data
class GuideItem {
    private int distance;
    private int duration;
    private String instructions;
    private int pointIndex;
    private int type;
}