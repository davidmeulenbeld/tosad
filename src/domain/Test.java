package domain;

public class Test {

    public static void main(String args[]){

        attributeRangeRule ar = new attributeRangeRule.Builder<>().setCode("DEW").setInsideRange(true).build();

        System.out.println(ar);

    }
}
