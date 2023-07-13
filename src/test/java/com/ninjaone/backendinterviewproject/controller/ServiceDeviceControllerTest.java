package com.ninjaone.backendinterviewproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.backendinterviewproject.BackendInterviewProjectApplication;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BackendInterviewProjectApplication.class})
@WebMvcTest(ServiceDeviceController.class)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
class ServiceDeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceDeviceService serviceDeviceService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private Authentication authentication;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void postServiceDeviceEntityTest() throws Exception {
        ServiceDevice serviceDevice = new ServiceDevice();
        serviceDevice.setId(10);
        serviceDevice.setServiceName("Service test 1");
        serviceDevice.setValue(BigDecimal.valueOf(30));



        String username = "admin";
        String role = "ADMIN";
        authentication = new TestingAuthenticationToken(username, null,
                Collections.singletonList(new SimpleGrantedAuthority(role)));
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);



        when(serviceDeviceService.saveServiceDeviceEntity(any(ServiceDevice.class))).thenReturn(serviceDevice);

        mockMvc.perform(post("/service")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(serviceDevice)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.serviceName").value(serviceDevice.getServiceName()));
        // Add additional assertions as needed
    }

    @Test
    public void getServiceDeviceEntityTest() throws Exception {
        Integer id = 900;
        ServiceDevice serviceDevice = new ServiceDevice();

        when(serviceDeviceService.getServiceDeviceEntity(eq(id))).thenReturn(Optional.of(serviceDevice));

        mockMvc.perform(get("/service/900", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.serviceName").value(serviceDevice.getServiceName()));

    }

    @Test
    public void deleteServiceDeviceEntityTest() throws Exception {
        Integer id = 1;
        doNothing().when(serviceDeviceService).deleteServiceDeviceEntity(eq(id));

        mockMvc.perform(delete("/service/{id}", id))
                .andExpect(status().isNoContent());
    }

    private String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON string", e);
        }
    }
}