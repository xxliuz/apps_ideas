package com.zhou.binary2decimal.controller;

import com.zhou.binary2decimal.service.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 10:25
 * @Description: binary to decimal  or decimal to binary converter
 */
@Slf4j
@RestController
@RequestMapping("/v1")
public class ConverterController {

    @Autowired
    private Converter converter;

    @GetMapping(value = "/dec2bin")
    public String dec2bin(int decimal) {
        return converter.decimalToBinary(decimal);
    }

    @GetMapping(value = "/bin2dec")
    public int bin2dec(String binary) {
        return converter.binaryToDecimal(binary);
    }

}
