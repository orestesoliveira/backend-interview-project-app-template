package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDeviceService {


    private final ServiceDeviceRepository serviceRepository;

    public ServiceDeviceService(ServiceDeviceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    public ServiceDevice saveServiceDeviceEntity(ServiceDevice service){
        return serviceRepository.save(service);
    }

    public Optional<ServiceDevice> getServiceDeviceEntity(Integer id){
        return serviceRepository.findById(id);
    }

    public void deleteServiceDeviceEntity(Integer id) {
        serviceRepository.deleteById(id);
    }


}
