package hillbillies.model.expressions;

import java.util.ArrayList;

import hillbillies.model.ContextWrapper;
import hillbillies.model.Position;
import hillbillies.model.statement.WrongVariableException;
import hillbillies.model.world.WorldException;

public class LiteralPositionExpression extends PositionExpression {

	private int x;
	private int y;
	private int z;
	Position pos;
	@Override
	public Position evaluatePosition(ContextWrapper c) throws WorldException, WrongVariableException {
		// TODO Auto-generated method stub
		
		return new Position(this.x, this.y, this.z, c.getThisWorld());
	}

	@Override
	public Boolean containsSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Expression<?>> getExpressions() {
		// TODO Auto-generated method stub
		return new ArrayList<Expression<?>>();
	}
	
	public LiteralPositionExpression(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	

}
