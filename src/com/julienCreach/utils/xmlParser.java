/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
            InputSource inputFile = new InputSource(new FileInputStream(Path.combine(path,fileName)));
            doc = documentBuilder.parse(inputFile);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return doc;
    }

    public static String nodeToOracleAddress(Document doc)
    {
        Element element = doc.getDocumentElement();
        NodeList nodes = element.getChildNodes();
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
