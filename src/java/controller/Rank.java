/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Arrays;

/**
 *
 * @author Js'Media
 */
public class Rank {
    
    //this ranking is working to check the sql and javascript rank and then give the final rank for each field
    public static String compareRanks(String sqlRank, String jsRank) {
        if ("high".equals(sqlRank) || "high".equals(jsRank)) {
            return "high";
        } else if (("medium".equals(sqlRank) && "low".equals(jsRank)) || ("low".equals(sqlRank) && "medium".equals(jsRank))) {
            return "medium";
        } else {
            return "low";
        }
    }
    
    //this give overall ranking of sql and javascript
    public static String calculateOverallRanking(int lowRankThreshold, String... ranks) {
    // Count the number of low-ranking fields
            int lowRankCount = 0;

            for (String rank : ranks) {
                if (rank.equals("low")) {
                    lowRankCount++;
                }
            }

            // Calculate overall ranking
            if (lowRankCount >= lowRankThreshold) {
                return "low"; // Low overall ranking
            } else {
                return "high"; // High overall ranking
            }
    }
    
    //this for overall using final rank
    public static String calculateOverallRankingSQLJs(String... finalRanks) {
            // Check if there is at least one "high" rank
            if (Arrays.asList(finalRanks).contains("high")) {
                return "high";
            }

            // Check if there is at least one "medium" rank
            if (Arrays.asList(finalRanks).contains("medium")) {
                return "medium";
            }

            // All ranks are "low"
            return "low";
    }

    
}
