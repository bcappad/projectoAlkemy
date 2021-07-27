package alkemy.challenge.Challenge.Alkemy.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user")
public class UserModel {

    @Id @Column (name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "1")
    private int userid;

    @Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "password", nullable = false)
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
    
}
