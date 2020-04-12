package com.CQA.Bean;


import com.forte.qqrobot.anno.depend.Beans;

@Beans
public class Groupable {

    //开关状态 默认为开
    private boolean enable = true;

    public void open(){
        enable = true;
    }

    public void close(){
        enable = false;
    }

    public boolean isEnable() {
        return enable;
    }
}
