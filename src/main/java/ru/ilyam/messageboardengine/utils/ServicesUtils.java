package ru.ilyam.messageboardengine.utils;

import java.util.Objects;

public final  class ServicesUtils {

    private ServicesUtils (){}

    public static boolean ifFieldUpdate(String value) {
        if (Objects.nonNull(value) && !"".equalsIgnoreCase(value)) {
            return true;
        }
        return false;
    }
}
