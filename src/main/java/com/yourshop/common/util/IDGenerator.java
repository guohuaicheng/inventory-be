package com.yourshop.common.util;

import java.util.UUID;

/**
 * @author G
 */
public class IDGenerator {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
