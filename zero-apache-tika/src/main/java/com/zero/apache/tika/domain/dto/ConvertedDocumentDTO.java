package com.zero.apache.tika.domain.dto;

import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;

@Data
public  class ConvertedDocumentDTO {

    private final String contentAsHtml;

    private final String filename;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("filename", this.filename)
                .append("contentAsHtml", this.contentAsHtml)
                .toString();
    }
}
