package com.codewithsameer.blog.payloads;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtAuthResponse implements Serializable {
	
	private  String token;
	
}
