package impl.encoder;

import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.immutable.*;

import java.util.Optional;

class Visitor implements IElementVisitor
{
	public void process(IElement element)
	{
		element.accept(this);
		visitSubItems(element);
	}

	@Override
	public void visit(ITable table)
	{
		table.columns();
	}

	@Override
	public void visit(ITableRow row)
	{
		row.style();
	}

	@Override
	public void visit(IList list)
	{
		list.style();
	}

	@Override
	public void visit(IText text)
	{
		text.style();
		text.style();
	}

	@Override
	public void visit(IToggleButton button)
	{
		button.state();
	}

	private void visitSubItems(IElement element)
	{
		Optional.ofNullable(element.subElements()).ifPresent(
				(iterable)->iterable.forEach(
						(item)->item.accept(this)
				)
		);
	}
}
