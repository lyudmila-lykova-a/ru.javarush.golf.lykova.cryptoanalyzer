package ru.javarush.golf.lykova.cryptoanalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileEncode {

    public final String inputFileName;
    private final String outputFileName;
    public final StringEncode stringEncode;

    public FileEncode(String inputFileName, String outputFileName, StringEncode stringEncode) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.stringEncode = stringEncode;
    }

    public void encode() throws IOException {
        List<String> lineList = Files.readAllLines(Path.of(inputFileName));
        List<String> encodedLineList = new ArrayList<>();
        for (String line : lineList) {
            encodedLineList.add(stringEncode.encode(line));
        }
        Files.write(Path.of(outputFileName), encodedLineList, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    }
}
