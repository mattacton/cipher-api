package com.geekcoders.cipherapi.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Before;
import org.junit.Test;

/**
 * Base64ControllerTest
 */
public class Base64ControllerTests {
    private Base64Controller controller;

    @Before
    public void setUp() {
        controller = new Base64Controller();
    }

    @Test
    public void base64Encode() {
        Encoder encoder = Base64.getUrlEncoder();
        assertThat(controller.encode("test hello there"),
                is(new String(encoder.encode("test hello there".getBytes()))));
    }

    @Test
    public void base64Decode() {
        Decoder decoder = Base64.getUrlDecoder();
        assertThat(controller.decode("aGVsbG8gdGhlcmU="), is(new String(decoder.decode("aGVsbG8gdGhlcmU="))));
    }
}