package com.mwl.util;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.mwl.util.TextParser.parser;
import static org.junit.Assert.*;

public class TextParserTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void parserAcceptanceTestMoveNorth() {
        String input = "MovE nOrth";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"move", "North"};
        String[] actual = parser();
        assertEquals(expected, actual);
    }

}