package hcmc.hcmc.controllers;

import hcmc.hcmc.models.Patient;
import hcmc.hcmc.services.IPatientQueryService;
import hcmc.hcmc.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * The type Patient controller.
 * @author nduwayofabrice
 * @version 1.0
 */
@Controller
public class PatientController {

    private static final String INDEX = "index";
    private static final String PATIENT = "patient";
    private static final String PATIENTS = "patients";
    private static final String ELDERLY_PATIENTS = "oldPatients";
    private static final String PATIENTS_PAGE = "redirect:/patients";

    private IPatientService patientService;
    private IPatientQueryService patientQueryService;

    /**
     * Instantiates a new Patient controller.
     *
     * @param patientService      the patient service
     * @param patientQueryService the patient query service
     */
    @Autowired
    public PatientController(IPatientService patientService, IPatientQueryService patientQueryService){
        this.patientService = patientService;
        this.patientQueryService = patientQueryService;
    }


    /**
     * Home string.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String home(){
        return  INDEX;
    }

    /**
     * Get patients string.
     *
     * @param model the model
     *
     * @return the string
     */
    @RequestMapping(path = PATIENTS)
    public String getPatients(Model model){
        List<Patient> patientList = patientQueryService.findAll();
        model.addAttribute(PATIENTS, patientList);
        return PATIENTS;
    }

    /**
     * Get elderly patients string.
     *
     * @param model the model
     *
     * @return the string
     */
    @RequestMapping(path = ELDERLY_PATIENTS)
    public String getElderlyPatients(Model model){
        List<Patient> patients = patientQueryService.findOldPatients();
        model.addAttribute(ELDERLY_PATIENTS, patients);
        return ELDERLY_PATIENTS;
    }

    /**
     * Patient string.
     *
     * @param model the model
     *
     * @return the string
     */
    @RequestMapping(path = "/new/"+PATIENT)
    public String patient(Model model){
        model.addAttribute(PATIENT, new Patient());
        return PATIENT;
    }

    /**
     * Save patient string.
     *
     * @param patient the patient
     * @param errors  the errors
     * @param model   the model
     *
     * @return the string
     */
    @PostMapping(path = "/save/"+PATIENT)
    public String savePatient(@ModelAttribute Patient patient, BindingResult errors, Model model){
        if (!errors.hasErrors()) {
            patientService.createPatient(patient);
            model.addAttribute(PATIENTS, patientQueryService.findAll());
        }
        return PATIENTS_PAGE;
    }

    /**
     * Delete patient string.
     *
     * @param model the model
     * @param id    the id
     *
     * @return the string
     */
    @RequestMapping(path = "/delete/{id}")
    public String deletePatient(Model model, @PathVariable("id") Long id){
        Patient patient = patientQueryService.findById(id);
        if(patient == null){
            return PATIENTS_PAGE;
        }else{
            patientService.deletePatient(id);
            model.addAttribute(PATIENTS, patientQueryService.findAll());
            return PATIENTS_PAGE;
        }
    }


}
