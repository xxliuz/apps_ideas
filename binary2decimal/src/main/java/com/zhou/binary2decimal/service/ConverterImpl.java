package com.zhou.binary2decimal.service;

import org.springframework.stereotype.Service;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 10:40
 * @Description:
 */
@Service
public class ConverterImpl implements Converter {

    @Override
    public String decimalToBinary(int decimal) {
        int rem;
        StringBuilder fumbler = new StringBuilder();
        while (decimal > 0) {
            rem = decimal % 2;
            decimal = decimal / 2;
            fumbler.append(rem);
        }
        return fumbler.reverse().toString();
    }

    @Override
    public int binaryToDecimal(String binary) {
        StringBuilder bin = new StringBuilder(binary);
        bin = bin.reverse();
        int fumbler = 0;
        for (int i = 0; i < bin.length(); i++) {
            fumbler += Integer.parseInt(String.valueOf(bin.charAt(i))) * Math.pow(2, i);
        }
        return fumbler;
    }
}
