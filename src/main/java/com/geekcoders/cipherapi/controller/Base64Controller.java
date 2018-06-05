package com.geekcoders.cipherapi.controller;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base64Controller
 */
@RestController
@RequestMapping("/base64")
public class Base64Controller {
	private Encoder encoder = Base64.getUrlEncoder();
	private Decoder decoder = Base64.getUrlDecoder();

	@GetMapping(value="/encode/{text}")
	public String encode(@PathVariable(name="text",required=true) String string) {
		return new String(encoder.encode(string.getBytes()));
	}

	@GetMapping(value="/decode/{text}")
	public String decode(@PathVariable(name="text",required=true) String string) {
		return new String(decoder.decode(string));
	}
}