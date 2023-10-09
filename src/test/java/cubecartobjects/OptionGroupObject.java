package cubecartobjects;

public class OptionGroupObject {

    private String groupName;
    private String groupType;
    private String description;

    public OptionGroupObject() {
    }

    public OptionGroupObject(String groupName, String groupType, String description) {
        this.groupName = groupName;
        this.groupType = groupType;
        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
