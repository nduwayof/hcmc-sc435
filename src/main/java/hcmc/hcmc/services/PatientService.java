package hcmc.hcmc.services;

import hcmc.hcmc.models.Patient;
import hcmc.hcmc.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@Primary
public class PatientService implements  IPatientService{

    private IPatientRepository patientRepository;

    @Autowired
    private PatientService(IPatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public int calculateAge(LocalDate localDate) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(localDate, today);
        return period.getYears();
    }

    @Override
    public void deletePatient(Long id) {
        this.patientRepository.deleteById(id);
    }
}
