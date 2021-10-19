package com.bridgelabz.fundoonotes.utils;

import java.sql.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.exception.FundoNotesException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenService {
	public static String key = "bridgelabz5";

	public String createToken(long id) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		JwtBuilder builder = Jwts.builder().setId(String.valueOf(id)).signWith(signatureAlgorithm,
				DatatypeConverter.parseString(key));
		return builder.compact();
	}

	public String createToken(long id, Date expireTime) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		JwtBuilder builder = Jwts.builder().setId(String.valueOf(id)).setExpiration(expireTime)
				.signWith(signatureAlgorithm, DatatypeConverter.parseString(key));
		return builder.compact();
	}

	public int decodeToken(String token) {
		try {
			Claims claim = Jwts.parser().setSigningKey(DatatypeConverter.parseString(key)).parseClaimsJws(token)
					.getBody();
			return Integer.parseInt(claim.getId());
		} catch (Exception e) {
			throw new FundoNotesException("105", "Error while decoding");
		}
	}

}
