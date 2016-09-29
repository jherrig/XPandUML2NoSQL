
import org.neo4j.driver.v1.*;
public class Owner

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

	public java.util.Set<de.ul.petclinic.OwnerGroup> ownerGroup = new java.util.HashSet<de.ul.petclinic.OwnerGroup>();

	//standard constructor setting the id using java random unique id function
	public Owner() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createOwner() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:Owner {id: \"" + id + "\"})");
		for (java.util.Set<de.ul.petclinic.OwnerGroup> i : ownerGroup) {
			session.run("MATCH (a:Owner {id: \"" + id
					+ "\"}) MATCH (b:OwnerGroup {id: \"" + i.getId() + "\"})"
					+ "CREATE (a)-[:ownergroup_membership]->(b)");
		}
		session.close();
		driver.close();
	}

	public StatementResult readOwner() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:Owner {id: \"" + id
				+ "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updateOwner() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		for (java.util.Set<de.ul.petclinic.OwnerGroup> i : ownerGroup) {
			session.run("MATCH (a:Owner {id: \"" + id
					+ "\"}) MATCH (b:OwnerGroup {id: \"" + i.getId() + "\"})"
					+ "MERGE (a)-[:ownergroup_membership]->(b)");
		}
		session.close();
		driver.close();
	}

	public void deleteOwner() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:Owner {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
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

	public String getId() {
		return id;
	}
}
