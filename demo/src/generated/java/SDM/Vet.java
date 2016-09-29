
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
public class Vet

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	@Id
	public String id;
	//regular class properties as designed

	private java.lang.String firstName = null;

	private java.lang.String lastName = null;

	private java.lang.String address = null;

	private java.lang.String city = "null";

	private java.lang.String telephone = null;

	private java.lang.String homepage = null;

	private java.lang.String email = null;

	private java.util.Date birthday = null;

	private java.util.Date employedSince = null;

	private de.ul.petclinic.Specialty specialty = null;

	//standard constructor 
	public Vet() {
	}

	//getter+setter

	/**
	 * 
	 * @return The employedSince as <code>java.util.Date</code>
	 */

	public java.util.Date getEmployedSince() {
		return employedSince;
	}

	/**
	 * 
	 * @param employedSince The employedSince to set
	 */

	public void setEmployedSince(java.util.Date employedSince) {
		this.employedSince = employedSince;
	}

	/**
	 * 
	 * @return The specialty as <code>de.ul.petclinic.Specialty</code>
	 */

	public de.ul.petclinic.Specialty getSpecialty() {
		return specialty;
	}

	/**
	 * 
	 * @param specialty The specialty to set
	 */

	public void setSpecialty(de.ul.petclinic.Specialty specialty) {
		this.specialty = specialty;
	}

}
