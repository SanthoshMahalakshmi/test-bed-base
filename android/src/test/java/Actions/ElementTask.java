package Actions;

public class ElementTask {
    private Activity activity;
    private String description;
    private String inputValue;

    // Private constructor to ensure only Builder can instantiate
    private ElementTask(Builder builder) {
        this.activity = builder.activity;
        this.description = builder.description;
        this.inputValue = builder.inputValue;
    }

    // Getters for accessing private fields
    public Activity getActivity() {
        return activity;
    }

    public String getDescription() {
        return description;
    }

    public String getInputValue() {
        return inputValue;
    }

    // Builder class to help construct ElementTask objects
    public static class Builder {
        private final Activity activity;
        private final String description;
        private String inputValue;

        // Constructor for Builder class with mandatory fields
        public Builder(Activity activity, String description) {
            this.activity = activity;
            this.description = description;
        }

        // Optional setter for inputValue
        public Builder inputValue(String inputValue) {
            this.inputValue = inputValue;
            return this;
        }

        // Method to build and return the ElementTask object
        public ElementTask build() {
            return new ElementTask(this);
        }
    }
}
