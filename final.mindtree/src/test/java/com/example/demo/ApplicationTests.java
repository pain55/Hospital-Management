package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.controller.DoctorController;
import com.example.demo.controller.PatientController;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTests 
{

    @Autowired
    PatientController patientController;

    @Autowired
     DoctorController doctorController;


    @Test
    public void test(){
        assertTrue(true);
    }
    @Test
    public void  showPatientInformationTest(){
        Patient patient =patientController.showPatientInformation(11);
        assertEquals(patient.getName(),"Kiran");
    }

    @Test
    public void showDoctorInformationTest(){
        Doctor doc = doctorController.getDoctorInfo("DR. Sai"); 
        assertEquals(doc.getField(),"MBBS");
        // logger.info(doc.toString());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void saveDoctorInformation(){
        Doctor doc = new Doctor("Sai", 12, "male", "ent");
        boolean res=doctorController.addUser(doc);
        assertTrue(res);
    }

    @Test
    @DirtiesContext
    @Transactional
    public void savePatientInformation(){
        Patient patient = new Patient(1001, "kiran", 30, "DR. Sai",LocalDate.now(), "male", "xyz");
        boolean res = patientController.createPatient(patient);
        assertTrue(res);
    }
}
