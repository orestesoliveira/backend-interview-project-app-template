package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class DeviceType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
