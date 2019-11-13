package com.common.utils;

import java.util.UUID;

public class UUIDUtils {

    /**
     * @return 获取32位的UUID
     */
    public static String getUUID(){
        return  UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println( UUIDUtils.getUUID());
        }

    }

}

