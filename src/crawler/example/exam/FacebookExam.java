package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/crazyck101/posts?fields=id,link,message,reactions.limit(0).summary(total_count)&since=1480852800&until=1480856400"
				+ "&access_token=EAACEdEose0cBAB4nJ77iBeri21BLGiBAnDLThZCjM3zY8DseWI0U3Wjc07U9lj4SqRW8n8SaUAZCGFMwnFKaBrNsgHA7f4FehwJZBL82tqi5DRvbmB96AwrqJXJtx7v8KoYL02GVZBYZCUm7HpHu95f0zMeynjweDmPkM0IcoPQZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,link,message,reactions\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String link = data.select("link").text();
			String msg = data.select("message").text();
			String reactions = data.select("reactions").text();


			output += id + "," + link + "," + msg + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
