package org.example.springsecurity11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountController {

    @GetMapping("/myAccount")

    public String getAccountDetails() {

        return "Here are the accountdetails from db";

    }

}