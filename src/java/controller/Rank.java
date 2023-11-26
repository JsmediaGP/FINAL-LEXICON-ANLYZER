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


    public static String compareRanks(String sqlRank, String jsRank) {
        if ("high".equals(sqlRank) || "high".equals(jsRank)) {
            return "high";
        } else if (("medium".equals(sqlRank) && "low".equals(jsRank)) || ("low".equals(sqlRank) && "medium".equals(jsRank))) {
            return "medium";
        } else {
            return "low";
        }
    }
    
    public static String calculateOverallRanking(int lowRankThreshold, String... ranks) {
        int lowRankCount = 0;

        for (String rank : ranks) {
            if (rank.equals("low")) {
                lowRankCount++;
            }
        }

        if (lowRankCount >= lowRankThreshold) {
            return "low";
        } else {
            return "high";
        }
    }
    
    public static String calculateOverallRankingSQLJs(String... finalRanks) {
        if (Arrays.asList(finalRanks).contains("high")) {
            return "high";
        }

        if (Arrays.asList(finalRanks).contains("medium")) {
            return "medium";
        }

        return "low";
    }
}
