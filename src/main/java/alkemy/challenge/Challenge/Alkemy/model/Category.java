package alkemy.challenge.Challenge.Alkemy.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.security.Timestamp;

import lombok.*;

@Entity
@Table(name="categories")
@Getter @Setter @NoArgsConstructor
@SQLDelete(sql = "UPDATE table_product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

}
