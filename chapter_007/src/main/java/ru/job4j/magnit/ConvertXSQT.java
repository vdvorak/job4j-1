package ru.job4j.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConvertXSQT {
    public File convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(
                            new FileReader(scheme)
                    ));
            transformer.transform(new StreamSource(
                            new FileReader(source)),
//                    new StreamResult(System.out)
                    new StreamResult(dest)
            );

        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
        return dest;
    }

}
