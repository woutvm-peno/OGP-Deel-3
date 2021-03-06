package hillbillies.model.statement;

import hillbillies.model.exceptions.TaskInterruptionException;
import hillbillies.model.exceptions.WorldException;
import hillbillies.model.exceptions.WrongVariableException;
import hillbillies.model.expressions.IPositionExpression;
import hillbillies.model.task.ContextWrapper;
import hillbillies.model.util.Position;

public class WorkStatement<T extends IPositionExpression> extends ActionStatement{
	
	private T positionExpression;
	
	public WorkStatement(T pos) throws WorldException{
		if (pos==null){
			throw new WorldException();
		}
		this.positionExpression = pos;
	}
	
	@Override
	public Boolean executeNext(ContextWrapper c) throws WorldException, WrongVariableException {
		try{
		Position pos = positionExpression.evaluatePosition(c);
		c.getExecutingUnit().workAt(pos.getCubexpos(), pos.getCubeypos(), pos.getCubezpos());
		this.setExecuted(true);
		} catch (TaskInterruptionException t){
			c.getExecutingUnit().interrupt();
		}
		return true;
	}


	@Override
	public IPositionExpression[] getExpressions() {
		return new IPositionExpression[]{positionExpression};

	}

	@Override
	public Statement copy() throws WorldException {
		return new WorkStatement<T>(this.positionExpression);
	}
	
	
}
