package impl.element;

import com.google.java.contract.PreconditionError;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TextTest
{
	@Test
	@ParameterizedTest
	@MethodSource("invalidStrings")
	public void testConstructorContracts(String param)
	{
		assertThrows(PreconditionError.class, ()-> new Text(param));
	}

	private static Stream<String> invalidStrings()
	{
		return Stream.of(null, "");
	}

	@Test
	public void testConstructor()
	{
		new Text("text");
	}
}