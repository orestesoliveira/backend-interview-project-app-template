package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Optional;

@CacheConfig(cacheNames = "services")
@Service
public class ServiceDeviceService {


    private final ServiceDeviceRepository serviceRepository;

    public ServiceDeviceService(ServiceDeviceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Caching(evict = {@CacheEvict(value = "allservicecache", allEntries = true),
            @CacheEvict(value = "servicecache", key = "#service.id")
    })
    public ServiceDevice saveServiceDeviceEntity(ServiceDevice service){
        return serviceRepository.save(service);
    }

    @Cacheable(value = "allservicecache")
    public Optional<ServiceDevice> getServiceDeviceEntity(Integer id){
        System.out.println("database retrieve");
        return serviceRepository.findById(id);
    }


    public void deleteServiceDeviceEntity(Integer id) {
        serviceRepository.deleteById(id);
    }


}
