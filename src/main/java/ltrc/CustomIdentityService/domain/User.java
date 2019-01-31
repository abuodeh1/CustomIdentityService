package ltrc.CustomIdentityService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ashlah on 28/07/17.
 */
@Entity
@Table(name="CmnUser", schema="dbo")
@Setter @Getter
public class User implements org.camunda.bpm.engine.identity.User {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UserName")
//    @Column(columnDefinition = "char(36)")
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

	@Column(name = "UserFullName", insertable=false, updatable=false)
	private String firstName;
	@Column(name = "UserFullName")
    private String lastName;

    @Column(name = "UserEmailAddress")
    private String email;
    @Column(name = "UserPassword")
    private String password;

	/*
	 * @ManyToOne private Group group;
	 */

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Group getGroup() { return group; }
	 * 
	 * public void setGroup(Group group) { this.group = group; }
	 */
}
