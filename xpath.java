package xpath;

import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

class xpath {

    static void print ( Node e ) {
	if (e instanceof Text) {
	    System.out.print(((Text) e).getData());
	    System.out.println();
	}
	else {
	    NodeList c = e.getChildNodes();
	    System.out.print("<"+e.getNodeName());
	    NamedNodeMap attributes = e.getAttributes();
	    for (int i = 0; i < attributes.getLength(); i++)
		System.out.print(" "+attributes.item(i).getNodeName()
				 +"=\""+attributes.item(i).getNodeValue()+"\"");
	    System.out.print(">");
	    for (int k = 0; k < c.getLength(); k++)
		print(c.item(k));
	    System.out.print("</"+e.getNodeName()+">");
	}
    }

    static void eval ( String query, String document ) throws Exception {
	XPathFactory xpathFactory = XPathFactory.newInstance();
	XPath xpath = xpathFactory.newXPath();
	InputSource inputSource = new InputSource(document);
	NodeList result = (NodeList) xpath.evaluate(query,inputSource,XPathConstants.NODESET);
	System.out.println("XPath query: "+query);
	for (int i = 0; i < result.getLength(); i++)
	    print(result.item(i));
	System.out.println("\n");
    }

    public static void main ( String[] args ) throws Exception {
	//eval("//gradstudent[name/lastname='Galanis']/name","cs.xml");
    	
    /*xpath with xml tags */	
    	
	//Print the titles of all articles whose one of the authors is David Maier.
	eval("//article[authors[author='David Maier']]/title", "SigmodRecord.xml");
	//Print the titles of all articles whose first author is David Maier.
	eval("//article[authors[author[@position='00'] = 'David Maier']]/title", "SigmodRecord.xml");
	//Print the titles of all articles whose authors include David Maier and Stanley B. Zdonik.
	eval("//article[authors[author='David Maier' and author='Stanley B. Zdonik']]/title", "SigmodRecord.xml");
	//Print the titles of all articles in volume 19/number 2.
	eval("//issue[number ='2' and volume ='19']//title", "SigmodRecord.xml");
	//Print the titles and the init/end pages of all articles in volume 19/number 2 whose authors include Jim Gray.
	eval("//issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//title | //issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//initPage | //issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//endPage", "SigmodRecord.xml");
	//Print the volume and number of all articles whose authors include David Maier. (note: we need the number entry of an article, not the number of articles).
	eval("//article[authors[author='David Maier']]//ancestor::issue/volume | //article[authors[author='David Maier']]//ancestor::issue/number", "SigmodRecord.xml");
	
	
	/*xpath without xml tags */	
	
	//Print the titles of all articles whose one of the authors is David Maier.
	eval("//article[authors[author='David Maier']]/title/text()", "SigmodRecord.xml");
	//Print the titles of all articles whose first author is David Maier.
	eval("//article[authors[author[@position='00'] = 'David Maier']]/title/text()", "SigmodRecord.xml");
	//Print the titles of all articles whose authors include David Maier and Stanley B. Zdonik.
	eval("//article[authors[author='David Maier' and author='Stanley B. Zdonik']]/title/text()", "SigmodRecord.xml");
	//Print the titles of all articles in volume 19/number 2.
	eval("//issue[number ='2' and volume ='19']//title/text()", "SigmodRecord.xml");
	//Print the titles and the init/end pages of all articles in volume 19/number 2 whose authors include Jim Gray.
	eval("//issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//title/text() | //issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//initPage/text() | //issue[number ='2' and volume ='19']//article[authors[author='Jim Gray']]//endPage/text()", "SigmodRecord.xml");
	//Print the volume and number of all articles whose authors include David Maier. (note: we need the number entry of an article, not the number of articles).
	eval("//article[authors[author='David Maier']]//ancestor::issue/volume/text() | //article[authors[author='David Maier']]//ancestor::issue/number/text()", "SigmodRecord.xml");
	
	
    }
}
