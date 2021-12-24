package mongo.level1;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class SelectMongo1 {
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("book");
			MongoCursor<Document> cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}
}