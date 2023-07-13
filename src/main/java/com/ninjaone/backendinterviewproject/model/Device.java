package com.ninjaone.backendinterviewproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;


    private String systemName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_TYPE_ID")
    private DeviceType deviceType;

    @OneToMany(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
    @ElementCollection(targetClass= ServiceDevice.class)
    @Column(name = "SERVICE_ID")
    private Set<ServiceDevice> services;

    public Device(Integer id) {
        this.id = id;
    }
    public Device() {

    }

}
