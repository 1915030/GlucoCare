package com.GC.dao;

	import java.util.ArrayList;

	import org.bson.BsonObjectId;
	import org.bson.Document;
	import org.bson.types.ObjectId;

import com.GC.model.Sugar;
import com.GC.model.User;
	import com.mongodb.BasicDBObject;
	import com.mongodb.client.MongoClient;
	import com.mongodb.client.MongoClients;
	import com.mongodb.client.MongoCursor;


	public class DB {
		
		MongoClient mongoClient;


		public DB() {
			try {
				String connectionURL ="mongodb+srv://keerat:keerat@cluster0.mxdy1.mongodb.net/TrainingProject?retryWrites=true&w=majority";
		    	mongoClient = MongoClients.create(connectionURL);
		    	
		    	System.out.println(getClass().getSimpleName()+" MongoDB Connection Created and Reference to Client Object Obtained");
			
			} catch (Exception e) {
				System.out.println("Something Went Wrong: "+e);
			}

		}
		
		
		public boolean registerUser(User user) {
			
			Document document = new Document(user.toMap());
	    	
	    	//Insert into DataBase
	    	mongoClient.getDatabase("TrainingProject").getCollection("users").insertOne(document);
	    	System.out.println(user.getName()+ "Registerd in MongoDB");
			
			return true;
		}
		
		public boolean logSugar(Sugar sugar) {
			
			Document document = new Document(sugar.toMap());
	    	
	    	//Insert into DataBase
	    	mongoClient.getDatabase("TrainingProject").getCollection("sugarlvl").insertOne(document);
	    	System.out.println(sugar.userId+" "+sugar.sugar+" Sugar Level saved in MongoDB");
			
			return true;
		}
		
		public boolean loginUser(User user) {
			
			System.out.println("[DB] User Data:"+user);
			
			BasicDBObject query = new BasicDBObject();
			query.put("email", user.email);
			query.put("password", user.password);
			
			// Fetching the Data
			MongoCursor<Document> cursor = mongoClient.getDatabase("TrainingProject").getCollection("users").find(query).iterator();
		
		
			boolean flag = cursor.hasNext();
			if(flag) {
				
				Document document = cursor.next();
				System.out.println(document.getObjectId("_id"));
				System.out.println(document.getString("name"));
				
				user._id = document.getObjectId("_id").toString();
				user.name = document.getString("name");
				System.out.println("[DB] User Data After Successful Login:"+user);
				
			}
			
			
			return flag;
		}
		
		public void fetchUsers() {
			
			try {
				MongoCursor<Document> cursor = mongoClient.getDatabase("TrainingProject").getCollection("admin").find().iterator();
		    	while(cursor.hasNext()) {
		    		//System.out.println(cursor.next());
		    		System.out.println(cursor.next().toJson());
		    	}
			}catch(Exception e) {
				System.out.println("Something Went Wrong: "+e);
			}
	    	
		}
		
		public ArrayList<Sugar> fetchSugarl(String userId) {
			
			ArrayList<Sugar> sugarRecords = new ArrayList<Sugar>();
			
			try {
				
				BasicDBObject query = new BasicDBObject();
				query.put("userId", userId);
				
		    	MongoCursor<Document> cursor = mongoClient.getDatabase("TrainingProject").getCollection("sugarlvl").find(query).iterator();
		    	while(cursor.hasNext()) {
		    		
		    		Document document = cursor.next();
		    		Sugar sugar = new Sugar();
		    		sugar._id = document.getObjectId("_id").toString();
		    		sugar.userId = document.getString("userId");
		    		sugar.dateTimeStamp = document.getDate("dateTimeStamp").toString();
		    		sugar.sugar = document.getDouble("sugar");
		    		
		    		sugarRecords.add(sugar);
		    		
		    	}
			}catch(Exception e) {
				System.out.println("Something Went Wrong: "+e);
			}
			
			return sugarRecords;
	    	
		}
}
