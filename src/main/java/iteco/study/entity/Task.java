package iteco.study.entity;

import java.util.UUID;

public class Task {

    private final UUID id = UUID.randomUUID();

    private final int orderId;

    private int projectOrderId = -1;

    private String name;

    private String description;

    public Task(int orderId, String name, String description) {
        this.orderId = orderId;
        this.name = name;
        this.description = description;
    }

    public Task(int orderId, int projectOrderId, String name, String description) {
        this.orderId = orderId;
        this.projectOrderId = projectOrderId;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProjectOrderId() {
        return projectOrderId;
    }

    public void setProjectOrderId(int projectOrderId) {
        this.projectOrderId = projectOrderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "orderId=" + orderId
                + " projectOrderId=" + projectOrderId
                + ", name='" + name + "'"
                + ", description='" + description + "'";
    }
}
