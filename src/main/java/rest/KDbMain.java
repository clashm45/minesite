package rest;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import net.arnx.jsonic.JSON;

public class KDbMain {

	public static void main(String[] args) {
		Client c = Client.create();
		WebResource r = c.resource("http://k-db.com/stocks/2121-T");
				//.queryParam("code", "998407.O");

		String html = r.get(String.class);

		Document doc = Jsoup.parse(html);
		//System.out.println(doc.select("#maintable tbody tr"));

		List<DailyChart> dcList = doc.select("#maintable tbody tr")
		.stream()
		.map(tr -> {
			/*	<tr>
				 <td class="l">2016-07-01</td> 日付
				 <td></td>空
				 <td>4225.00</td>始値
				 <td>4290.00</td>高値
				 <td>4215.00</td>安値
				 <td class="b">4275.00</td>終値
				 <td>489300</td>出来高
				 <td>2083198500</td>売買代金
				 <td></td>空
				</tr>*/
			List<String> vals = tr.getElementsByTag("td").stream()
			.filter(td -> td.hasText())
			.map(td -> td.text())
			.collect(Collectors.toList());

			DailyChart dc = new DailyChart();
			dc.setDate(vals.get(0));
			dc.setOpen(Double.parseDouble(vals.get(1)));
			dc.setHigh(Double.parseDouble(vals.get(2)));
			dc.setLow(Double.parseDouble(vals.get(3)));
			dc.setClose(Double.parseDouble(vals.get(4)));
			dc.setVolume(Double.parseDouble(vals.get(5)));
			dc.setTurnover(Double.parseDouble(vals.get(6)));
			return dc;
		})
		.collect(Collectors.toList());


		JSON json = new JSON();
		json.setPrettyPrint(true);
		System.out.println(json.format(dcList));


	}
}
