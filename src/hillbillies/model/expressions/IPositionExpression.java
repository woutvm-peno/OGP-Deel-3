package hillbillies.model.expressions;

import hillbillies.model.ContextWrapper;
import hillbillies.model.Position;
import hillbillies.model.TaskInterruptionException;
import hillbillies.model.statement.WrongVariableException;
import hillbillies.model.world.WorldException;

public interface IPositionExpression extends IExpression {
	
	public Position evaluatePosition(ContextWrapper c) throws WorldException, WrongVariableException;
}
