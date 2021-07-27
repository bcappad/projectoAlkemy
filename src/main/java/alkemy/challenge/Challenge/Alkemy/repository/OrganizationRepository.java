package alkemy.challenge.Challenge.Alkemy.repository;



import alkemy.challenge.Challenge.Alkemy.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Long, Organization> {
 }
