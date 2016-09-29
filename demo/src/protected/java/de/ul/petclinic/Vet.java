
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_Vet@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class Vet

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {

	private final static long serialVersionUID = -281120706L;

	private java.util.Date employedSince = null;

	private de.ul.petclinic.Specialty specialty = null;

	/*PROTECTED REGION ID(de_ul_petclinic_Vet@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

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

	/*PROTECTED REGION ID(de_ul_petclinic_Vet@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Vet@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Vet@associations: Add additional operations for associations here) ENABLED START*/
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
		if (!(obj instanceof Vet))
			return false;

		final Vet other = (Vet) obj;

		if (employedSince != other.employedSince)
			return false;

		if (specialty == null) {
			if (other.specialty != null)
				return false;
		} else if (!specialty.equals(other.specialty))
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

		result = PRIME * (result + employedSince);

		result = PRIME
				* (result + ((specialty == null) ? 0 : specialty.hashCode()));

		return result;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return super.toString()

		.concat("[employedSince " + this.employedSince + "]")

		.concat("[specialty " + this.specialty.toString() + "]")

		;
	}

}

/* End of File */

