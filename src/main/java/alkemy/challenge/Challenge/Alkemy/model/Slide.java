package alkemy.challenge.Challenge.Alkemy.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Slide implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String text;
    private int order;

    @ManyToOne
    @JoinColumn(name = "id")
    // Should verify if the column name matches with the database
    private Organization organization;
}
