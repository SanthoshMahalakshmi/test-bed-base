package Actions;

public class ElementTask {
    private final Activity activity;
    private final String description;
    private final String inputValue;

    private ElementTask(Builder builder) {
        this.activity = builder.activity;
        this.description = builder.description;
        this.inputValue = builder.inputValue;
    }

    public Activity getActivity() {
        return activity;
    }

    public String getDescription() {
        return description;
    }

    public String getInputValue() {
        return inputValue;
    }

    public static class Builder {
        private final Activity activity;
        private final String description;
        private String inputValue;

        public Builder(Activity activity, String description) {
            this.activity = activity;
            this.description = description;
        }

        public Builder inputValue(String inputValue) {
            this.inputValue = inputValue;
            return this;
        }

        public ElementTask build() {
            return new ElementTask(this);
        }
    }
}
