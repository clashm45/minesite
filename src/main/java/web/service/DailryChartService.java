package web.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mongodb.morphia.Datastore;

import common.model.DailyChart;

@Named
@RequestScoped
public class DailryChartService {

	@Inject
	private Datastore datastore;

	public List<DailyChart> selectDailryChart(){
		System.out.println("日足取得");
		return datastore.createQuery(DailyChart.class).asList();

	}

}
