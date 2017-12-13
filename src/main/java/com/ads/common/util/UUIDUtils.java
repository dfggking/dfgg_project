package com.ads.common.util;

import java.util.UUID;
/**
 * UUID生成
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtils.getUUID());
    }
}
