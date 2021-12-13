package com.reactcwqr.codewars.controller;

import com.google.gson.*;
import com.reactcwqr.codewars.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {
    public DefaultController() throws Exception {
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping(value = "/default", consumes = "application/json")

    @ResponseBody
    public String defaultAction(HttpEntity<String> json) throws Exception {
        Gson gson = new Gson();
        TypeWrapper typeWrapper = gson.fromJson(json.getBody(), TypeWrapper.class);
        DefaultService instance = (DefaultService) gson.fromJson(json.getBody(), Class.forName(typeWrapper.getType()));

        return instance.solve();
    }

}
