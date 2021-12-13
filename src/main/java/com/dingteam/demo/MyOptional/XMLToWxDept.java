package com.dingteam.demo.MyOptional;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.lang.ref.PhantomReference;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "xml")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Id","Name","ParentId","ChangeType"
})
@Data
public class XMLToWxDept {

    private  String Id;

    private  String Name;

    private  String ParentId;

    private  String ChangeType;

    @Override
    public  int hashCode(){

        return Id.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        XMLToWxDept userDo = (XMLToWxDept)obj;
        return this.Id.equals(userDo.Id) ;
    }

}
