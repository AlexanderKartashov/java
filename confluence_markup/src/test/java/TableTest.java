import com.google.java.contract.PreconditionError;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

	@Test(expected = PreconditionError.class)
	public void testContract()
	{
		new Table(null);
	}

}