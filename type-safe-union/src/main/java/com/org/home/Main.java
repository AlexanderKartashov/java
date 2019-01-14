package com.org.home;

import com.pacoworks.sealedunions.Union3;
import com.pacoworks.sealedunions.generic.GenericUnions;

public class Main
{
	public static void main(String... args)
	{
		final var valid = GenericUnions.<Valid, Error, InvalidFormat>tripletFactory().first(new Valid("approved", 0));
		final var error = GenericUnions.<Valid, Error, InvalidFormat>tripletFactory().second(new Error(50));
		final var invalid =
				GenericUnions.<Valid, Error, InvalidFormat>tripletFactory().third(new InvalidFormat("No response"));

		System.out.println("Format:");
		System.out.println(format(valid));
		System.out.println(format(error));
		System.out.println(format(invalid));

		System.out.println();
		System.out.println("Handle value in lambdas:");
		handle(valid);
		handle(error);
		handle(invalid);
	}

	private static String format(Union3<Valid, Error, InvalidFormat> union)
	{
		return union.join(valid -> "response: " + valid.getResponse() + ", code: " + valid.getResponseCode(),
						  err -> "error: " + err.getCode(),
						  invalid -> "invalid response: " + invalid.getMessage());
	}

	private static void handle(Union3<Valid, Error, InvalidFormat> union)
	{
		union.continued(
				valid -> System.out.println("response code is " + valid.getResponseCode()),
				err -> {
				}, // for example, skip errors
				invalid -> System.out.println("invalid format error: " + invalid.getMessage())
		);
	}
}

class Valid
{
	private final String response;
	private final int responseCode;

	Valid(String response, int responseCode)
	{
		this.response = response;
		this.responseCode = responseCode;
	}

	public String getResponse()
	{
		return response;
	}

	public int getResponseCode()
	{
		return responseCode;
	}
}

class Error
{
	private final int code;

	Error(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}
}

class InvalidFormat
{
	private final String message;

	InvalidFormat(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}
}