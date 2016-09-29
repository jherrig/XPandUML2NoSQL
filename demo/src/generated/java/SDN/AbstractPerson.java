
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class AbstractPerson

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

	//standard constructor 
	public AbstractPerson() {
	}

	//getter+setter

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

}
