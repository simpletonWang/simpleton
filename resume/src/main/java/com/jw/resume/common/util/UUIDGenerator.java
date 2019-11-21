package com.jw.resume.common.util;

import java.util.UUID;

/**
 * UUID
 */
public class UUIDGenerator {

    public static String generatorUUID() {
        String s = UUID.randomUUID().toString();
        // delete "-"
        return s.replace("-", "");
    }

}
