
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class Vet

extends de.ul.petclinic.AbstractPerson

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId vetId;
	private DBRef vetDBRef;

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

	//CRUD

	public void createVet() {
		Document newDoc = new Document().append("firstName", firstName)
				.append("lastName", lastName).append("address", address)
				.append("city", city).append("telephone", telephone)
				.append("homepage", homepage).append("email", email)
				.append("birthday", birthday)
				.append("employedSince", employedSince)
				.append("specialty", specialty);
		db.getCollection("Vet").insertOne(newDoc);
		vetId = (ObjectId) newDoc.get("_id");
		vetDBRef = new DBRef("vet", vetId);
	}

	public Document readVet() {
		return db.getCollection("Vet").find(new Document("_id", vetId)).first();
	}

	public void updateVet(){
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
		db.getCollection("Vet").updateOne(new BasicDBObject("_id", vetId),
		, new BasicDBObject("$set", new BasicDBObject("employedSince", employedSince)));
		db.getCollection("Vet").updateOne(new BasicDBObject("_id", vetId),
		, new BasicDBObject("$set", new BasicDBObject("specialty", specialty)));
	}

	public void deleteVet() {
		db.getCollection("Vet").deleteMany(new Document("_id", vetId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

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

	public ObjectId getVetId() {
		return vetId;
	}
	public DBRef getVetDBRef() {
		return vetDBRef;
	}
}
