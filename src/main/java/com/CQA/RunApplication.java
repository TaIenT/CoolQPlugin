package com.CQA;

import com.forte.component.forcoolqhttpapi.CoolQHttpApplication;
import com.forte.qqrobot.SimpleRobotApplication;
import com.forte.qqrobot.log.QQLogBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@SimpleRobotApplication(resources = "/application.properties")
public class RunApplication{
    public static final Logger logger = LoggerFactory.getLogger(RunApplication.class);
    public static void main(String[] args){

        QQLogBack qqLogBack = (msg, level, e) -> {
            //控制台展示级别 + 信息
            switch(level){
                case INFO:
                    logger.info(msg);
                    break;
                case DEBUG:
                    logger.debug(msg);
                    break;
                case ERROR:
                    logger.error(msg);
                    break;
                case SUCCESS:
                    logger.trace(msg);
                    break;
                case WARNING:
                    logger.warn(msg);
                    break;
            }
            //返回false, 不输出日志
            return true;
        };

        CoolQHttpApplication application =new CoolQHttpApplication(qqLogBack);
        application.run(RunApplication.class);
    }

}
