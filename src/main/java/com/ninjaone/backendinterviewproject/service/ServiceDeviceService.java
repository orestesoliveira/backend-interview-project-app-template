package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.DeviceTypeRepository;
import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDeviceService {

    private final DeviceRepository deviceRepository;

    private final DeviceTypeRepository deviceTypeRepository;
    private final ServiceDeviceRepository serviceRepository;

    public ServiceDeviceService(DeviceRepository deviceRepository, DeviceTypeRepository deviceTypeRepository, ServiceDeviceRepository serviceRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
        this.serviceRepository = serviceRepository;
    }


    public Device saveDeviceEntity(Device device){
        return deviceRepository.save(device);
    }
    public Optional<Device> getDeviceEntity(Integer id){
        return deviceRepository.findById(id);
    }
    public void deleteDeviceEntity(Integer id) {
        deviceRepository.deleteById(id);
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

    public List<DeviceType> findAllDeviceTypes(){ return deviceTypeRepository.findAll();}

    public Optional<DeviceType> getDeviceTypeEntity(Integer id) {
        return deviceTypeRepository.findById(id);
    }
}
