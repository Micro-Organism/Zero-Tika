package com.zero.apache.tika.controller;

import com.zero.apache.tika.common.convertor.WordToHtmlConverter;
import com.zero.apache.tika.domain.dto.ConvertedDocumentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class TikaController {

    WordToHtmlConverter converter;

    @Autowired
    public TikaController(WordToHtmlConverter converter) {
        this.converter = converter;
    }

    /**
     * Transforms the Word document into HTML document and returns the transformed document.
     *
     * @return  The content of the uploaded document as HTML.
     */
    @RequestMapping(value = "/api/word-to-html", method = RequestMethod.POST)
    public ConvertedDocumentDTO convertWordDocumentIntoHtmlDocument(@RequestParam(value = "file", required = true) MultipartFile wordDocument) {
        log.info("Converting word document into HTML document");

        ConvertedDocumentDTO htmlDocument = converter.convertWordDocumentIntoHtml(wordDocument);

        log.info("Converted word document into HTML document.");
        log.trace("The created HTML markup looks as follows: {}", htmlDocument);

        return htmlDocument;
    }
}