package domain;

public class attributeCompareRule <B extends attributeCompareRule.Builder<B>> extends BusinessRule<B> {
    private String operator;
    private int value;

    public attributeCompareRule(Builder<B> builder){
        super(builder);
        this.code="ACMP";
        this.explanation="the parameter value must be equal, unequal, bigger, smaller, equal or bigger, equal or smaller than the given value";
        this.example="amount needs to be equal or bigger than 1";
        this.operator=builder.operator;
        this.value=builder.value;
        }

    public String getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    public static class Builder<B extends attributeCompareRule.Builder<B>> extends BusinessRule.Builder<B> {

    private String operator;
    private int value;

    public B setOperator(String operator) {
        this.operator = operator;
        return (B)this;
    }

    public B setValue(int value) {
        this.value = value;
        return (B) this;
    }

    public attributeCompareRule<B> build() {
        return new attributeCompareRule<>(this);
    }

}

    @Override
    public String toString() {
        return "attributeCompareRule{" + "\n" +
                "operator='" + operator + '\'' + "\n" +
                ", value=" + value + "\n" +
                 super.toString();
    }
}