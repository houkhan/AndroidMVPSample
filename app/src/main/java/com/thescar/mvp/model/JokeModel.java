package com.thescar.mvp.model;

import java.util.List;

/**
 * @Author :TheScar
 * @Date :2019/12/11 10:02
 * @Email :han_shuaishuai@126.com\
 * @Description :
 */
public class JokeModel {

    /**
     * reason : success
     * result : [{"content":"我的同事，08年冬天，开车回家，路遇MM，顺风搭车，聊的甚欢，途中，美眉尿急，停车方便，便蹲车后，天寒地冻，挨车太近，美臀便被冻在后保险杠上，MM无奈且不好意思出声，同事半天不见回来，便下车察看，见状心中一惊，便想办法施救，生拉硬拽，美眉连连喊痛！同事无奈的使出一招，顺着MM股沟撒了一泡尿，解救成功。后来的后来，她成了他的老婆，此乃孽缘或奇缘否？","hashId":"CE401A3A53DBB7290EFBFD9A54D2E731","unixtime":1423531924},{"content":"昨晚去相亲，室友给我出了个主意，买根大香肠绑在大腿根，再穿条稍微紧身点的裤子，女方见了肯定满意！果不其然，那女的总是若有若无的往我下面瞟，她已经同意吃了宵夜就去开房。结果吃宵夜面条的时候她嫌碗里肉太少，就说\u201c要是有根香肠就好了\u201d，这时我一时激动就\u2026\u2026","hashId":"6559CA910A2FAD588DA9E9431067528B","unixtime":1423531933},{"content":"\u200d\u200d新买了一张床，很宽。 老公：\u201c这床真宽啊！可以睡三个人。\u201d 媳妇早就想要孩子了，便说：\u201c只要你愿意，我没问题。\u201d 老公激动不已，说：\u201c好啊！只要你不吃醋，我是更没问题的。\u201d\u200d\u200d","hashId":"15CFCA77E1B15830CBA25FC34CF2443D","unixtime":1423531953},{"content":"女: 成功的男人背後一定有个女人\r\n男: 失败的男人背後呢 !? \r\n女: 一定是有太多的女人","hashId":"d0e646d150cf1eb7f337c48bea81a0ce","unixtime":1423532030},{"content":"女: 男人结婚需要什麽!?\r\n男: 勇气\r\n男: 女人结婚需要什麽!?\r\n女: 运气","hashId":"06cdc090fc33c8caf0a6f2d3b027c3c6","unixtime":1423532030},{"content":"甲女: 我上次暗示男朋友说, 女人喜欢能长久保存东西,\r\n结果第二天我就得到一枚钻戒, 你也可以对男朋友如法炮制呀!!\r\n乙女: \r\n这方法我甲用过了, 结果第二天我收到一包防腐剂.","hashId":"599706fdd3ee1d9eea02018bd8f0879e","unixtime":1423532030},{"content":"男: 交往这麽久了,咱们...同居吧!!\r\n女: 我爸妈不会原谅我的\r\n男: 如果我们结婚呢!?\r\n女: 我不会原谅我的","hashId":"008643ee8cff3d95f5880d5f3d9ea333","unixtime":1423532030},{"content":"当丈夫去上班的时候，四岁的儿子向妈妈告状：「妈，你不在家的时候，\r\n爸爸把女佣带到楼上去，然後......」他妈妈阻止他再说下去：\r\n「其他的等你老爸回来的时候再说吧。」\r\n晚上爸爸回来，一家一起共进晚餐，妈妈对儿子说：\r\n「好了，孩子，你可以继续讲你的故事了。」\r\n「嗯，上个礼拜你不在家的时候，爸爸带着我们家的女佣 \r\n到楼上的房间去，\r\n然後.....」\r\n妈妈：「然後呢？」\r\n儿子：「然後就像隔壁王伯伯来我们家时对你一样.....」","hashId":"c3b65b6fc6a24234365996be3b2733ae","unixtime":1423532030},{"content":"某男甲对某男乙：唔...你很象梅兰芳。\r\n某男乙：嘻嘻嘻嘻....你真是讨厌死了，人家哪一点儿象嘛！","hashId":"a74c9b67ff705959c95d0afe343978e3","unixtime":1423532030},{"content":"甲：＂告诉你一个好消息，经过一段时间的刻苦学习，我的一篇习作终于被一家晚报采用?\r\n乙：\u201c哦！恭喜恭喜！能否告诉我，是什么文章？\u201d\r\n甲：\u201c一则遗失声明。\u201d","hashId":"092b361b0e4069fa3ecbc87da018a96d","unixtime":1423532030}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 我的同事，08年冬天，开车回家，路遇MM，顺风搭车，聊的甚欢，途中，美眉尿急，停车方便，便蹲车后，天寒地冻，挨车太近，美臀便被冻在后保险杠上，MM无奈且不好意思出声，同事半天不见回来，便下车察看，见状心中一惊，便想办法施救，生拉硬拽，美眉连连喊痛！同事无奈的使出一招，顺着MM股沟撒了一泡尿，解救成功。后来的后来，她成了他的老婆，此乃孽缘或奇缘否？
         * hashId : CE401A3A53DBB7290EFBFD9A54D2E731
         * unixtime : 1423531924
         */

        private String content;
        private String hashId;
        private int unixtime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public int getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(int unixtime) {
            this.unixtime = unixtime;
        }
    }
}
