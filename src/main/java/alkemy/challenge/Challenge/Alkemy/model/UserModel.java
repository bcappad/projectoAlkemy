package alkemy.challenge.Challenge.Alkemy.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user")
public class UserModel {

    @Id @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "1")
    private Long userid;

    @Column (name = "first_name", nullable = false)
    @Setter @Getter
    private String firstName;

    @Column (name = "last_name", nullable = false)
    @Setter @Getter
    private String lastName;

    @Column (name = "email", nullable = false, unique = true)
    @Setter @Getter
    private String email;

    @Column (name = "password", nullable = false)
    @Setter @Getter
    private String password;

    @Column (name = "photo")
    private String photo;

    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;  // Role class must be created or refactor name

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "creation_date")
    private Date creationDate;

    @Column (name = "is_deleted", columnDefinition = "default 'false'")
    private Boolean isDeleted;

    public UserModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
