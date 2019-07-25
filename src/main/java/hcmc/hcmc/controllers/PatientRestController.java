package hcmc.hcmc.controllers;

import hcmc.hcmc.models.Patient;
import hcmc.hcmc.services.IPatientQueryService;
import hcmc.hcmc.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    private IPatientQueryService patientQueryService;

    /**
     * Instantiates a new Patient controller.
     *
     * @param patientService      the patient service
     * @param patientQueryService the patient query service
     */
    @Autowired
    public PatientRestController(IPatientQueryService patientQueryService){
        this.patientQueryService = patientQueryService;
    }

    @GetMapping(path = "/hcmc/api/patients")
    public List<Patient> patients(){
        return patientQueryService.findAll();
    }

    @GetMapping(path = "/hcmc/api/old-patients")
    public List<Patient> oldPatients(){
        return patientQueryService.findOldPatients();
    }

}
