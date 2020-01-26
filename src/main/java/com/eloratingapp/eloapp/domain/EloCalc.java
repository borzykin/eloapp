package com.eloratingapp.eloapp.domain;

import java.text.DecimalFormat;

public class EloCalc {
    // todo this is simplified version of calculator, dynamic development coefficient to be added
    // todo rating difference > 400 points is treated as 400

    public static double winnerRating(double a, double b) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(a + 20 * (1 - chance(a, b))));
    }

    public static double loserRating(double a, double b) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(a + 20 * (0 - chance(a, b))));
    }

    private static double chance(double a, double b) {
        return 1.0 / (1.0 + Math.pow(10, ((b - a) / 400)));
    }
}
