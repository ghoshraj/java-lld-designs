package com.lld.document.model;

public class ImageElement extends DocumentElement {

    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return ("[Image: " + imagePath + "]");
    }
}
