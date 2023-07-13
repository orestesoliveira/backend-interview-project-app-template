package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.DeviceTypeRepository;
import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    private final DeviceTypeRepository deviceTypeRepository;

    private final ServiceDeviceRepository serviceRepository;

    public DeviceService(DeviceRepository deviceRepository, DeviceTypeRepository deviceTypeRepository, ServiceDeviceRepository serviceRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
        this.serviceRepository = serviceRepository;
    }


    public Device saveDeviceEntity(Device device){
        return deviceRepository.save(device);
    }

    public Device updateDeviceEntity(Device device){

        device.getServices().stream().map(servicePayload -> serviceRepository.findById(servicePayload.getId()).orElse(null));

        return deviceRepository.save(device);
    }
    public Optional<Device> getDeviceEntity(Integer id){
        return deviceRepository.findById(id);
    }
    public void deleteDeviceEntity(Integer id) {
        deviceRepository.deleteById(id);
    }

    public List<DeviceType> findAllDeviceTypes(){ return deviceTypeRepository.findAll();}

    public Optional<DeviceType> getDeviceTypeEntity(Integer id) {
        return deviceTypeRepository.findById(id);
    }

    public BigDecimal calculateDeviceCost(Integer id) {

        Device deviceToCalculate = deviceRepository.findById(id).orElse(null);


        BigDecimal total = deviceToCalculate.getServices()
                .stream()
                .map(ServiceDevice::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total;
    }
}
