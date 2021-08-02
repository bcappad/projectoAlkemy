package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.SQLDelete;

import lombok.Data;

@Entity
@SQLDelete(sql = "UPDATE activity SET deleted=true WHERE id = ?")
@Table(name = "activities")
@Data
public class ActivityModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String content;
	
	@NotEmpty
	private String image;
	
	private Boolean deleted;
	
    @Temporal(TemporalType.DATE)
   private Timestamp fecha;

	//Constructors
	
	public ActivityModel() {
		super();
	}

	public ActivityModel(@NotEmpty String name, @NotEmpty String content, @NotEmpty String image) {
		super();
		this.name = name;
		this.content = content;
		this.image = image;
	}
}
