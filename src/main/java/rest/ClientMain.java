package rest;

import java.util.ArrayList;
import java.util.List;

import net.arnx.jsonic.JSON;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ClientMain {

	public static void main(String[] args) {

		Client c = Client.create();
		WebResource r = c.resource("http://www.qcl.ydc.co.jp/projects/dashboard/report/")
				.path("111")
				.queryParam("JOBNO", "15SA1342");

		String html = r.get(String.class);

		Document doc = Jsoup.parse(html);
		Element table = doc.getElementsByTag("table").first();
		List<Kosu> kList = new ArrayList<>();
		for(Element tr : table.getElementsByTag("tr")){
			Kosu k = new Kosu();
			k.setId(tr.getElementsByClass("社員番号").text());
			k.setName(tr.getElementsByClass("氏名").text());
			k.setDate(tr.getElementsByClass("日付").text());
			k.setJobNo(tr.getElementsByClass("ジョブNo").text());
			k.setWorkCode(tr.getElementsByClass("作業コード").text());
			k.setWorkingTime(tr.getElementsByClass("作業時間").text());
			kList.add(k);
		}

		System.out.println(JSON.encode(kList));
	}
}
