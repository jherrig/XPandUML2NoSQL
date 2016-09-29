
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_Visit@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class Visit

implements

java.io.Serializable {

	private final static long serialVersionUID = 558736841L;

	private java.lang.String description = null;

	private java.util.Date visitDate = null;

	private de.ul.petclinic.Pet pet = null;

	private de.ul.petclinic.Vet vet = null;

	/*PROTECTED REGION ID(de_ul_petclinic_Visit@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

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

	/*PROTECTED REGION ID(de_ul_petclinic_Visit@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Visit@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Visit@associations: Add additional operations for associations here) ENABLED START*/
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
		if (!(obj instanceof Visit))
			return false;

		final Visit other = (Visit) obj;

		if (description != other.description)
			return false;

		if (visitDate != other.visitDate)
			return false;

		if (pet == null) {
			if (other.pet != null)
				return false;
		} else if (!pet.equals(other.pet))
			return false;

		if (vet == null) {
			if (other.vet != null)
				return false;
		} else if (!vet.equals(other.vet))
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
				* (result + ((description == null) ? 0 : description.hashCode()));

		result = PRIME * (result + visitDate);

		result = PRIME * (result + ((pet == null) ? 0 : pet.hashCode()));

		result = PRIME * (result + ((vet == null) ? 0 : vet.hashCode()));

		return result;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return super.toString()

		.concat("[description " + this.description + "]")

		.concat("[visitDate " + this.visitDate + "]")

		.concat("[pet " + this.pet.toString() + "]")

		.concat("[vet " + this.vet.toString() + "]")

		;
	}

}

/* End of File */

