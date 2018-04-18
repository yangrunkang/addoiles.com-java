package com.addoiles.common.enums;

import com.addoiles.mail.dto.Receiver;
import com.addoiles.util.PropertyUtils;

public class OilConstant {
    //每页数
    public final static int ROWS = 20;

    /**
     * 用户已经注册
     */
    public final static Integer HAS_REGISTERED = 1001;

    /**
     * 内容过长
     */
    public final static Integer CONTENT_TOO_LONG = 1002;

    /**
     * 获取邮件业务邮件通知接受者
     * @return
     */
    public static Receiver getHostReceiver(){
        Receiver receiver = new Receiver();
        receiver.setEmailAddress(PropertyUtils.getValue("business.receiver.email"));
        receiver.setName("master");
        return receiver;
    }
}
