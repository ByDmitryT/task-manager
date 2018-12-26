package iteco.study.entity;

import java.util.UUID;

public class Project {

    private final UUID id = UUID.randomUUID();

    private final int orderId;

    private String name;

    public Project(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "orderId=" + orderId
                + ", name='" + name + "'";
    }
}
