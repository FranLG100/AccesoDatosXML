package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("alumnos.xml");
			NodeList alumnos= doc.getElementsByTagName("alumno");
			for (int i = 0; i < alumnos.getLength(); i++) {
				Node p=alumnos.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE) {
					Element alumno=(Element) p;
					String nombre=alumno.getElementsByTagName("nombre").item(0).getTextContent();
					String edad=alumno.getElementsByTagName("edad").item(0).getTextContent();
					System.out.println("Alumno: "+nombre+"\nEdad: "+edad);
				}
				
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
