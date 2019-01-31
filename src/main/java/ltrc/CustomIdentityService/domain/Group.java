package ltrc.CustomIdentityService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ashlah on 28/07/17.
 */
@Entity
@Table(name = "CmnGroup", schema="dbo")
@Setter @Getter
public class Group implements org.camunda.bpm.engine.identity.Group {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @Column(columnDefinition = "char(36)")
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "GroupID")
    private String id;

    @Column(name = "GroupEnglishName")
    private String name;

    @Column(name = "type")
    private String type = "WORKFLOW";

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}
}
