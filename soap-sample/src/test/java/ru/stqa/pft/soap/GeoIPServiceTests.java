package ru.stqa.pft.soap;


import com.lavasoft.GeoIPService;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;
;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class GeoIpServiceTests {
  @Test
  public void testMyIp(){
    String location = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("195.209.151.104");
    try {
      InputSource inputXML = new InputSource( new StringReader( location ) );
      XPath xPath = XPathFactory.newInstance().newXPath();
      String result = xPath.evaluate("/GeoIP/Country", inputXML);
      System.out.println(result);
      Assert.assertEquals(result, "RU");
    } catch (XPathExpressionException e) {
      e.printStackTrace();
    }
  }
}
