package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.BackendInterviewProjectApplication;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


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
/*
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
    */
}