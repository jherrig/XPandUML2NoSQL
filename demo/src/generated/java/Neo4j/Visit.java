
import org.neo4j.driver.v1.*;
public class Visit

implements

java.io.Serializable {
	//id String to identify Unique Neo4j Nodes
	private final String id;

	//regular class properties as designed

	private java.lang.String description = null;

	private java.util.Date visitDate = null;

	private de.ul.petclinic.Pet pet = null;

	private de.ul.petclinic.Vet vet = null;

	//standard constructor setting the id using java random unique id function
	public Visit() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createVisit() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:Visit {id: \"" + id + "\", description: \""
				+ description + "\", visitDate: " + visitDate + "})");
		session.close();
		driver.close();
	}

	public StatementResult readVisit() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:Visit {id: \"" + id
				+ "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updateVisit(){
		Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "USERNAME", "PWD" ) );
		Session session = driver.session();
 		session.run("MATCH (a:Visit {id:\"" +id+ "\"}) SET a.description =\"" + description + "\");
 		session.run("MATCH (a:Visit {id:\"" +id+ "\"}) SET a.visitDate =" + visitDate + ");
		session.close();
		driver.close();
	}

	public void deleteVisit() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:Visit {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
	}

	//getter+setter

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

	public String getId() {
		return id;
	}
}
