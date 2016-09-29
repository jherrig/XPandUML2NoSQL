
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class Visit

implements

java.io.Serializable {
	@GraphId
	private Long id;

	//regular class properties as designed

	@Property
	private java.lang.String description = null;

	@Property
	private java.util.Date visitDate = null;

	//standard constructor 
	public Visit() {
	}

	//getter+setter

	/**
	 * 
	 * @return The description as <code>java.lang.String</code>
	 */

	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description The description to set
	 */

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The visitDate as <code>java.util.Date</code>
	 */

	public java.util.Date getVisitDate() {
		return visitDate;
	}

	/**
	 * 
	 * @param visitDate The visitDate to set
	 */

	public void setVisitDate(java.util.Date visitDate) {
		this.visitDate = visitDate;
	}

	/**
	 * 
	 * @return The pet as <code>de.ul.petclinic.Pet</code>
	 */

	public de.ul.petclinic.Pet getPet() {
		return pet;
	}

	/**
	 * 
	 * @param pet The pet to set
	 */

	public void setPet(de.ul.petclinic.Pet pet) {
		this.pet = pet;
	}

	/**
	 * 
	 * @return The vet as <code>de.ul.petclinic.Vet</code>
	 */

	public de.ul.petclinic.Vet getVet() {
		return vet;
	}

	/**
	 * 
	 * @param vet The vet to set
	 */

	public void setVet(de.ul.petclinic.Vet vet) {
		this.vet = vet;
	}

}
