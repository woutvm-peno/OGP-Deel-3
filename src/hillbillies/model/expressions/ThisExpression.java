package hillbillies.model.expressions;

import hillbillies.model.Position;
import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.world.World;
import hillbillies.model.world.WorldException;

public class ThisExpression extends UnitExpression{
	//ADRIAAN
	@Override
	public Unit evaluate(World world, Unit unit, Position selectedCube) throws WorldException {
		// TODO Auto-generated method stub
		return unit;
	}

	@Override
	public Boolean containsSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
