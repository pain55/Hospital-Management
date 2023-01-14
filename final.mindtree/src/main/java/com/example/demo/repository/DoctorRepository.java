package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Doctor;

@Repository
@CrossOrigin(origins = "http://localhost:4200")

public interface DoctorRepository  extends CrudRepository<Doctor,Integer> {
    public Doctor findByName(String name);
}