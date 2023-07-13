package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class DeviceType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    public DeviceType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public DeviceType(){
        super();
    }

    public DeviceType(Integer id) {
        this.id = id;
    }

    private String description;


}
