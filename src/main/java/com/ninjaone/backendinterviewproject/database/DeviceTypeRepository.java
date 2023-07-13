package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType,Integer> {
}
