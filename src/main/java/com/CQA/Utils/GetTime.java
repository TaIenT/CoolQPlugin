package com.CQA.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {



    //获取当前时间
    public static String week(){
        Date date= new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("EEEE");
        return dateFormat.format(date);
    }
}
