package cubecartobjects;

public class CustomerGroupObject {
    private String groupName; private String groupDescription;

    public CustomerGroupObject() {
    }

    public CustomerGroupObject(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }
}
