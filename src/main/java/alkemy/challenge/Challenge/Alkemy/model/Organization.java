package alkemy.challenge.Challenge.Alkemy.model;
import org.springframework.boot.SpringApplication;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Data @AllArgsConstructor @NoArgsConstructor

@Entity @Table(name = "organizations")
@SQLDelete(sql = "UPDATE testimonials SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Organization 
{

    @Id
    private Integer id;    
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)    
    private String image;
    private String address;
    @Column (nullable = false)
    private int phone;
    @Column (nullable = false)    
    private String email;
    @Column (nullable = false)    
    private String welcomeText;
    private String aboutUsText;
    
    
    private Boolean deleted = false;
    @Column (nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date update;
}