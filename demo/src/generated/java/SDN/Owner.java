
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class Owner

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	@GraphId
	private Long id;

	//regular class properties as designed

	@Property
	private java.lang.String firstName = null;

	@Property
	private java.lang.String lastName = null;

	@Property
	private java.lang.String address = null;

	@Property
	private java.lang.String city = "null";

	@Property
	private java.lang.String telephone = null;

	@Property
	private java.lang.String homepage = null;

	@Property
	private java.lang.String email = null;

	@Property
	private java.util.Date birthday = null;

	@Relationship(type = "ownergroup_membership")
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
