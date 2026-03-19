package com.lld.document.persistence;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(data);
            writer.close();

            System.out.println("Saved to file successfully ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
