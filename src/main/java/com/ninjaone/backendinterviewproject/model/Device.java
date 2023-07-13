package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @Column(unique=true)
    private String systemName;

    @ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_TYPE_ID")
    private DeviceType deviceType;

    @OneToMany(cascade= CascadeType.MERGE, fetch = FetchType.LAZY)
    @ElementCollection(targetClass= ServiceDevice.class)
    @Column(name = "SERVICE_ID")
    private Set<ServiceDevice> services;

    public Device(Integer id) {
        this.id = id;
    }
    public Device() {

    }

}
