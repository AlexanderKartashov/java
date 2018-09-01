package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.ListStyle;
import interfaces.elements.TextStyle;
import interfaces.elements.ToggleButtonState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ElementFactoryTest
{
	private ElementFactory _factory;

	@BeforeEach
	void setUp()
	{
		_factory = new ElementFactory();
	}

	@Test
	void testCreateTable()
	{
		assertThrows(PreconditionError.class, ()->_factory.createTable(null));
		assertThrows(PreconditionError.class, ()->_factory.createTable(new IElement[]{}));
		assertThat(_factory.createTable(new IElement[]{ new IElement(){} }), notNullValue());
	}

	@Test
	void testCreateButton()
	{
		assertThrows(PreconditionError.class, ()->_factory.createButton(null));
		assertThat(_factory.createButton(ToggleButtonState.Red), notNullValue());
	}

	@Test
	void testCreateText()
	{
		assertThrows(PreconditionError.class, ()->_factory.createText(null, null));
		assertThrows(PreconditionError.class, ()->_factory.createText("", null));
		assertThrows(PreconditionError.class, ()->_factory.createText(null, TextStyle.Header));
		assertThat(_factory.createText("text", TextStyle.Header), notNullValue());
	}

	@Test
	void testCreateList()
	{
		assertThrows(PreconditionError.class, ()->_factory.createList(null));
		assertThat(_factory.createList(ListStyle.Numbers), notNullValue());
	}
}