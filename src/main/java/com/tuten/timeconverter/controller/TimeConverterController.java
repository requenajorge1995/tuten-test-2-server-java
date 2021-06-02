package com.tuten.timeconverter.controller;

import com.tuten.timeconverter.dto.ConvertedTimeDTO;
import com.tuten.timeconverter.dto.InputTimeDTO;
import com.tuten.timeconverter.service.TimeConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/")
@RestController
public class TimeConverterController {

    private final TimeConverterService timeConverter;

    @Autowired
    public TimeConverterController(TimeConverterService timeConverter){
        this.timeConverter = timeConverter;
    }

    @PostMapping
    public ResponseEntity<ConvertedTimeDTO> run(@RequestBody @Valid InputTimeDTO input){
       return new ResponseEntity<>(timeConverter.convert(input), HttpStatus.OK);
    }
}
