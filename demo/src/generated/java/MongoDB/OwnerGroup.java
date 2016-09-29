
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class OwnerGroup

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId ownergroupId;
	private DBRef ownergroupDBRef;

	//regular class properties as designed

	//CRUD

	public void createOwnerGroup() {
		Document newDoc = new Document();
		db.getCollection("OwnerGroup").insertOne(newDoc);
		ownergroupId = (ObjectId) newDoc.get("_id");
		ownergroupDBRef = new DBRef("ownergroup", ownergroupId);
	}

	public Document readOwnerGroup() {
		return db.getCollection("OwnerGroup")
				.find(new Document("_id", ownergroupId)).first();
	}

	public void updateOwnerGroup() {
	}

	public void deleteOwnerGroup() {
		db.getCollection("OwnerGroup").deleteMany(
				new Document("_id", ownergroupId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

	public ObjectId getOwnerGroupId() {
		return ownergroupId;
	}
	public DBRef getOwnerGroupDBRef() {
		return ownergroupDBRef;
	}
}
