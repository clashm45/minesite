package rest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ClientMain {

	public static void main(String[] args) {

		Client c = Client.create();
		WebResource r = c.resource("http://stocks.finance.yahoo.co.jp/stocks/detail/")
				.queryParam("code", "998407.O");

		String html = r.get(String.class);

		Document doc = Jsoup.parse(html);

		doc.select("dl dd.mar0 strong").forEach(System.out::println);

		for(Element dl : doc.getElementsByTag("dl")){
			System.out.println(dl);
		}

//		Element table = doc.getElementsByTag("table").first();
//		List<Kosu> kList = new ArrayList<>();
//		for(Element tr : table.getElementsByTag("tr")){
//			Kosu k = new Kosu();
//			k.setId(tr.getElementsByClass("社員番号").text());
//			k.setName(tr.getElementsByClass("氏名").text());
//			k.setDate(tr.getElementsByClass("日付").text());
//			k.setJobNo(tr.getElementsByClass("ジョブNo").text());
//			k.setWorkCode(tr.getElementsByClass("作業コード").text());
//			k.setWorkingTime(tr.getElementsByClass("作業時間").text());
//			kList.add(k);
//		}

//		System.out.println(JSON.encode(kList));
	}
}
