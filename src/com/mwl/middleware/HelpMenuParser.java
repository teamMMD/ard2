package com.mwl.middleware;

import com.mwl.util.MenuTrieNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelpMenuParser {

    public static void main(String[] args) {

    }

    public MenuTrieNode makeMenu() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        NodeList menuNodeList = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("resources/menu/help_menu.xml");
            menuNodeList = doc.getElementsByTagName("menu");

            MenuTrieNode menu = recursiveHelper(menuNodeList.item(0));
            menu.setParent(menu);
            System.out.println(menu);
            return menu;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        MenuTrieNode failure = new MenuTrieNode("Help Menu", "There was an error reading the help menu," +
                " please restart the game to try again.");
        failure.setParent(failure);

        return failure;
    }

    static MenuTrieNode recursiveHelper(Node current) {
        List<MenuTrieNode> result = new ArrayList<>();
        NodeList children = current.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element temp = (Element) children.item(i);
                if (temp.getParentNode().equals(current)) {
                    result.add(recursiveHelper(children.item(i)));
                }
            }
        }

        Element temp = (Element) current;
        MenuTrieNode returning = new MenuTrieNode(temp.getAttribute("title"), temp.getAttribute("description"));
        result.forEach(menuTrieNode -> {
            returning.addChild(menuTrieNode);
            menuTrieNode.setParent(returning);
        });

        return returning;
    }
}
