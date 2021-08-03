package kr.seok.item89;

import java.io.*;
import java.util.Arrays;

public class Util {
    public static byte[] serialize(Object o) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(ba).writeObject(o);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        System.out.println("ba = " + Arrays.toString(ba.toByteArray()));
        return ba.toByteArray();
    }

    public static Object deserialize(byte[] bytes) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
