package com.dingteam.demo.MyOptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class test2 {

    public static void main(String[] args) {
        String str =" <xml>\n" +
                " <ToUserName><![CDATA[wwe666e9b61d4bd539]]></ToUserName>\n" +
                " <FromUserName><![CDATA[sys]]></FromUserName>\n" +
                " <CreateTime>1629793242</CreateTime>\n" +
                " <MsgType><![CDATA[event]]></MsgType>\n" +
                " <Event><![CDATA[change_contact]]></Event>\n" +
                " <ChangeType><![CDATA[delete_party]]></ChangeType>\n" +
                " <Id>6</Id>\n" +
                " </xml>";

        String str2 =" <xml>\n" +
                " <ToUserName><![CDATA[wwe666e9b61d4bd539]]></ToUserName>\n" +
                " <FromUserName><![CDATA[sys]]></FromUserName>\n" +
                " <CreateTime>1629793242</CreateTime>\n" +
                " <MsgType><![CDATA[event]]></MsgType>\n" +
                " <Event><![CDATA[change_contact]]></Event>\n" +
                " <ChangeType><![CDATA[delete_party]]></ChangeType>\n" +
                " <Id>7</Id>\n" +
                " </xml>";

        XMLToWxDept userTest = (XMLToWxDept) XMLUtil.convertXmlStrToObject(XMLToWxDept.class, str);
        XMLToWxDept userTest2 = (XMLToWxDept) XMLUtil.convertXmlStrToObject(XMLToWxDept.class, str2);

        List<XMLToWxDept > list = new ArrayList<>();
        list.add(userTest);
        list.add(userTest2);

        List<XMLToWxDept> collect = list.stream().distinct().collect(Collectors.toList());

        return;

    }

}
