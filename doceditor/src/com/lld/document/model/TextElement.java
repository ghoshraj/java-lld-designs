package com.lld.document.model;

public class TextElement extends DocumentElement {

    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return (text);
    }
}
