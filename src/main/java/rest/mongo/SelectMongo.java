package rest.mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import common.model.DailyChart;

public class SelectMongo {

	public static void main(String[] args) {
		final Morphia morphia = new Morphia();
		final Datastore datastore = morphia.createDatastore(new MongoClient(), "stocks");
		datastore.createQuery(DailyChart.class).asList().forEach(System.out::println);

	}

}
