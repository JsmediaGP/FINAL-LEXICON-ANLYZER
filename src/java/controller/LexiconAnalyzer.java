/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Js'Media
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexiconAnalyzer {
    
    private static final int SQL_HIGH_RANK_THRESHOLD = 3;
    private static final int JS_HIGH_RANK_THRESHOLD = 2;
    private static final int LOW_RANK_THRESHOLD = 1;
    private static final int JS_LOW_RANK_THRESHOLD = 1;  // Add this threshold for JavaScript

    public static String analyzeInjection(String input) {
        int sqlStatementCount = countMatches(input, getSqlInjectionPattern());

        if (sqlStatementCount >= SQL_HIGH_RANK_THRESHOLD) {
            return "high";
        } else if (sqlStatementCount > LOW_RANK_THRESHOLD && sqlStatementCount < SQL_HIGH_RANK_THRESHOLD) {
            return "medium";
        } else {
            return "low";
        }
    }

    public static String analyzeJavaScriptInjection(String input) {
        int jsStatementCount = countJavaScriptKeywords(input);

        if (jsStatementCount >= JS_HIGH_RANK_THRESHOLD) {
            return "high";
        } else if (jsStatementCount > JS_LOW_RANK_THRESHOLD && jsStatementCount < JS_HIGH_RANK_THRESHOLD) {
            return "medium";
        } else {
            return "low";
        }
    }

    private static int countMatches(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            if (!isPartOfLongerWord(input, matcher.start(), matcher.end())) {
                count++;
            }
        }
        return count;
    }

    private static int countJavaScriptKeywords(String input) {
        String[] jsKeywords = {"var", "let", "const", "function", "return", "alert", "prompt", "confirm", "eval", "document.write", "document.cookie"};

        int keywordCount = 0;
        for (String keyword : jsKeywords) {
            String keywordRegex = "\\b" + keyword + "\\b";
            Pattern pattern = Pattern.compile(keywordRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                keywordCount++;
            }
        }

        // Additional check for more complex variable declarations
        keywordCount += countVariableDeclarations(input);

        return keywordCount;
    }

    private static int countVariableDeclarations(String input) {
        String varDeclarationRegex = "\\b(?:var|let|const)\\s+\\w+\\s*=\\s*(?:\\S+\\s*)?;?";
        Pattern pattern = Pattern.compile(varDeclarationRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        int declarationCount = 0;
        while (matcher.find()) {
            declarationCount++;
        }

        return declarationCount;
    }

    private static boolean isPartOfLongerWord(String input, int start, int end) {
        return (start > 0 && Character.isLetterOrDigit(input.charAt(start - 1)))
                || (end < input.length() - 1 && Character.isLetterOrDigit(input.charAt(end)));
    }

    private static Pattern getSqlInjectionPattern() {
        return Pattern.compile("\\b(\\bSELECT\\b|\\b;\\b|\\bFROM\\b|\\bWHERE\\b|\\bSET\\b|\\bINSERT\\b|\\bUPDATE\\b|\\bDELETE\\b)\\b",
                Pattern.CASE_INSENSITIVE);
    }

    public static int getLowRankThreshold() {
        return LOW_RANK_THRESHOLD;
    }

    public static int getJsLowRankThreshold() {
        return JS_LOW_RANK_THRESHOLD;
    }
}

    
    

