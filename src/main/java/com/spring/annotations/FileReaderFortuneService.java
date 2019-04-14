package com.spring.annotations;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class FileReaderFortuneService implements FortuneService {

    private static final String FILE_WITH_FORTUENS = "fortunes.txt";

    Random rnd = new Random();

    @Override
    public String getFortune() {

        List<String> allFortunes = getFortunesFromFile(FILE_WITH_FORTUENS);

        return allFortunes.get(rnd.nextInt(allFortunes.size()));
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
