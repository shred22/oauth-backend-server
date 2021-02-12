package com.oauth.resource.server.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OAuthLoginController {

  @PostMapping(value = "/login/callback",
      consumes = {"application/x-www-form-urlencoded"})
  ResponseEntity validateIdToken(
      @RequestParam(name = "id_token") String oidcToken,
      @RequestParam(name = "state") String state)   {

    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(UriComponentsBuilder
        .newInstance()
        .scheme("http")
        .host("localhost")
        .port("4200")
        .path("home")
        .build()
        .toUri()).build();
  }


}
