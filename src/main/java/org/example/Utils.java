package org.example;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
    public static Date sqlDateFormat(String date) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate=dateFormat.parse(date);
        java.sql.Date  sqlDate= new Date(utilDate.getTime());

        return  sqlDate;
    }
}
