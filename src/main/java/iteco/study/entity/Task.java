package iteco.study.entity;

import java.util.UUID;

public class Task {

    private final UUID id = UUID.randomUUID();

    private final int orderId;

    private UUID projectId = null;

    private String name;

    private String description;

    public Task(int orderId, String name, String description) {
        this.orderId = orderId;
        this.name = name;
        this.description = description;
    }

    public Task(int orderId, UUID projectId, String name, String description) {
        this.orderId = orderId;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
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

}
