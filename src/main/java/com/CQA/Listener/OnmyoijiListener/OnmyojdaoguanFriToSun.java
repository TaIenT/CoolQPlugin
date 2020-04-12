package com.CQA.Listener.OnmyoijiListener;


import com.CQA.Utils.GetTime;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.utils.CQCodeUtil;

@Beans
@CronTask(value = "0 28 19 ? * FRI-SUN")
public class OnmyojdaoguanFriToSun implements TimeJob {

    @Override
    public void execute(MsgSender msgSender, CQCodeUtil cqCodeUtil) {
        QQLog.info("每周五到周日道馆提醒");
        OnmyojSenderList.SenderList(msgSender,"还有两分钟就要7点半咯\n道馆快开始了\n大家别忘啦");
        String week = GetTime.week();
        if (week=="Saturday"){
            OnmyojSenderList.SenderList(msgSender,"今天是星期六\n别忘了 打完道馆以后别忘了宴会哟\n吃饭不积极,脑子有问题(笑");
        }
        QQLog.info("每周五到周日道馆提醒完成");
    }
}
