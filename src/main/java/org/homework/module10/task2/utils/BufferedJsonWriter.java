package org.homework.module10.task2.utils;

import org.json.simple.JSONArray;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedJsonWriter extends BufferedWriter {

    public BufferedJsonWriter(BufferedWriter writer) {
        super(writer);
    }

    public void write(JSONArray jsonArray) throws IOException {
        write(jsonArray.toJSONString());
    }

    public void writeArray(ArrayList<String> strings) throws IOException {
        write(strings.toString());
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
