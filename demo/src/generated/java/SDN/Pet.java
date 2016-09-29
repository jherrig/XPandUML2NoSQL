
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class Pet

implements

java.io.Serializable {
	@GraphId
	private Long id;

	//regular class properties as designed

	@Property
	private java.lang.Boolean sendReminders = false;

	@Property
	private java.lang.String name = "null";

	@Property
	private java.lang.Float weight = 0;

	@Property
	private de.ul.petclinic.PetType type = null;

	@Relationship(type = "pet_owner_1")
	private de.ul.petclinic.Owner owner = null;

	//standard constructor 
	public Pet() {
	}

	//getter+setter

	/**
	 * 
	 * @return The sendReminders as <code>java.lang.Boolean</code>
	 */

	public java.lang.Boolean getSendReminders() {
		return sendReminders;
	}

	/**
	 * 
	 * @param sendReminders The sendReminders to set
	 */

	public void setSendReminders(java.lang.Boolean sendReminders) {
		this.sendReminders = sendReminders;
	}

	/**
	 * 
	 * @return The name as <code>java.lang.String</code>
	 */

	public java.lang.String getName() {
		return name;
	}

	/**
	 * 
	 * @param name The name to set
	 */

	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The weight as <code>java.lang.Float</code>
	 */

	public java.lang.Float getWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight The weight to set
	 */

	public void setWeight(java.lang.Float weight) {
		this.weight = weight;
	}

	/**
	 * 
	 * @return The owner as <code>de.ul.petclinic.Owner</code>
	 */

	public de.ul.petclinic.Owner getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner The owner to set
	 */

	public void setOwner(de.ul.petclinic.Owner owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * @return The type as <code>de.ul.petclinic.PetType</code>
	 */

	public de.ul.petclinic.PetType getType() {
		return type;
	}

	/**
	 * 
	 * @param type The type to set
	 */

	public void setType(de.ul.petclinic.PetType type) {
		this.type = type;
	}

}
