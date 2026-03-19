package com.lld.document.model;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }
}
