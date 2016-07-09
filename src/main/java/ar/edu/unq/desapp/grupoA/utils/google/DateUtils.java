package ar.edu.unq.desapp.grupoA.utils.google;

import java.sql.Date;

public class DateUtils {
    public static Date parse(String dateString) {
        return Date.valueOf(dateString);
    }
}
