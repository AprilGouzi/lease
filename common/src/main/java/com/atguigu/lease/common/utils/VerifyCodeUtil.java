package com.atguigu.lease.common.utils;

import java.util.Random;

/**
 * @author 囍崽
 * version 1.0
 */
public class VerifyCodeUtil {

    public static String getVerifyCode(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
