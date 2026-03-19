package com.lld.document.service;

import com.lld.document.model.Document;
import com.lld.document.model.DocumentElement;

public class DocumentRenderer {

    public String render(Document doc) {
        StringBuilder sb = new StringBuilder();
        for (DocumentElement element : doc.getElements()) {
            sb.append(element.render());
        }
        return sb.toString();
    }
}
