package hillbillies.model.expressions;

import hillbillies.model.ContextWrapper;
import hillbillies.model.Position;
import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.statement.WrongVariableException;
import hillbillies.model.world.WorldException;

public class PositionOfExpression<T extends IUnitExpression> extends PositionExpression{
	
	private final T unit;
	
	public PositionOfExpression(T unit) throws WorldException{
		if (unit==null){
			throw new WorldException();
		}
		this.unit = unit;
		
	}
	@Override
	public Position evaluatePosition(ContextWrapper c) throws WorldException, WrongVariableException {
		Unit myUnit = this.unit.evaluateUnit(c);
		return new Position(myUnit.getxpos(), myUnit.getypos(), myUnit.getzpos(), c.getThisWorld());
	}
	
	
	@Override
	public IUnitExpression[] getExpressions() {
		return new IUnitExpression[]{unit};
	}


}
