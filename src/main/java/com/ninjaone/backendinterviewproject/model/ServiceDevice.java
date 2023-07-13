package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class ServiceDevice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique=true)
    private String serviceName;

    private BigDecimal value;

    public ServiceDevice(Integer id, String serviceName, BigDecimal value) {
        this.id = id;
        this.serviceName = serviceName;
        this.value = value;
    }

    public ServiceDevice(){
        super();
    }
}
