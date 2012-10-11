package com.dinesh.piloting.struts.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class MyUtil extends DefaultHandler{

	public static boolean validateFile(InputStream is) {

		try {
			
			
			File file = new File("C:\\Users\\ddurairaj\\Desktop\\struts-config.xml");
			/*OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int read = 0;
			while ((read = is.read(buf)) != -1){
				out.write(buf, 0, read);
			}
			
			System.out.println("\nFile is created.");
			is.close();
			out.flush();
			out.close();*/
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			builder.setEntityResolver(new EntityResolver() {
				
				@Override
				public InputSource resolveEntity(String publicId, String systemId)
						throws SAXException, IOException {
				if(systemId.contains("struts-config_1_3.dtd")){
					return new InputSource(new StringReader(""));
				}else
					return null;
				}
			});
			
			Document doc = builder.parse(file);
			Element el = doc.getDocumentElement();
			System.out.println(el.getNodeName());
			
			if(el.getNodeName()=="struts-config"){
				NodeList nodes = el.getChildNodes();

				for(int i=0; i<nodes.getLength(); i++){
				  Node node = nodes.item(i);

				  if(node instanceof Element){
				    //a child element to process
				    Element child = (Element) node;
				    //String attribute = child.getAttribute("width");
				    System.out.println(child);
				  }
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*public void parseXmlDocument(){
		try{
			File file = new File("struts.xml");
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			sp.parse(file, this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
}
