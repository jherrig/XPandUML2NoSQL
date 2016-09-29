
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_Owner@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class Owner

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {

	private final static long serialVersionUID = 1941547461L;

	public java.util.Set<de.ul.petclinic.OwnerGroup> ownerGroup = new java.util.HashSet<de.ul.petclinic.OwnerGroup>();

	/*PROTECTED REGION ID(de_ul_petclinic_Owner@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/**
	 * 
	 * @return The ownerGroup as <code>de.ul.petclinic.OwnerGroup</code>
	 */

	public java.util.Set<de.ul.petclinic.OwnerGroup> getOwnerGroup() {
		return ownerGroup;
	}

	/**
	 * 
	 * @param ownerGroup The ownerGroup to set
	 */

	public void setOwnerGroup(
			java.util.Set<de.ul.petclinic.OwnerGroup> ownerGroup) {
		this.ownerGroup = ownerGroup;
	}

	/*PROTECTED REGION ID(de_ul_petclinic_Owner@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Owner@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_Owner@associations: Add additional operations for associations here) ENABLED START*/
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
		if (!(obj instanceof Owner))
			return false;

		final Owner other = (Owner) obj;

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

		return result;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return super.toString()

		.concat("[ownerGroup " + this.ownerGroup.toString() + "]")

		;
	}

}

/* End of File */

