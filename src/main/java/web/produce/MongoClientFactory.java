package web.produce;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

@Stateless
public class MongoClientFactory {

	@Produces
	public Datastore getMongoDatastore(){
		System.out.println("MongoDb 接続");
		final Morphia morphia = new Morphia();
		return morphia.createDatastore(new MongoClient(), "stocks");
	}
}
