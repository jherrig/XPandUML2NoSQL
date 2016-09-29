
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_Pet@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class Pet

implements

java.io.Serializable {

	private final static long serialVersionUID = -438926668L;

	private java.lang.Boolean sendReminders = false;

	private java.lang.String name = "null";

	private java.lang.Float weight = 0;

	private de.ul.petclinic.Owner owner = null;

	private de.ul.petclinic.PetType type = null;

	/*PROTECTED REGION ID(de_ul_petclinic_Pet@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

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

	/*PROTECTED REGION ID(de_ul_petclinic_Pet@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Pet@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Pet@associations: Add additional operations for associations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!(obj instanceof Pet))
			return false;

		final Pet other = (Pet) obj;

		if (sendReminders != other.sendReminders)
			return false;

		if (name != other.name)
			return false;

		if (weight != other.weight)
			return false;

		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;

		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;

		return true;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public int hashCode() {
		final int PRIME = 7;
		int result = 1;
		long temp;

		result = PRIME
				* (result + ((sendReminders == null) ? 0 : sendReminders
						.hashCode()));

		result = PRIME * (result + ((name == null) ? 0 : name.hashCode()));

		result = PRIME * (result + weight);

		result = PRIME * (result + ((owner == null) ? 0 : owner.hashCode()));

		result = PRIME * (result + ((type == null) ? 0 : type.hashCode()));

		return result;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return super.toString()

		.concat("[sendReminders " + this.sendReminders + "]")

		.concat("[name " + this.name + "]")

		.concat("[weight " + this.weight + "]")

		.concat("[owner " + this.owner.toString() + "]")

		.concat("[type " + this.type.toString() + "]")

		;
	}

}

/* End of File */

