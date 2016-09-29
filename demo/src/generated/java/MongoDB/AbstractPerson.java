
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.DBRef;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class AbstractPerson

implements

java.io.Serializable {
	//MongoDB-related properties
	private final MongoClient mgClient = new MongoClient();
	private final MongoDatabase db = mgClient.getDatabase("test");
	private ObjectId abstractpersonId;
	private DBRef abstractpersonDBRef;

	//regular class properties as designed

	private java.lang.String firstName = null;

	private java.lang.String lastName = null;

	private java.lang.String address = null;

	private java.lang.String city = "null";

	private java.lang.String telephone = null;

	private java.lang.String homepage = null;

	private java.lang.String email = null;

	private java.util.Date birthday = null;

	//CRUD

	public void createAbstractPerson() {
		Document newDoc = new Document().append("firstName", firstName)
				.append("lastName", lastName).append("address", address)
				.append("city", city).append("telephone", telephone)
				.append("homepage", homepage).append("email", email)
				.append("birthday", birthday);
		db.getCollection("AbstractPerson").insertOne(newDoc);
		abstractpersonId = (ObjectId) newDoc.get("_id");
		abstractpersonDBRef = new DBRef("abstractperson", abstractpersonId);
	}

	public Document readAbstractPerson() {
		return db.getCollection("AbstractPerson")
				.find(new Document("_id", abstractpersonId)).first();
	}

	public void updateAbstractPerson(){
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
	}

	public void deleteAbstractPerson() {
		db.getCollection("AbstractPerson").deleteMany(
				new Document("_id", abstractpersonId));
	}

	//getter+setter, ObjectId/RefID has no setter(it may only be set during the 'create' method!)

	/**
	 * 
	 * @return The firstName as <code>java.lang.String</code>
	 */

	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName The firstName to set
	 */

	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return The lastName as <code>java.lang.String</code>
	 */

	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName The lastName to set
	 */

	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return The address as <code>java.lang.String</code>
	 */

	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address The address to set
	 */

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The city as <code>java.lang.String</code>
	 */

	public java.lang.String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city The city to set
	 */

	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The telephone as <code>java.lang.String</code>
	 */

	public java.lang.String getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @param telephone The telephone to set
	 */

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 
	 * @return The homepage as <code>java.lang.String</code>
	 */

	public java.lang.String getHomepage() {
		return homepage;
	}

	/**
	 * 
	 * @param homepage The homepage to set
	 */

	public void setHomepage(java.lang.String homepage) {
		this.homepage = homepage;
	}

	/**
	 * 
	 * @return The email as <code>java.lang.String</code>
	 */

	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email The email to set
	 */

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return The birthday as <code>java.util.Date</code>
	 */

	public java.util.Date getBirthday() {
		return birthday;
	}

	/**
	 * 
	 * @param birthday The birthday to set
	 */

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public ObjectId getAbstractPersonId() {
		return abstractpersonId;
	}
	public DBRef getAbstractPersonDBRef() {
		return abstractpersonDBRef;
	}
}
