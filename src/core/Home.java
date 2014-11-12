package core;

public class Home {
	static final String weburl="http://wthrcdn.etouch.cn/WeatherApi?citykey=101120101"; 

	DownloadXML downXML;
	ResolveXML resolveXML;
	public Home() {
		
		
		
		
		
		downXML=new DownloadXML(weburl);
		resolveXML =new ResolveXML("temp.xml");
		
		
	}
	
	public static void main(String[] args) {
		new Home();
	}
}
