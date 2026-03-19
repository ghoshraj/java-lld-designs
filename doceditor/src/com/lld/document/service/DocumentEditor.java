package com.lld.document.service;

import com.lld.document.model.Document;
import com.lld.document.model.ImageElement;
import com.lld.document.model.NextLine;
import com.lld.document.model.TextElement;
import com.lld.document.persistence.Persistence;

public class DocumentEditor {

    private Document document;
    private Persistence storage;

    public DocumentEditor(Persistence storage) {
        this.document = new Document();
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String path) {
        document.addElement(new ImageElement(path));
    }

    public void addNextLine() {
        document.addElement(new NextLine());
    }

    public Document getDocument() {
        return document;
    }

    public void save() {
        DocumentRenderer renderer = new DocumentRenderer();
        String data = renderer.render(document);
        storage.save(data);
    }
}
