
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
public class Pet

implements

java.io.Serializable {
	@Id
	public String id;
	//regular class properties as designed

	private java.lang.Boolean sendReminders = false;

	private java.lang.String name = "null";

	private java.lang.Float weight = 0;

	private de.ul.petclinic.PetType type = null;

	@DBRef
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
