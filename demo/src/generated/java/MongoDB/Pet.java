
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class Pet

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId petId;
	private DBRef petDBRef;

	//regular class properties as designed

	private java.lang.Boolean sendReminders = false;

	private java.lang.String name = "null";

	private java.lang.Float weight = 0;

	private de.ul.petclinic.Owner owner = null;

	private de.ul.petclinic.PetType type = null;

	//CRUD

	public void createPet() {
		Document newDoc = new Document().append("sendReminders", sendReminders)
				.append("name", name).append("weight", weight)
				.append("type", type);

		newDoc.append("owner", owner.getownerDBRef());
		db.getCollection("Pet").insertOne(newDoc);
		petId = (ObjectId) newDoc.get("_id");
		petDBRef = new DBRef("pet", petId);
	}

	public Document readPet() {
		return db.getCollection("Pet").find(new Document("_id", petId)).first();
	}

	public void updatePet(){
		db.getCollection("Pet").updateOne(new BasicDBObject("_id", petId),
		, new BasicDBObject("$set", new BasicDBObject("sendReminders", sendReminders)));
		db.getCollection("Pet").updateOne(new BasicDBObject("_id", petId),
		, new BasicDBObject("$set", new BasicDBObject("name", name)));
		db.getCollection("Pet").updateOne(new BasicDBObject("_id", petId),
		, new BasicDBObject("$set", new BasicDBObject("weight", weight)));
		db.getCollection("Pet").updateOne(new BasicDBObject("_id", petId),
		, new BasicDBObject("$set", new BasicDBObject("type", type)));
		db.getCollection("Pet").updateOne(new BasicDBObject("_id", petId),
		, new BasicDBObject("$set", new BasicDBObject("owner", owner.getownerDBRef())));
	}

	public void deletePet() {
		db.getCollection("Pet").deleteMany(new Document("_id", petId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

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

	public ObjectId getPetId() {
		return petId;
	}
	public DBRef getPetDBRef() {
		return petDBRef;
	}
}
