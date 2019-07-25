package hcmc.hcmc.services;

import hcmc.hcmc.models.Patient;

import java.util.List;

public interface IPatientQueryService {

    Patient findById(Long id);
    List<Patient> findAll();
    List<Patient> findOldPatients();
}
