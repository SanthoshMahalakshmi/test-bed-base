package Actions;

public class iOSElementTask {

    private final iOSActionType actionType;
    private final String description;
    private final String inputValue;

    private iOSElementTask(Builder builder) {
        this.actionType = builder.actionType;
        this.description = builder.description;
        this.inputValue = builder.inputValue;
    }

    public iOSActionType getActionType() {
        return actionType;
    }

    public String getDescription() {
        return description;
    }

    public String getInputValue() {
        return inputValue;
    }

    public static class Builder {
        private final iOSActionType actionType;
        private final String description;
        private String inputValue;

        public Builder(iOSActionType actionType, String description) {
            this.actionType = actionType;
            this.description = description;
        }

        public Builder inputValue(String inputValue) {
            this.inputValue = inputValue;
            return this;
        }

        public iOSElementTask build() {
            return new iOSElementTask(this);
        }
    }
}
