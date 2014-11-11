package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class DownloadXML {
	/**
	 * 获取xml文件
	 * @param weburl  输入的网址
	 * */
	public void DownXML(String weburl) {
		HttpClient client = HttpClients.createDefault();
		;
		HttpGet get = new HttpGet(weburl);
		get.setHeader("Content-Type", "application/xml");
		HttpResponse response;
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				BufferedReader in = new BufferedReader(
						new InputStreamReader(is));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null)
					buffer.append(line + "\n");
				System.out.println(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new DownloadXML().DownXML("http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100");
		;
	}
}
