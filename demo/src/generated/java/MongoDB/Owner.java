
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class Owner

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId ownerId;
	private DBRef ownerDBRef;

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

	//CRUD

	public void createOwner() {
		Document newDoc = new Document().append("firstName", firstName)
				.append("lastName", lastName).append("address", address)
				.append("city", city).append("telephone", telephone)
				.append("homepage", homepage).append("email", email)
				.append("birthday", birthday);
		int ownerGroupcounter = 0;
		for (java.util.Set<de.ul.petclinic.OwnerGroup> i : ownerGroup) {
			newDoc.append("ownerGroup" + ownerGroupcounter,
					i.getownerGroupDBRef());
			ownerGroupcounter++;
		}
		db.getCollection("Owner").insertOne(newDoc);
		ownerId = (ObjectId) newDoc.get("_id");
		ownerDBRef = new DBRef("owner", ownerId);
	}

	public Document readOwner() {
		return db.getCollection("Owner").find(new Document("_id", ownerId))
				.first();
	}

	public void updateOwner(){
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("firstName", firstName)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("lastName", lastName)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("address", address)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("city", city)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("telephone", telephone)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("homepage", homepage)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("email", email)));
		db.getCollection("AbstractPerson").updateOne(new BasicDBObject("_id", abstractpersonId),
		, new BasicDBObject("$set", new BasicDBObject("birthday", birthday)));
		int ownerGroupcounter = 0;
		for( java.util.Set<de.ul.petclinic.OwnerGroup> i : ownerGroup ){
			db.getCollection("Owner").updateOne(new BasicDBObject("_id", ownerId),
			, new BasicDBObject("$set", new BasicDBObject("ownerGroup" + ownerGroupcounter, i.getownerGroupDBRef())));
			ownerGroupcounter++;
		}
	}

	public void deleteOwner() {
		db.getCollection("Owner").deleteMany(new Document("_id", ownerId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

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

	public ObjectId getOwnerId() {
		return ownerId;
	}
	public DBRef getOwnerDBRef() {
		return ownerDBRef;
	}
}
