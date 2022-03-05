package xpath;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

class xslt {
    public static void main ( String argv[] ) throws Exception {
	//File stylesheet = new File("xslt-example.xsl");
	//File xmlfile  = new File("cs.xml");
	File stylesheet = new File("recipes.xsl");
	File xmlfile  = new File("recipes.xml");
	File htmlfile  = new File("recipes.html");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document document = db.parse(xmlfile);
	StreamSource stylesource = new StreamSource(stylesheet);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesource);
	DOMSource source = new DOMSource(document);
	StreamResult result = new StreamResult(htmlfile);
	transformer.transform(source,result);
    }
}
