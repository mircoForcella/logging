package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicController {

    @Autowired
    BasicService basicService;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String getWelcome(){
        logger.info("call getWelcome");
        return "Welcome here";
    }

    @GetMapping("exp")
    public int retExponent(){
        return basicService.calculateExponent();
    }

    @GetMapping("/get-errors")
    public ResponseEntity<String> throwError() {
        logger.error("Custom error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred!");
    }
}