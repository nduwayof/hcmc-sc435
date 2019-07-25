package hcmc.hcmc.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "patient_number", nullable = false, unique = true, length = 50)
    private String patientNumber;

    @Column(name = "an_out_patient")
    private boolean anOutPatient = false;

    @NotNull
    @Column(name = "full_names", nullable = false, length = 80)
    private String fullNames;

    @NotNull
    @Column(name = "email", nullable = false, unique = true, length = 80)
    private String email;

    @NotNull
    @Column(name = "contact_phone_number", nullable = false, unique = true, length = 80)
    private String contactPhoneNumber;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Transient
    private List<EBoolean> helpers;

    public void setHelper(List<EBoolean> helpers) {
        this.helpers = Arrays.asList(EBoolean.values());
    }
}
