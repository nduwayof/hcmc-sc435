package hcmc.hcmc.repository;

import hcmc.hcmc.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
