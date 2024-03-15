package com.fiap.hackathon.global.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public abstract class Utils {

    public static UUID convertBytesToUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();

        return new UUID(high, low);
    }
}
