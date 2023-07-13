package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {
    public static final Integer ID = 1;

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService testService;

    private Device deviceEntity;

    @BeforeEach
    void setup(){
        deviceEntity = new Device(ID);
        deviceEntity.setSystemName( "Device "+ID);
        deviceEntity.setDeviceType(new DeviceType(1));
    }

    @Test
    public void testCalculateDeviceCost() {

        Device device = new Device();
        device.setId(1);
        device.setServices(createTestServices());

        when(deviceRepository.findById(1)).thenReturn(java.util.Optional.of(device));

        BigDecimal result = testService.calculateDeviceCost(1);

        assertEquals(new BigDecimal("1200.00"), result);
    }

    // Helper method create a set of services
    private Set<ServiceDevice> createTestServices() {
        Set<ServiceDevice> services = new HashSet<>();
        services.add(new ServiceDevice(1, "Service 1", new BigDecimal("500.00")));
        services.add(new ServiceDevice(2, "Service 2", new BigDecimal("700.00")));
        return services;
    }

    @Test
    void getDeviceData() {

        when(deviceRepository.findById(ID)).thenReturn(Optional.of(deviceEntity));
        Optional<Device> deviceEntityOptional = testService.getDeviceEntity(ID);
        Device actualEntity = deviceEntityOptional
                .orElse(null);
        assert actualEntity != null;
        assertEquals(deviceEntity.getSystemName(), actualEntity.getSystemName());


    }

    @Test
    void saveDeviceData() {
        when(deviceRepository.save(deviceEntity)).thenReturn(deviceEntity);
        assertEquals(deviceEntity, testService.saveDeviceEntity(deviceEntity));
    }

    @Test
    void deleteSampleData(){

        doNothing().when(deviceRepository).deleteById(ID);
        testService.deleteDeviceEntity(ID);
        Mockito.verify(deviceRepository, times(1)).deleteById(ID);


    }
}
