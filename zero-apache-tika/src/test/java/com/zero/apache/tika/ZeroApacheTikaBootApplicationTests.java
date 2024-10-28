package com.zero.apache.tika;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class ZeroApacheTikaBootApplicationTests {

    @Test
    void contextLoads() throws TikaException, IOException {
        // Create a Tika instance with the default configuration
        Tika tika = new Tika();
        // Parse all given files and print out the extracted text content

        String filePath ="./src/main/resources/static/";
        String fileName = "tika";
        String suffixDocx = ".docx";
        String suffixTxt = ".txt";
        String suffixJson = ".json";
        String suffixXml = ".xml";
        String textDocx = tika.parseToString(new File(filePath + fileName + suffixDocx));
        System.out.print(textDocx);
        String textTxt = tika.parseToString(new File(filePath + fileName + suffixTxt));
        System.out.print(textTxt);
        String textJson = tika.parseToString(new File(filePath + fileName + suffixJson));
        System.out.print(textJson);
        String textXml = tika.parseToString(new File(filePath + fileName + suffixXml));
        System.out.print(textXml);
    }

}
