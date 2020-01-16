package models;

public class Resource {

    private ResourceType type;
    private Integer amount;

    public Resource(ResourceType resType, Integer resAmount) {
        type = resType;
        amount = resAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public ResourceType getType() {
        return type;
    }

    public void decrease(int a) {
        amount -= a;
    }

    public void increase(int a) {
        amount += a;
    }
}
