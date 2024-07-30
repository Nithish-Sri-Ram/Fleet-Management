package com.example.fleetmanagement.service;

import com.example.fleetmanagement.model.Driver;
import com.example.fleetmanagement.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public void delete(Long id) {
        driverRepository.deleteById(id);
    }
}