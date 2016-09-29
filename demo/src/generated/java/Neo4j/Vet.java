
import org.neo4j.driver.v1.*;
public class Vet

extends de.ul.petclinic.AbstractPerson

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

	private java.util.Date employedSince = null;

	private de.ul.petclinic.Specialty specialty = null;

	//standard constructor setting the id using java random unique id function
	public Vet() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createVet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:Vet {id: \"" + id + "\", employedSince: "
				+ employedSince + ", specialty: " + specialty + "})");
		session.close();
		driver.close();
	}

	public StatementResult readVet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:Vet {id: \"" + id
				+ "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updateVet(){
		Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "USERNAME", "PWD" ) );
		Session session = driver.session();
 		session.run("MATCH (a:Vet {id:\"" +id+ "\"}) SET a.employedSince =" + employedSince + ");
 		session.run("MATCH (a:Vet {id:\"" +id+ "\"}) SET a.specialty =" + specialty + ");
		session.close();
		driver.close();
	}

	public void deleteVet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:Vet {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
	}

	//getter+setter

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

	public String getId() {
		return id;
	}
}
