package hcmc.hcmc.services;

import hcmc.hcmc.models.Patient;

import java.time.LocalDate;

public interface IPatientService {

    Patient createPatient(Patient patient);
    int calculateAge(LocalDate localDate);
    void deletePatient(Long id);
}
