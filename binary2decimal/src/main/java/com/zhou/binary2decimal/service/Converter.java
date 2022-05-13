package com.zhou.binary2decimal.service;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 10:40
 * @Description:
 */
public interface Converter {

    /**
     * decimal to binary
     *
     * @param decimal 十进制
     * @return binary 二进制
     */
    String decimalToBinary(int decimal);

    /**
     * binary to decimal
     *
     * @param binary 二进制
     * @return decimal 十进制
     */
    int binaryToDecimal(String binary);
}
