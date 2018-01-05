package domain;

public class Test {

    public static void main(String args[]){

        BusinessRule ar = new attributeRangeRule.Builder<>().setInsideRange(true).build();
        BusinessRule ac = new attributeCompareRule.Builder<>().setAffectedColumn("test").setConstraint(true).build();

        System.out.println(ar);

    }
}
