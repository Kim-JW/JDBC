package mongo.level1;

import java.util.logging.Logger;
import java.util.function.Consumer;
import java.util.logging.Level;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class LoggerTest {
	
	public static MongoClient mongoClient = new MongoClient("localhost", 27017);
	public static MongoDatabase db = mongoClient.getDatabase("edudb");
	public static MongoCollection<Document> collection = db.getCollection("book");

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		// m2();
		//m3();
		m4();
	}
	
	public static void m4() {
		Document doc = collection.find().first();
		
		FindIterable<Document> dlist = collection.find(Filters.gt("price", 10000));
		for(Document doc1 : dlist) {
			System.out.println(doc1.toJson());
		}
	}

	public static void m1() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

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

	public static void m2() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("book");

			MongoCursor<Document> cursor = collection.find().iterator();

			while (cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println(doc.get("name") + ":" + doc.get("price"));
			}
		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}

	public static void m3() {
		try {
			
			MongoCollection<Document> collection = db.getCollection("book");

			// anonymous Enum class 상속, new로 객체를 생성 해서 전달.
			Consumer<Document> printConsumer = new Consumer<Document>() {

				@Override
				public void accept(final Document document) {
					// TODO Auto-generated method stub
					System.out.println(document.toJson());
				}

			};
			
			collection.find().forEach(printConsumer);

		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}

}
