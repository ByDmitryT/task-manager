package ru.titov.taskmanagerserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Getter
    @Setter
    protected String id = UUID.randomUUID().toString();

}
