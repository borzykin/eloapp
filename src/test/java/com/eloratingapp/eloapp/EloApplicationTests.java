package com.eloratingapp.eloapp;

import com.eloratingapp.eloapp.domain.EloCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EloApplicationTests {

    @Test
    void calcTest1() {
        // player A (score 2000) wins over player B (score 2000). Expected source: https://ratings.fide.com/calculator_rtd.phtml
        double newRating = EloCalc.winnerRating(2000, 2000);
        Assertions.assertEquals(2010, newRating, 0.25);
    }

    @Test
    void calcTest2() {
        // player A (score 1200) wins over player B (score 1000). Expected source: https://ratings.fide.com/calculator_rtd.phtml
        double newRating = EloCalc.winnerRating(1200, 1000);
        Assertions.assertEquals(1204.8, newRating, 0.25);
    }

    @Test
    void calcTest3() {
        // player A (score 1200) loses to player B (score 1000). Expected source: https://ratings.fide.com/calculator_rtd.phtml
        double newRating = EloCalc.loserRating(1200, 1000);
		Assertions.assertEquals(1184.8, newRating, 0.25);
    }

	@Test
	void calcTest4() {
		// player A (score 1000) loses to player B (score 1400). Expected source: https://ratings.fide.com/calculator_rtd.phtml
		double newRating = EloCalc.loserRating(1000, 1400);
		Assertions.assertEquals(998.4, newRating, 0.25);
	}

}
