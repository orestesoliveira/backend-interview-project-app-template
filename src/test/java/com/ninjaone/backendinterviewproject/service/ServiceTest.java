package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;

@EnableCaching
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    private ServiceDeviceService testService;

    @Mock
    private ServiceDeviceRepository serviceRepository;

    @Test
    void testServiceCacheShouldAccessDatabaseOnce(){

        testService.saveServiceDeviceEntity(new ServiceDevice(20,"name service 20", BigDecimal.valueOf(10)));

        testService.getServiceDeviceEntity(20);
        testService.getServiceDeviceEntity(20);
        testService.getServiceDeviceEntity(20);
        testService.getServiceDeviceEntity(20);

        Mockito.verify(serviceRepository, times(1)).findById(20);

    }
}
