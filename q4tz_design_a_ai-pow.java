import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GamePrototypeParser {

    // Game prototype data structure
    class GamePrototype {
        String gameType;
        String gameName;
        List<String> gameFeatures;
    }

    // AI-powered parser engine
    class ParserEngine {
        private Pattern pattern;

        public ParserEngine(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        public GamePrototype parse(String input) {
            GamePrototype prototype = new GamePrototype();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                prototype.gameType = matcher.group(1);
                prototype.gameName = matcher.group(2);
                prototype.gameFeatures = new ArrayList<>();

                String[] features = matcher.group(3).split(",");
                for (String feature : features) {
                    prototype.gameFeatures.add(feature.trim());
                }
            }

            return prototype;
        }
    }

    public static void main(String[] args) {
        // Sample input data
        String input = "RPG,The Last Quest,[Magic,Combat,Exploration]";

        // Initialize parser engine with regex pattern
        ParserEngine parser = new ParserEngine("(\\w+),([^,]+),\\[(.+)]");

        // Parse input data
        GamePrototype prototype = parser.parse(input);

        // Print parsed game prototype data
        System.out.println("Game Type: " + prototype.gameType);
        System.out.println("Game Name: " + prototype.gameName);
        System.out.println("Game Features:");
        for (String feature : prototype.gameFeatures) {
            System.out.println("- " + feature);
        }
    }
}