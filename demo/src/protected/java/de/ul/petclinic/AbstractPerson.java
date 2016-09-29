
/* Universität Leipzig */

package de.ul.petclinic;

/*PROTECTED REGION ID(de_ul_petclinic_AbstractPerson@imports: Imports) ENABLED START*/
/*PROTECTED REGION END*/

/**
 * 
 */

public class AbstractPerson

implements

java.io.Serializable {

	private final static long serialVersionUID = -2020257770L;

	private java.lang.String firstName = null;

	private java.lang.String lastName = null;

	private java.lang.String address = null;

	private java.lang.String city = "null";

	private java.lang.String telephone = null;

	private java.lang.String homepage = null;

	private java.lang.String email = null;

	private java.util.Date birthday = null;

	/*PROTECTED REGION ID(de_ul_petclinic_AbstractPerson@attributes: Place additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/**
	 * 
	 * @return The firstName as <code>java.lang.String</code>
	 */

	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName The firstName to set
	 */

	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return The lastName as <code>java.lang.String</code>
	 */

	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName The lastName to set
	 */

	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return The address as <code>java.lang.String</code>
	 */

	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address The address to set
	 */

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The city as <code>java.lang.String</code>
	 */

	public java.lang.String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city The city to set
	 */

	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The telephone as <code>java.lang.String</code>
	 */

	public java.lang.String getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @param telephone The telephone to set
	 */

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 
	 * @return The homepage as <code>java.lang.String</code>
	 */

	public java.lang.String getHomepage() {
		return homepage;
	}

	/**
	 * 
	 * @param homepage The homepage to set
	 */

	public void setHomepage(java.lang.String homepage) {
		this.homepage = homepage;
	}

	/**
	 * 
	 * @return The email as <code>java.lang.String</code>
	 */

	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email The email to set
	 */

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return The birthday as <code>java.util.Date</code>
	 */

	public java.util.Date getBirthday() {
		return birthday;
	}

	/**
	 * 
	 * @param birthday The birthday to set
	 */

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	/*PROTECTED REGION ID(de_ul_petclinic_AbstractPerson@getterSetter: Place Getter and Setter for the additional attributes here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_AbstractPerson@operations: Add addtional operations here) ENABLED START*/
	/*PROTECTED REGION END*/

	/*PROTECTED REGION ID(de_ul_petclinic_AbstractPerson@associations: Add additional operations for associations here) ENABLED START*/
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
		if (!(obj instanceof AbstractPerson))
			return false;

		final AbstractPerson other = (AbstractPerson) obj;

		if (firstName != other.firstName)
			return false;

		if (lastName != other.lastName)
			return false;

		if (address != other.address)
			return false;

		if (city != other.city)
			return false;

		if (telephone != other.telephone)
			return false;

		if (homepage != other.homepage)
			return false;

		if (email != other.email)
			return false;

		if (birthday != other.birthday)
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
				* (result + ((firstName == null) ? 0 : firstName.hashCode()));

		result = PRIME
				* (result + ((lastName == null) ? 0 : lastName.hashCode()));

		result = PRIME
				* (result + ((address == null) ? 0 : address.hashCode()));

		result = PRIME * (result + ((city == null) ? 0 : city.hashCode()));

		result = PRIME
				* (result + ((telephone == null) ? 0 : telephone.hashCode()));

		result = PRIME
				* (result + ((homepage == null) ? 0 : homepage.hashCode()));

		result = PRIME * (result + ((email == null) ? 0 : email.hashCode()));

		result = PRIME * (result + birthday);

		return result;
	}

	/* (non-Javadoc) 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public String toString() {
		return super.toString()

		.concat("[firstName " + this.firstName + "]")

		.concat("[lastName " + this.lastName + "]")

		.concat("[address " + this.address + "]")

		.concat("[city " + this.city + "]")

		.concat("[telephone " + this.telephone + "]")

		.concat("[homepage " + this.homepage + "]")

		.concat("[email " + this.email + "]")

		.concat("[birthday " + this.birthday + "]")

		;
	}

}

/* End of File */

