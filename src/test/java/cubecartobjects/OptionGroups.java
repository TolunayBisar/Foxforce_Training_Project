package cubecartobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import cubecartobjects.OptionGroupObject;

import java.util.List;

public class OptionGroups {
    @JsonProperty("OptionGroups")
    private List<OptionGroupObject> optionGroups;

    public OptionGroups() {
    }

    public OptionGroups(List<OptionGroupObject> optionGroups) {
        this.optionGroups = optionGroups;
    }

    public List<OptionGroupObject> getOptionGroups() {
        return optionGroups;
    }

    public void setOptionGroups(List<OptionGroupObject> optionGroups) {
        this.optionGroups = optionGroups;
    }
}

