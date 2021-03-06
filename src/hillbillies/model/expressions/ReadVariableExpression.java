package hillbillies.model.expressions;

import hillbillies.model.exceptions.WorldException;
import hillbillies.model.exceptions.WrongVariableException;
import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.task.ContextWrapper;
import hillbillies.model.util.Position;

public class ReadVariableExpression extends Expression<Object> implements IBooleanExpression,IPositionExpression,IUnitExpression{

	private final String variable;
	
	public ReadVariableExpression(String variableName) throws WorldException{
		if (variableName==null){
			throw new WorldException();
		}
		this.variable = variableName;
	}
	
	

	@Override
	public Unit evaluateUnit(ContextWrapper c) throws WorldException, WrongVariableException {
		if (c.returnVariable(variable) instanceof Unit){
			return (Unit) c.returnVariable(variable);
		}
		throw new WrongVariableException();
	}
	
	@Override
	public Boolean evaluateBoolean(ContextWrapper c) throws WorldException, WrongVariableException {
		if (c.returnVariable(variable) instanceof Boolean){
			return (Boolean) c.returnVariable(variable);
		}
		throw new WrongVariableException();
	}
	
	@Override
	public Position evaluatePosition(ContextWrapper c) throws WorldException, WrongVariableException {
		if (c.returnVariable(variable) instanceof Position){
			return (Position) c.returnVariable(variable);
		}		
		throw new WrongVariableException();
	}

	public String getVariableName(){
		return this.variable;
	}

}
