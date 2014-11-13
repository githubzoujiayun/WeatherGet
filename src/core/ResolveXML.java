package core;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import datastructure.WeatherInfo;

/**@author find
 * 解析获取的xml，提取出里面的信息
 * */
public class ResolveXML {
	
	static final int MAXLAYER=100;
	
	
	
	InputSource in;
	SAXReader reader;
	Document doc;
	Element root,tempElement;
	WeatherInfo weather;
	/**内层元素遍历*/
	public ResolveXML(String filename) {
		//initialize
		in=new InputSource(filename);
		reader=new SAXReader();
		reader.setEncoding("utf-8");
		weather=new WeatherInfo();
		
		
		try {
			doc=reader.read(in);
			root=doc.getRootElement();
			System.out.println(root.getName());
			Iterator<Element> item1=root.elementIterator();
			int i=0;
			while(item1.hasNext()){
				tempElement=(Element)item1.next();
				switch (i) {
				case 0:weather.setCity(tempElement.getText());					break;
				case 1:weather.setUpdateTime(tempElement.getText());break;
				case 2:weather.setTemperature(Integer.parseInt(tempElement.getText()));break;
				case 3:weather.setWindForce(tempElement.getText());break;
				case 4:weather.setHumidity(Integer.parseInt(tempElement.getText().substring(0, tempElement.getText().length()-1)));break;
				case 5:weather.setWindDirection(tempElement.getText());break;
				case 10:setEnvironment(tempElement.elementIterator(), weather);break;
				case 12:break;
				case 13:break;
				default:
					break;
				}
				
				
				
				System.out.println("The layer1's son:"+tempElement.getName()+"\t num:"+i);
				i++;
				
				
				
			}
			
			
			
		} catch (DocumentException e) {
			System.out.println("Here's error in reading xml.");
//			e.printStackTrace();
		}
	}
	public void setEnvironment(Iterator<Element>tempit,WeatherInfo tempweather){
		Element tempelement;
		int i=0;
		while(tempit.hasNext()){
			tempelement=(Element)tempit.next();
			switch(i){
			case 1:tempweather.setPM2_5(Integer.parseInt(tempelement.getText()));System.out.println(tempelement.getText());break;
			case 2:tempweather.setSuggest(tempelement.getText());break;
			default :break;
			}
			i++;
		}
	}
	public void setForecast(Iterator<Element>tempit,WeatherInfo tempweather){
		Element tempelement;
		int i=0;
		while(tempit.hasNext()){
			
		}
	}
	
	
}
