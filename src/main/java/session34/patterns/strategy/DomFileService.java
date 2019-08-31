package session34.patterns.strategy;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import static java.util.Objects.requireNonNull;

class DomFileService {
    private final DomParser htmlParser;
    private final DomParser xmlParser;

    DomFileService(DomParser htmlParser, DomParser xmlParser) {
        this.htmlParser = htmlParser;
        this.xmlParser = xmlParser;
    }

    void process(File file) {
        String filename = file.getName();
        if (filename.endsWith(".html")) {
            htmlParser.parse(read(file));
        } else if(filename.endsWith(".xml")) {
            xmlParser.parse(read(file));
        }
    }

    private static String read(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DomFileService2 {
    private final Map<String,DomParser> parsers;

    DomFileService2(Map<String, DomParser> parsers) {
        this.parsers = parsers;
    }

    void process(File file) {
        String extension = FilenameUtils.getExtension(file.getName());
        DomParser parser = requireNonNull(parsers.get(extension));
        parser.parse(read(file));
    }

    private static String read(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
