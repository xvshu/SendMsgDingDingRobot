package com.xvshu.dingding.dingdingmsg;

import java.util.List;

/**
 * Created by xvshu on 2018/4/11.
 */
public class DingMsgEntity {
    public String msgtype="text";
    public text text = new text();
    public at at = new at();

    public class text{
        public String content;
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


    }

    public class at{
        public List<String> atMobiles;
        public boolean isAtAll=false;

        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }

        public boolean isAtAll() {
            return isAtAll;
        }

        public void setAtAll(boolean atAll) {
            isAtAll = atAll;
        }


    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public DingMsgEntity.text getText() {
        return text;
    }

    public void setText(DingMsgEntity.text text) {
        this.text = text;
    }

    public at getAt() {
        return at;
    }

    public void setAt(at at) {
        this.at = at;
    }

}
