package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class ServiceDevice {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String serviceName;

    private BigDecimal value;



}
