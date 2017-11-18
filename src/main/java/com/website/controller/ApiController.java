package com.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by letrain on 2017/11/18.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private String url = "http://c.apiplus.net/newly.do?token=t6ef89568868527f9k&format=json";

}
