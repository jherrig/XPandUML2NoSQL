
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;
@NodeEntity
public class OwnerGroup

implements

java.io.Serializable {
	@GraphId
	private Long id;

	//regular class properties as designed

	//standard constructor 
	public OwnerGroup() {
	}

	//getter+setter

}
