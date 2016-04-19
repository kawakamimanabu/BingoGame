package com.foo.training.bingo.test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.foo.training.bingo.player.Player;
import com.foo.training.bingo.test.base.BaseBingoPlayerTest;
import com.foo.training.bingo.test.data.VerticalBingoTestValue;

/**
 * BaseBingoPlayer のテストクラス
 * @author
 *
 */
@RunWith(Theories.class)
public class BingoPlayerVBingoTest extends BaseBingoPlayerTest {

	@DataPoints
	public static String[][][] VBVALUES = {
			VerticalBingoTestValue.getCard1(),
			VerticalBingoTestValue.getCard2(),
			VerticalBingoTestValue.getCard3(),
			VerticalBingoTestValue.getCard4(),
			VerticalBingoTestValue.getCard5()
			};

	/**
	 * 垂直でBingoの場合に正しく叫ぶか否かをテストします。
	 */
	@Theory
	public void testVerticalBingoValues(String[][] vbvalue) {
		Player player = new Player("test", vbvalue);
		player.judgeBingo(testBallValue);
		assertThat(consoleOut.toString(), is(bingoShout));
	}

}