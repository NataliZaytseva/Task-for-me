package parse.impl;

import OutputTo.impl.SaveFromURL;
import parse.Parse;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.io.*;
import java.util.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;


public class RefParseFromFile implements Parse {

    @Override
    public List<String> parse(String fileName) throws IOException, BadLocationException {
        final ArrayList<String> references = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        parser.parse(br, callback, true);
        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.A);
             iterator.isValid();
             iterator.next()) {

            AttributeSet attributes = iterator.getAttributes();
            String srcString = (String) attributes.getAttribute(HTML.Attribute.HREF);
            references.add(new String(srcString));
        }
        br.close();
        return references;
    }
}
