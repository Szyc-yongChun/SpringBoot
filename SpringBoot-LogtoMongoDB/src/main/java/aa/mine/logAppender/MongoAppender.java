package aa.mine.logAppender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.stereotype.Component;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 插入日志到MongoDB中
 * 
 * @author Administrator
 */
@Component()
public class MongoAppender extends AppenderSkeleton {

	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private MongoCollection<BasicDBObject> logsCollection;

	// private final static String connectionUrl = "mongodb://10.116.23.205:27017";
	// private final static String databaseName = "logs";
	// private final static String collectionName = "logs_request";

	private String connectionUrl;
	private String databaseName;
	private String collectionName;

	public void init() {
		System.out.println("\n\nconnectionUrl:" + connectionUrl + "\n\n");
		System.out.println("\n\ndatabaseName:" + databaseName + "\n\n");
		System.out.println("\n\ncollectionName:" + collectionName + "\n\n");
	}

	@Override
	protected void append(LoggingEvent loggingEvent) {
		System.out.println("\n\nconnectionUrl:" + connectionUrl + "\n\n");
		if (mongoDatabase == null) {
			System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
			MongoClientURI connectionString = new MongoClientURI(connectionUrl);
			mongoClient = new MongoClient(connectionString);
			mongoDatabase = mongoClient.getDatabase(databaseName);
			logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
		}
		logsCollection.insertOne((BasicDBObject) loggingEvent.getMessage());

	}

	@Override
	public void close() {
		if (mongoClient != null) {
			mongoClient.close();
		}
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

	public void setMongoDatabase(MongoDatabase mongoDatabase) {
		this.mongoDatabase = mongoDatabase;
	}

	public MongoCollection<BasicDBObject> getLogsCollection() {
		return logsCollection;
	}

	public void setLogsCollection(MongoCollection<BasicDBObject> logsCollection) {
		this.logsCollection = logsCollection;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}
