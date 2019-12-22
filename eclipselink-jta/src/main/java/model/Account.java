package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
@SequenceGenerator(name = "ACCOUNT_SEQ",allocationSize = 2,sequenceName = "ACCOUNT_SEQ")
@NamedQueries({
@NamedQuery(name=Account.findByEmail,query = "select a from Account a where a.email = :pemail ")
})
public class Account extends ModelBase<String>{

	public static final String findByEmail = "Account.findByEmail";
	public static final String paramEmail = "pemail";
		
	@Column(name="accname",length = 20)
	private String accName;

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Id
	@Column(name="email",length = 50,nullable = false)
	private String email;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="PERSON_ID", referencedColumnName="ID")
	private Person person;
	
	@Override
	public String getId() {
		return this.email;
	}

}
