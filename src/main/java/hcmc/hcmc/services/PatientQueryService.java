package hcmc.hcmc.services;

import hcmc.hcmc.models.Patient;
import hcmc.hcmc.models.PatientNameComparator;
import hcmc.hcmc.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class PatientQueryService implements  IPatientQueryService{

    private IPatientService patientService;
    private IPatientRepository patientRepository;

    @Autowired
    private PatientQueryService(IPatientService patientService, IPatientRepository patientRepository){
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.getOne(id);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = this.patientRepository.findAll();
        patients.sort(new PatientNameComparator());
        return patients;
    }

    @Override
    public List<Patient> findOldPatients() {
        return this.patientRepository.findAll().stream()
                .filter(p -> patientService.calculateAge(p.getDateOfBirth()) >= 65)
                .sorted(Comparator.comparing(Patient::getFullNames))
                .collect(Collectors.toList());
    }
}
