
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_OwnerGroup@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class OwnerGroup

implements

java.io.Serializable {

	private final static long serialVersionUID = -514250182L;

	/*PROTECTED REGION ID(de_ul_petclinic_OwnerGroup@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_OwnerGroup@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_OwnerGroup@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_OwnerGroup@associations: Add additional operations for associations here) ENABLED START*/
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
		if (!(obj instanceof OwnerGroup))
			return false;

		final OwnerGroup other = (OwnerGroup) obj;

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
		return super.toString();
	}

}

/* End of File */

