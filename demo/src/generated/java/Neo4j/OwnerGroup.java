
import org.neo4j.driver.v1.*;
public class OwnerGroup

implements

java.io.Serializable {
	//id String to identify Unique Neo4j Nodes
	private final String id;

	//regular class properties as designed

	//standard constructor setting the id using java random unique id function
	public OwnerGroup() {
		id = java.util.UUID.randomUUID().toString();
	}

	//CRUD

	public void createOwnerGroup() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("CREATE (a:OwnerGroup {id: \"" + id + "\"})");
		session.close();
		driver.close();
	}

	public StatementResult readOwnerGroup() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		StatementResult result = session.run("MATCH (a:OwnerGroup {id: \"" + id
				+ "\"}) return a");
		session.close();
		driver.close();
		return result;
	}

	public void updateOwnerGroup() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.close();
		driver.close();
	}

	public void deleteOwnerGroup() {
		Driver driver = GraphDatabase.driver("bolt://localhost",
				AuthTokens.basic("USERNAME", "PWD"));
		Session session = driver.session();
		session.run("MATCH (a:OwnerGroup {id: \"" + id + "\"}) DELETE a");
		session.close();
		driver.close();
	}

	//getter+setter

	public String getId() {
		return id;
	}
}
