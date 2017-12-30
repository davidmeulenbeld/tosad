package domain;

public class attributeRangeRule<B extends attributeRangeRule.Builder<B>> extends BusinessRule<B> {

    private int rangeStart;
    private int rangeEnd;
    private boolean insideRange;

    public attributeRangeRule(Builder<B> builder) {
        super(builder);
        this.code = "ARNG";
        this.explanation = "the parameter value must be in or out the specified range";
        this.example = "all postal codes can participate, except 3700 up to 4100";
        this.rangeStart = builder.rangeStart;
        this.rangeEnd = builder.rangeEnd;
        this.insideRange = builder.insideRange;
    }

    public static class Builder<B extends attributeRangeRule.Builder<B>> extends BusinessRule.Builder<B> {

        private int rangeStart;
        private int rangeEnd;
        private boolean insideRange;

        public B setRangeStart(int rangeStart) {
            this.rangeStart = rangeStart;
            return (B) this;
        }

        public B setRangeEnd(int rangeEnd) {
            this.rangeEnd = rangeEnd;
            return (B) this;
        }

        public B setInsideRange(boolean insideRange) {
            this.insideRange = insideRange;
            return (B) this;
        }

        public attributeRangeRule<B> build() {
            return new attributeRangeRule<>(this);
        }

    }

    @Override
    public String toString() {
        return "attributeRangeRule{" + "\n" +
                "insideRange=" + insideRange + "\n" +
                ", rangeEnd=" + rangeEnd + "\n" +
                ", rangeStart=" + rangeStart + "\n"
                + super.toString();
    }
}

