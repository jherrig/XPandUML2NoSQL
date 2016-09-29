
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class Visit

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId visitId;
	private DBRef visitDBRef;

	//regular class properties as designed

	private java.lang.String description = null;

	private java.util.Date visitDate = null;

	private de.ul.petclinic.Pet pet = null;

	private de.ul.petclinic.Vet vet = null;

	//CRUD

	public void createVisit() {
		Document newDoc = new Document().append("description", description)
				.append("visitDate", visitDate);
		db.getCollection("Visit").insertOne(newDoc);
		visitId = (ObjectId) newDoc.get("_id");
		visitDBRef = new DBRef("visit", visitId);
	}

	public Document readVisit() {
		return db.getCollection("Visit").find(new Document("_id", visitId))
				.first();
	}

	public void updateVisit(){
		db.getCollection("Visit").updateOne(new BasicDBObject("_id", visitId),
		, new BasicDBObject("$set", new BasicDBObject("description", description)));
		db.getCollection("Visit").updateOne(new BasicDBObject("_id", visitId),
		, new BasicDBObject("$set", new BasicDBObject("visitDate", visitDate)));
	}

	public void deleteVisit() {
		db.getCollection("Visit").deleteMany(new Document("_id", visitId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

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

	public ObjectId getVisitId() {
		return visitId;
	}
	public DBRef getVisitDBRef() {
		return visitDBRef;
	}
}
