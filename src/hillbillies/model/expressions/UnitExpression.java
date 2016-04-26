package hillbillies.model.expressions;

import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.world.World;
import hillbillies.model.world.WorldException;

public abstract class UnitExpression extends Expression {

	@Override
	public abstract Unit evaluate(World world, Unit unit) throws WorldException;
		
}