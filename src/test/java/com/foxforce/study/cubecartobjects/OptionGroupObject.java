package com.foxforce.study.cubecartobjects;

public class OptionGroupObject {

    private String groupName;

    private String description;

    public OptionGroupObject() {
    }

    public OptionGroupObject(String groupName,  String description) {
        this.groupName = groupName;

        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
