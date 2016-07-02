package web.controll;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

import lombok.Data;
import web.service.DailryChartService;

@Data
@Named
@RequestScoped
public class DailyChartController {

	private OhlcChartModel ohlcModel;
	private LineChartModel lineModel;

	@Inject
	private DailryChartService dailryChartService;

	@PostConstruct
	public void init(){
		this.ohlcModel = createChartModel();
		this.lineModel = createLineModel();
	}

	private LineChartModel createLineModel() {

		LineChartModel dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set("2014-01-01", 51);
        series1.set("2014-01-06", 22);
        series1.set("2014-01-12", 65);
        series1.set("2014-01-18", 74);
        series1.set("2014-01-24", 24);
        series1.set("2014-01-30", 51);

        dateModel.addSeries(series1);

        dateModel.setTitle("Linear Chart");
        dateModel.setLegendPosition("e");
        Axis yAxis = dateModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

		return dateModel;
	}

	public OhlcChartModel createChartModel(){
		System.out.println("CreateChartModel Method Call");

		List<OhlcChartSeries> seties =
				dailryChartService.selectDailryChart().stream()
				.peek(System.out::println)
				.map(dc -> new OhlcChartSeries(dc.getDate().replace("-",""), dc.getOpen(), dc.getHigh(), dc.getLow(), dc.getClose()))
				.collect(Collectors.toList());
		OhlcChartModel ohlcModel = new OhlcChartModel(seties);

//		if(seties.isEmpty()){
//			ohlcModel.add(new OhlcChartSeries(2007, 143.82, 144.56, 136.04, 136.97));
//			ohlcModel.add(new OhlcChartSeries(2008, 138.7, 139.68, 135.18, 135.4));
//			ohlcModel.add(new OhlcChartSeries(2009, 143.46, 144.66, 139.79, 140.02));
//			ohlcModel.add(new OhlcChartSeries(2010, 140.67, 143.56, 132.88, 142.44));
//			ohlcModel.add(new OhlcChartSeries(2011, 136.01, 139.5, 134.53, 139.48));
//			ohlcModel.add(new OhlcChartSeries(2012, 124.76, 135.9, 124.55, 135.81));
//			ohlcModel.add(new OhlcChartSeries(2012, 123.73, 129.31, 121.57, 122.5));
//		}
		ohlcModel.setTitle("Candlestick");
		ohlcModel.setCandleStick(true);
		ohlcModel.getAxis(AxisType.X).setLabel("Sector");
		ohlcModel.getAxis(AxisType.Y).setLabel("Index Value");

		return ohlcModel;
	}

}
