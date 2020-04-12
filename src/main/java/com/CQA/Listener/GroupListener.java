package com.CQA.Listener;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.anno.depend.Beans;
import com.forte.qqrobot.beans.cqcode.CQCode;
import com.forte.qqrobot.beans.messages.msgget.GroupMsg;
import com.forte.qqrobot.beans.messages.types.MsgGetTypes;
import com.forte.qqrobot.log.QQLog;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;





//群消息
@Beans
public class GroupListener {

    public static final CQCodeUtil util=CQCodeUtil.build();

    @Listen(MsgGetTypes.groupMsg)
    @Filter(value = ".签到")
    public void signListen(GroupMsg msg, MsgSender sender) {

//        final CQCode atAll = util.getCQCode_AtAll();
        final CQCode atQQ = util.getCQCode_At(msg.getQQ());
//
//        String groupMsg= atAll.append(msg.getMsg()).toString();

        sender.SENDER.sendGroupMsg(msg,atQQ+"签到成功");
        // System.out.println(atAll.append(msg.getMsg()).toString());
        QQLog.info(msg.getQQ()+" 签到成功");
    }

    @Listen(MsgGetTypes.groupMsg)
    @Filter(value = ".help")
    public void helpListen(GroupMsg msg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(msg,"命令大全\n.sign\t\t\t每日签到\n.建议 \"内容\"\t 可以对小机器人提建议哦\n.寮活动 \t\t 会显示寮活动的具体时间\n@我可以与我聊天哦\n每日`道馆` `鬼王` `逢魔` `阴界`自动提醒\n后续功能还在制作中~~~");
    }

    @Listen(MsgGetTypes.groupMsg)
    @Filter(value = ".建议.*")
    public void suggestListen(GroupMsg msg, MsgSender sender) {
        String suggest= msg.getMsg().substring(3);
        QQLog.info("发送建议"+suggest);
        sender.SENDER.sendPrivateMsg("1054001563","收到建议:\n" + suggest +"\n\n群号:\t\t"+msg.getGroup()+"\n发送人:\t   " + msg.getQQ());
        sender.SENDER.sendGroupMsg(msg,"好的~~ 你的建议主人收到了哟");
        QQLog.info("建议发送完成");
    }

    /*@Listen(MsgGetTypes.groupMsg)
    public void repeatListen(GroupMsg msg, MsgSender sender) {
        try{
            URL url =new URL("http://api.live.bilibili.com/bili/living_v2/21414030");
            System.out.println(url.getQuery());
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    @Listen(MsgGetTypes.groupMsg)
    @Filter(value = ".寮活动")
    public void timeListener(GroupMsg msg, MsgSender sender){
        String time = "每日\t17:00~22:00逢魔之时\n周一\t19:00鬼王来袭+道馆\n周二\t19:00鬼王来袭+道馆\n周三\t19:00鬼王来袭+道馆+宴会\n周四\t19:00鬼王来袭+道馆\n周五\t19:00~21:00阴界之门\t19:30道馆\n周六\t19:00~21:00阴界之门\t19:30道馆+宴会\n周日\t19:00~21:00阴界之门\t19:30道馆";
        sender.SENDER.sendGroupMsg(msg,time);
    }

}
