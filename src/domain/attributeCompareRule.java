package domain;

public class attributeCompareRule  extends BusinessRule {
    private String operator;
    private int value;



    public String getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public static abstract class Builder <T extends attributeCompareRule> extends BusinessRule.Builder {

        private String operator;
        private int value;

        public Builder<T> setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder<T> setValue(int value) {
            this.value = value;
            return this;
        }
    }

    public static Builder<?> builder() {
        return new Builder<attributeCompareRule>() {
            @Override
            public attributeCompareRule build() {
                return new attributeCompareRule(this);
            }
        };
    }
        protected attributeCompareRule(Builder<?> builder){
            super(builder);
            this.operator = builder.operator;
            this.value = builder.value;

    }



    @Override
    public String toString() {
        return "attributeCompareRule{" + "\n" +
                "operator='" + operator + '\'' + "\n" +
                ", value=" + value + "\n" +
                 super.toString();
    }
}