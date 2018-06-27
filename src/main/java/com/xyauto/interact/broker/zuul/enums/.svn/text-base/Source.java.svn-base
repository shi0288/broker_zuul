package com.xyauto.interact.broker.zuul.enums;

import java.util.HashMap;
import java.util.Map;

public class Source {

    private static Map<String, SourceEntry> map = new HashMap<>();

    static {
        //appid, secret, id, name
        map.put("cbcec66ecce08de560d3623d5371ed01", SourceEntry.IOS);
        map.put("035a20e92066fd2017467f13c6382abc", SourceEntry.Android);
        map.put("dc33233c0beb4d03204fd37e077730fa", SourceEntry.PC);
        map.put("5d81db99484c0019cab240b3d04e9a4a", SourceEntry.M);
        map.put("dc30ad451b3fc622c2505e9a99ce4174", SourceEntry.H5);
        map.put("9493876a020e5523ce51d6cae6c684e4", SourceEntry.H51);
        //小程序
        map.put("37ce69f1183540f281c2d2d71d6ca391", SourceEntry.MP);
        //活动
        map.put("cb1e029d3cfebae72a88d2d52f85408c", SourceEntry.Activity);
        map.put("c4083f07745fb222273ed19e41c5a12e", SourceEntry.Admin);
        //慧商机ios
        map.put("bbd118bf9f8c4946740a2788add8e4cb", SourceEntry.IOS_Hsj);
        //慧商机android
        map.put("339a15652b291d8ab3746b2fb11fd953", SourceEntry.Android_Hsj);
        //第三方 惠商机
        map.put("d77dc4265009308c7d87386a13715315", SourceEntry.Third_Hsj);
        //第三方 百度知道
        map.put("04e4dfa41b12df196cff3f06a6995737", SourceEntry.Third_Baidu);
        //第三方 360
        map.put("6dbb1bd1b906b440711ce9cc6665a49b", SourceEntry.Third_360);
        //第三方 一点资讯
        map.put("cf18c6f78e9bc58b12e8cd640005987c", SourceEntry.Third_Ydzx);
        //第三方 平安好车主
        map.put("522ffabe63886cc62367dfc93606b157", SourceEntry.Third_PingAnCheZhu);
        //第三方 zaker
        map.put("11153ddc78b8d87bef771b8723034198", SourceEntry.Third_Zaker);
        //批量导入
        map.put("20a0c243fec17a69b9ca744556864184", SourceEntry.Batch);
        //赤兔
        map.put("8d82c130f9a4a46ef43dc7841810992e", SourceEntry.Rabbit);
    }

    public static SourceEntry get(String app_id) {
        if (map.containsKey(app_id)) {
            return map.get(app_id);
        }
        return null;
    }

    public static String getAppIdByEntry(SourceEntry entry) {
        if (map.containsValue(entry)) {
            for (Map.Entry<String, SourceEntry> item : map.entrySet()) {
                if (item.getValue().equals(entry)) {
                    return item.getKey();
                }
            }
        }
        return null;
    }

    public static enum SourceEntry {
        PC("dd07a1c5434b2d4ea46ce6daeecfaeee", 1),
        IOS("1d16d49d9adc806d101d096b31bb20da", 2),
        Android("551d9f1295c9d5ca9aee85558e717d25", 3),
        M("9d5f2e3ab579138f1f3f51663540a35c", 4),
        H5("dfb504179f145bde904f3aff58cbb8bd", 5),
        H51("d21dd0c3e168e3d0d683b56f17b50c00", 6),
        MP("2cfac9ecbc9801d608a8457b614152fe",7),
        Activity("41eaa1ca3235cc7a41609ed74120a0a2",8),
        IOS_Hsj("4be2fc2ed7a199cda9c16bb6725be698",9),
        Android_Hsj("244a9c51a95cc5495274fe9c63ba24a4",10),
        Third_Hsj("cced412aa982855e787cbef1c6d201c3", 101),
        Third_Baidu("2a6c7812bb901b25bca663187d8d0c33", 102),
        Third_360("cbfd83314709548db70b37e032907555", 103),
        Third_Ydzx("a54b22bc9a500ef11a24748820865712", 104),
        Third_Zaker("bd181a5f948155bf3d72f31136aa7e2b", 105),
        Third_PingAnCheZhu("b5fe9642a7042a3ece253b64765d20af", 106),
        Rabbit("15d8b852861a2fa49e46152dd6f6cbcb", 997),
        Admin("d27663ef0d8ce5494b151f55c96ce1c6", 998),
        Batch("13bc0231a9a66f10dd7d19eaf2e1e020", 999);

        private String secret;
        private Integer value;

        SourceEntry(String secret, Integer value) {
            this.secret = secret;
            this.value = value;
        }

        /**
         * @return the secret
         */
        public String getSecret() {
            return secret;
        }

        /**
         * @param secret the secret to set
         */
        public void setKey(String secret) {
            this.secret = secret;
        }

        /**
         * @return the value
         */
        public Integer getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(Integer value) {
            this.value = value;
        }
    }

}