package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {
    public static final Integer ID = 15;

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private ServiceDeviceService testObject;

    private Device deviceEntity;

    @BeforeEach
    void setup(){
        deviceEntity = new Device(ID);
        deviceEntity.setSystemName( "Device "+ID);
        deviceEntity.setDeviceType(new DeviceType(1));
    }

    @Test
    void getDeviceData() {
        /*
        when(sampleRepository.findById(ID)).thenReturn(Optional.of(sampleEntity));
        Optional<Sample> sampleEntityOptional = testObject.getSampleEntity(ID);
        Sample actualEntity = sampleEntityOptional.orElse(null);
        assert actualEntity != null;
        assertEquals(sampleEntity.getValue(), actualEntity.getValue());
        */

    }

    @Test
    void saveDeviceData() {
        when(deviceRepository.save(deviceEntity)).thenReturn(deviceEntity);
        assertEquals(deviceEntity, testObject.saveDeviceEntity(deviceEntity));
    }

    @Test
    void deleteSampleData(){
       /*
        doNothing().when(sampleRepository).deleteById(ID);
        testObject.deleteSampleEntity(ID);
        Mockito.verify(sampleRepository, times(1)).deleteById(ID);

        */
    }
}
