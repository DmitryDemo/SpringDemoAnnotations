package com.spring.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class FileReaderFortuneService implements FortuneService {

    private static final String FILE_WITH_FORTUENS = "fortunes.txt";
    private List<String> rows;

    Random rnd = new Random();

    public String getFortune() {
        return rows.get(rnd.nextInt(rows.size()));
    }

    @PostConstruct
    private void readRows() {
        rows = getFortunesFromFile(FILE_WITH_FORTUENS);
        rows.forEach(fortune -> System.out.println("Next row in file is: " + fortune));
    }

    private List<String> getFortunesFromFile(final String fileName) {

        List<String> result = null;

        try {
            result = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
