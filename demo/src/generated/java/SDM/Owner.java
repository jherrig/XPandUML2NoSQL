
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
public class Owner

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	@Id
	public String id;
	//regular class properties as designed

	private java.lang.String firstName = null;

	private java.lang.String lastName = null;

	private java.lang.String address = null;

	private java.lang.String city = "null";

	private java.lang.String telephone = null;

	private java.lang.String homepage = null;

	private java.lang.String email = null;

	private java.util.Date birthday = null;

	@DBRef
	private java.util.Set<de.ul.petclinic.OwnerGroup> ownerGroup = new java.util.HashSet<de.ul.petclinic.OwnerGroup>();

	//standard constructor 
	public Owner() {
	}

	//getter+setter

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

}
