package devlAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static devlAPI.APIprintService.*;

public class ConfigData {
    private String lesson;
    private boolean runLesson;

    public String getLesson() {
        return lesson;
    }

    public boolean isRunLesson() {
        return runLesson;
    }

    public ConfigData() {

        var path = APIfiles.getPathConfigFile();
        var strPattern = "lesson -r\\s*(\\w+) -i\\s*(\\w+)";
        var pattern = Pattern.compile(strPattern);

        try (var scaner = new Scanner(new File(path))) {
            while (scaner.hasNextLine()) {
                var strLine = scaner.nextLine();
                if (strLine.charAt(0) == '#' || strLine.isEmpty()) {
                    continue;
                }

                // lessons -r true -i
                var matcher = pattern.matcher(strLine);
                if (matcher.find()) {
                    runLesson = Boolean.parseBoolean(matcher.group(1));
                    lesson = matcher.group(2);
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            println(ex.getMessage());
        }

    }
}
