package mongo.level1;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class SelectMongo2 {
	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver"); // 이 패키지에서 나오는 log 들을 담아서
		mongoLogger.setLevel(Level.SEVERE); // 로그 레벨을 높여서 출력을 안하게 함.
		try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
            
            MongoCursor<Document>  cursor = collection.find().iterator();
            
            while(cursor.hasNext()) {
            	System.out.println(cursor.next());           
            }  		          
            System.out.println("--------------------------------");
            
            // 한번만 읽을 수 있어서 다시 한번 호출
            cursor = collection.find().iterator();
            
            while(cursor.hasNext()) {
            	Document doc = cursor.next();
            	System.out.println(doc.get("name" + " : " + doc.get("price")));
            	System.out.println(doc.get("name") + " : " + ((Double)doc.get("price")).intValue());
            	System.out.println(doc.get("price").getClass().getName());
            }      
            
            System.out.println("--------------------------------");
            
            Consumer<Document> printConsumer1 = new Consumer<Document>() {
                @Override
                public void accept(final Document document) {
                    System.out.println(document.toJson());
                }
            };            
           collection.find().forEach(printConsumer1);
           
           System.out.println("--------------------------------");
           Consumer<Document> printConsumer2 = doc -> System.out.println(doc.toJson());                    
           collection.find().forEach(printConsumer2);
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
	}
}



