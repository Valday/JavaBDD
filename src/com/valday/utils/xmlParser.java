package com.valday;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class xmlParser
{
    private xmlParser ()
    {

    }

    public static Document deserializeXML(String path, String fileName)
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try
        {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //FileInputStream FILE = new FileInputStream("conf\\jdbcConfig.xml");
            String toto = Path.combine(path,fileName);
            InputSource inputFile = new InputSource(new FileInputStream(Path.combine(path,fileName)));
            doc = documentBuilder.parse(inputFile);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return doc;
    }

    public static String nodeToOracleAddress(NodeList nodes)
    {
        String toReturn = new String();
        String[] strSplit ;
        for (int i = 0; i < nodes.getLength(); i++)
        {
            toReturn += nodes.item(i).getTextContent();
        }
        strSplit = toReturn.split("\\s");
        toReturn = "";
        for (int i = 0; i < strSplit.length;i++)
        {
            if (!strSplit[i].isEmpty())
            {
                if ((i > 0) && (i < strSplit.length-1))
                {
                    toReturn += strSplit[i] + ":" ;
                }
                else
                {
                    toReturn += strSplit[i];
                }
            }
        }
        return toReturn;
    }
}
