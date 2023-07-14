package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceDeviceRepository;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@EnableCaching
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceDeviceServiceTest {

    @Mock
    private ServiceDeviceRepository mockServiceRepository;

    private ServiceDeviceService serviceDeviceService;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        serviceDeviceService = new ServiceDeviceService(mockServiceRepository);
    }

    @Test
    public void testGetServiceDeviceEntity_CacheHit() {
        ServiceDevice serviceDevice = new ServiceDevice();
        serviceDevice.setId(1);
        serviceDevice.setServiceName("Test Service");

        when(mockServiceRepository.findById(1)).thenReturn(Optional.of(serviceDevice));

        Optional<ServiceDevice> cachedServiceDevice = serviceDeviceService.getServiceDeviceEntity(1);
        Optional<ServiceDevice> cachedServiceDeviceAgain = serviceDeviceService.getServiceDeviceEntity(1);

        verify(mockServiceRepository, times(1)).findById(1);



        assertEquals(serviceDevice.getId(), cachedServiceDevice.get().getId());
        assertEquals(serviceDevice.getServiceName(), cachedServiceDevice.get().getServiceName());

        assertSame(cachedServiceDevice.get(), cachedServiceDeviceAgain.get()); // ensure same object is returned from cache
    }

}
