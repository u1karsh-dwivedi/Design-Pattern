package com.scaler.lld.design.tictactoe;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.scaler.lld.design.tictactoe.factories.PlayerFactory;
import com.scaler.lld.design.tictactoe.models.BoardCell;
import com.scaler.lld.design.tictactoe.models.Game;
import com.scaler.lld.design.tictactoe.models.GameSymbol;
import com.scaler.lld.design.tictactoe.models.User;
import com.scaler.lld.design.tictactoe.strategies.DefaultPlayingStrategy;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = createGame();
    }

    private Game createGame() {

        Game game = Game.getBuilder()
                .withDimension(3, 3)
                .withPlayer(
                        PlayerFactory.getHumanPlayer()
                                .user(new User())
                                .symbol(GameSymbol.O)
                                .build())
                .withPlayer(
                        PlayerFactory.getBotPlayer()
                                .playingStrategy(new DefaultPlayingStrategy())
                                .symbol(GameSymbol.X)
                                .build())
                .build();

        return game;
    }

    @Test
    public void testDimensions() {
       
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());        

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of columns should be equal to input", 3, firstRow.size());        

    }
}
