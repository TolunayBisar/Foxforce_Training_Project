package com.foxforce.study.cubecartobjects;

/**
 * @author : tolunaybisar
 * @created : 16.10.2023,19:43
 * @Email :tolunay.bisar@gmail.com
 **/
public class SetObject {
    private String setName;
    private String setDesc;


    public SetObject() {
    }

    public SetObject(String setName, String setDesc) {
        this.setName = setName;
        this.setDesc = setDesc;
    }

    public String getSetName() {
        return setName;
    }

    public String getSetDesc() {
        return setDesc;
    }
}
