import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiningbo on 2017/3/30.
 */
public class TryMongodb {
    private static final String dbName = "testDb";
    private static MongoClient client = new MongoClient();

    public MongoDatabase getDB(String db) {
        return client.getDatabase(db);
    }

    public void insertList() {
        MongoDatabase db = getDB(dbName);

        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }
        db.getCollection("list").insertMany(documents);

    }

    public void checkInsert() {
        long count = getDB(dbName).getCollection("list").count();
        System.out.println(count);
    }


    public static void main(String[] args) {
        TryMongodb tryMongodb = new TryMongodb();
        tryMongodb.checkInsert();
        tryMongodb.insertList();
        tryMongodb.checkInsert();

    }
}
