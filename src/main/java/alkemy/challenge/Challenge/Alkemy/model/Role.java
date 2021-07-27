package alkemy.challenge.Challenge.Alkemy.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "roles")
public class Role implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotNull
   private String name;
   private String description;

   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime date;
}
