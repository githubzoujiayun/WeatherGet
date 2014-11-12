package core;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**@author find
 * 解析获取的xml，提取出里面的信息
 * */
public class ResolveXML {
	
	static final int MAXLAYER=100;
	
	
	
	InputSource in;
	SAXReader reader;
	Document doc;
	Element root,tempElement;
	Iterator item[];
	int layerIndex;
	public ResolveXML(String filename) {
		in=new InputSource(filename);
		reader=new SAXReader();
		reader.setEncoding("utf-8");
		item=new Iterator[MAXLAYER];
		layerIndex=0;
		
		
		
		try {
			doc=reader.read(in);
			root=doc.getRootElement();
			System.out.println(root.getName());
			item[layerIndex]=root.elementIterator();
			while(item[layerIndex].hasNext()){
				tempElement=(Element)item[layerIndex].next();
				System.out.println("The layer1's son:"+tempElement.getName());
			}
			
			
			
		} catch (DocumentException e) {
			System.out.println("Here's error in reading xml.");
//			e.printStackTrace();
		}
	}
}
