
import org.neo4j.driver.v1.*;
public class AbstractPerson

implements

java.io.Serializable {
	//id String to identify Unique Neo4j Nodes
	private final String id;

	//regular class properties as designed

	private java.lang.String firstName = null;

	private java.lang.String lastName = null;

	private java.lang.String address = null;

	private java.lang.String city = "null";

	private java.lang.String telephone = null;

	private java.lang.String homepage = null;

	private java.lang.String email = null;

	private java.util.Date birthday = null;

	//standard constructor setting the id using java random unique id function
	public AbstractPerson() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createAbstractPerson() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:AbstractPerson {id: \"" + id
				+ "\", firstName: \"" + firstName + "\", lastName: \""
				+ lastName + "\", address: \"" + address + "\", city: \""
				+ city + "\", telephone: \"" + telephone + "\", homepage: \""
				+ homepage + "\", email: \"" + email + "\", birthday: "
				+ birthday + "})");
		session.close();
		driver.close();
	}

	public StatementResult readAbstractPerson() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:AbstractPerson {id: \""
				+ id + "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updateAbstractPerson(){
		Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "USERNAME", "PWD" ) );
		Session session = driver.session();
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.firstName =\"" + firstName + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.lastName =\"" + lastName + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.address =\"" + address + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.city =\"" + city + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.telephone =\"" + telephone + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.homepage =\"" + homepage + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.email =\"" + email + "\");
 		session.run("MATCH (a:AbstractPerson {id:\"" +id+ "\"}) SET a.birthday =" + birthday + ");
		session.close();
		driver.close();
	}

	public void deleteAbstractPerson() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:AbstractPerson {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
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

	public String getId() {
		return id;
	}
}
