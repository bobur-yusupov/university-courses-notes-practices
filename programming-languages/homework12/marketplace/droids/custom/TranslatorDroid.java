package marketplace.droids.custom;

import java.util.*;

import marketplace.droids.*;

public class TranslatorDroid extends Droid {
    public TranslatorDroid(List<DroidPart> parts) {
        super(parts);
    }

    public String translate(String s, String language) {
        if (getPowerLevel() < 5) {
            return "Not enough power.";
        }

        String translatedText;
        if ("huttese".equals(language)) {
            translatedText = shiftCharacters(s, 3);
        } else if ("binary".equals(language)) {
            translatedText = shiftCharacters(s, 1);
        } else {
            return "Unknown language";
        }
        reducePower(5);

        return translatedText;
    }

    private String shiftCharacters(String str, int shift) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append((char) (c + shift));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TranslatorDroid");
        String diagnostics = runDiagnostics();
        sb.append(diagnostics);
        sb.append("Power Level: " + this.getPowerLevel());
        sb.append("Languages: huttese, binary");
        return sb.toString();
    }
}