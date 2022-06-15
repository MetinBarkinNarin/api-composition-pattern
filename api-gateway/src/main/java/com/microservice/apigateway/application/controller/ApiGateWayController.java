package com.microservice.apigateway.application.controller;

import com.microservice.apigateway.application.service.ApiGateWayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ApiGateWayController {

    private final ApiGateWayService apiGateWayService;




}
