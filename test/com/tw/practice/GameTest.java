package com.tw.practice;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Mock
    private NumberGenerator mockedGenerator = Mockito.mock(NumberGenerator.class);

    @Mock
    private Printer mockedPrinter = Mockito.mock(Printer.class);

    @Mock
    private NumberReader mockedReader = Mockito.mock(NumberReader.class);

    @Test
    public void shouldReturn4A0BWhenInputSameNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1234");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("you win");
    }

    @Test
    public void shouldReturn0A4BWhenInputSameDigit() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()) .thenReturn("4321");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(0)).print("you win");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A4B");
    }

    @Test
    public void shouldReturn0A0BWhenInputSameDigit() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()) .thenReturn("5678");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(0)).print("you win");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("0A0B");
    }

    @Test
    public void shouldReturn2A2BWhenInputSameDigit() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()) .thenReturn("1243");
        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);
        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(0)).print("you win");
        Mockito.verify(mockedPrinter, Mockito.times(6)).print("2A2B");
    }

}