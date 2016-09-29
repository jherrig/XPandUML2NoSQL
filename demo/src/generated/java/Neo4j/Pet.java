
import org.neo4j.driver.v1.*;
public class Pet

implements

java.io.Serializable {
	//id String to identify Unique Neo4j Nodes
	private final String id;

	//regular class properties as designed

	private java.lang.Boolean sendReminders = false;

	private java.lang.String name = "null";

	private java.lang.Float weight = 0;

	private de.ul.petclinic.Owner owner = null;

	private de.ul.petclinic.PetType type = null;

	//standard constructor setting the id using java random unique id function
	public Pet() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createPet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:Pet {id: \"" + id + "\", sendReminders: "
				+ sendReminders + ", name: \"" + name + "\", weight: " + weight
				+ ", type: " + type + "})");
		session.run("MATCH (a:Pet {id: \"" + id + "\"}) MATCH (b:Owner {id: \""
				+ owner.getId() + "\"})" + "CREATE (a)-[:pet_owner_1]->(b)");
		session.close();
		driver.close();
	}

	public StatementResult readPet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:Pet {id: \"" + id
				+ "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updatePet(){
		Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "USERNAME", "PWD" ) );
		Session session = driver.session();
 		session.run("MATCH (a:Pet {id:\"" +id+ "\"}) SET a.sendReminders =" + sendReminders + ");
 		session.run("MATCH (a:Pet {id:\"" +id+ "\"}) SET a.name =\"" + name + "\");
 		session.run("MATCH (a:Pet {id:\"" +id+ "\"}) SET a.weight =" + weight + ");
 		session.run("MATCH (a:Pet {id:\"" +id+ "\"}) SET a.type =" + type + ");
		session.run("MATCH (a:Pet {id: \""+ id +"\"}) MATCH (b:Owner {id: \"" + owner.getId() + "\"})"
				+ "MERGE (a)-[:pet_owner_1]->(b)");
		session.close();
		driver.close();
	}

	public void deletePet() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:Pet {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
	}

	//getter+setter

	/**
	 * 
	 * @return The sendReminders as <code>java.lang.Boolean</code>
	 */

	public java.lang.Boolean getSendReminders() {
		return sendReminders;
	}

	/**
	 * 
	 * @param sendReminders The sendReminders to set
	 */

	public void setSendReminders(java.lang.Boolean sendReminders) {
		this.sendReminders = sendReminders;
	}

	/**
	 * 
	 * @return The name as <code>java.lang.String</code>
	 */

	public java.lang.String getName() {
		return name;
	}

	/**
	 * 
	 * @param name The name to set
	 */

	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The weight as <code>java.lang.Float</code>
	 */

	public java.lang.Float getWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight The weight to set
	 */

	public void setWeight(java.lang.Float weight) {
		this.weight = weight;
	}

	/**
	 * 
	 * @return The owner as <code>de.ul.petclinic.Owner</code>
	 */

	public de.ul.petclinic.Owner getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner The owner to set
	 */

	public void setOwner(de.ul.petclinic.Owner owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * @return The type as <code>de.ul.petclinic.PetType</code>
	 */

	public de.ul.petclinic.PetType getType() {
		return type;
	}

	/**
	 * 
	 * @param type The type to set
	 */

	public void setType(de.ul.petclinic.PetType type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}
}
