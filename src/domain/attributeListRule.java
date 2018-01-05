package domain;

import java.util.ArrayList;
import java.util.List;

public class attributeListRule <B extends attributeListRule.Builder<B>> extends BusinessRule<B>{
    private List list ;
    private boolean inList;

    public attributeListRule(Builder<B> builder){
        super(builder);
        this.code="ALIS";
        this.explanation="the parameter value must be equal or unequal to a value of the given list";
        this.example="status of delivery needs to be one of these: 'registered','accepted','sent','delivered'";
        this.list =builder.list;
        this.inList=builder.inList;
    }

    public List getList() {
        return list;
    }

    public boolean isInList() {
        return inList;
    }

    public static class Builder<B extends attributeListRule.Builder<B>> extends BusinessRule.Builder<B> {

        private List list;
        private boolean inList;

        public B setList(List list) {
            this.list = list;
            return (B)this;
        }

        public B setInList(boolean value) {
            this.inList = inList;
            return (B) this;
        }

        public attributeListRule<B> build() {
            return new attributeListRule<>(this);
        }

    }
}
