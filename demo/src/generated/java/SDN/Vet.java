
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class Vet

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	@GraphId
	private Long id;

	//regular class properties as designed

	@Property
	private java.lang.String firstName = null;

	@Property
	private java.lang.String lastName = null;

	@Property
	private java.lang.String address = null;

	@Property
	private java.lang.String city = "null";

	@Property
	private java.lang.String telephone = null;

	@Property
	private java.lang.String homepage = null;

	@Property
	private java.lang.String email = null;

	@Property
	private java.util.Date birthday = null;

	@Property
	private java.util.Date employedSince = null;

	@Property
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
