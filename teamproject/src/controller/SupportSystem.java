package controller;

import javax.swing.*;
import java.util.HashSet;
import java.util.HashMap;

public class SupportSystem {
    private HashMap<String, String> responseMap;

    public SupportSystem() {
        responseMap = new HashMap<>();
    }

    public void initSupportSystem() {
        fillResponseMap();
        JOptionPane.showMessageDialog(null, "Welcome to Tech Support System~\nHow can I help you? Please describe your issue!", "Support System", JOptionPane.INFORMATION_MESSAGE);
        giveResponse(getInput());
    }

    private void fillResponseMap() {
        responseMap.put("network", "Check your router settings. Restarting your router may help with XML cloud syncing.");
        responseMap.put("rating", "Our system uses a 5-level scale: \n9.0+ is Masterpiece, 8.0-8.9 is Excellent, 7.0-7.9 is Good, 6.0-6.9 is Average, below 6.0 is Poor.");
        responseMap.put("review", "A good movie review should cover the plot, acting, and cinematography. Try to be objective!");
        responseMap.put("save", "To persist your movie list, use the 'Save XML' option. This writes your data to 'movies.xml'.");
        responseMap.put("search", "You can search movies by Title, Director, or even a minimum Rating (e.g., enter '9.0' to find masterpieces).");
        responseMap.put("recommend", "Based on our database, 'The Shawshank Redemption' is a must-watch with a 9.7 rating!");
        responseMap.put("criteria", "When rating, consider: 10-9 (Life-changing), 8-7 (Highly recommended), 6 (Worth a watch), 5- (Skip it).");
        responseMap.put("dispute", "If you disagree with a rating, use the 'Modify' option to update the movie's score in your local list.");
    }

    private HashSet<String> getInput() {
        String inputLine = JOptionPane.showInputDialog(null, "Enter your issue:", "Input", JOptionPane.QUESTION_MESSAGE);

        HashSet<String> words = new HashSet<>();
        if (inputLine == null || inputLine.trim().isEmpty()) {
            return words;
        }

        String[] wordArray = inputLine.toLowerCase().trim().split("\\s+");
        for (String word : wordArray) {
            words.add(word);
        }
        return words;
    }

    private void giveResponse(HashSet<String> words) {
        boolean flag = false;
        StringBuilder d = new StringBuilder();

        for (String word : words) {
            String response = responseMap.get(word);
            if (response != null) {
                d.append(response).append("\n\n");
                flag = true;
            }
        }

        if (flag) {
            JOptionPane.showMessageDialog(null, d.toString(), "Support Response", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Oops, that's an unknown error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}