package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PTTtest {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481420144.A.ABB.html";

				Document doc = CrawlerPack.start()
				// 參數設定
			    		.addCookie("over18","1")	// 設定cookie
				// 選擇資料格式 (三選一)
						.getFromHtml(uri)

			    // 這兒開始是 Jsoup Document 物件操作
			    //.select("div.push>span.push-content ")//留言
			    //.select("a[href$=.png]")//圖

				;
				for(Element elem:doc.select("#main-content *"))
					elem.remove();
				System.out.println(doc.text());

	}
}
