package mongo.homework1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class SelectMongoLab {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver"); // 이 패키지에서 나오는 log 들을 담아서
		mongoLogger.setLevel(Level.SEVERE); // 로그 레벨을 높여서 출력을 안하게 함.
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("studygroup");
			MongoCollection<Document> collection = db.getCollection("banjang");

			MongoCursor<Document> cursor = collection.find().iterator();
			
			// projections 사용하면 그 필드에 맞는 데이터만 꺼낼 수 있다.
			Bson obj = Projections.fields(Projections.include("name","age","book"));
			MongoCursor<Document> cursor2 = collection.find().projection(obj).iterator();

			// 한번만 읽을 수 있어서 다시 한번 호출
			cursor = collection.find().iterator();

			while (cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println((doc.get("name") + " 팀원의 나이는 " + ((Double) doc.get("age")).intValue() + "입니다."));
				System.out.println("[좋아하는 책리스트]");

				ArrayList<Document> books;
				//ArrayList<Document> bookList = (ArrayList<Document>) doc.get("book");

				Object ob = doc.get("book");

				if (ob instanceof ArrayList) {
					books = (ArrayList) ob;
					
//					for(Document d : books)	{
//						System.out.println("책제목 : " + d.get("name"));
//						System.out.println("출판사 : " + d.get("publisher"));
//						System.out.println("장르 : " + d.get("genre"));
//					}

					for (int i = 0; i < books.size(); i++) {
						System.out.println("책제목 : " + books.get(i).get("name"));
						System.out.println("출판사 : " + books.get(i).get("publisher"));
						System.out.println("장르 : " + books.get(i).get("genre"));

					}

				}
				System.out.println("--------------------------------");
			}
			// books = doc.get("book");

			System.out.println();

			

		} catch (

		Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}

}
