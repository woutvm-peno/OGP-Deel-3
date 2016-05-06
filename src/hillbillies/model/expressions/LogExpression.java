package hillbillies.model.expressions;

import java.util.Set;
import java.util.function.Predicate;

import hillbillies.model.Dijkstra;
import hillbillies.model.Position;
import hillbillies.model.hillbilliesobject.Log;
import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.world.Cube;
import hillbillies.model.world.World;
import hillbillies.model.world.WorldException;

public class LogExpression extends PositionExpression{
	//ADRIAAN
	
	@Override
	public Position evaluate(World world, Unit unit, Position selectedCube) throws WorldException {
		Predicate<Cube> myPredicate = new Predicate<Cube>(){

			@Override
			public boolean test(Cube t) {
				if (t.containsLog()){
					return true;
				}
				return false;
			}
			
		};
		Dijkstra dijkstra = new Dijkstra(myPredicate, unit);
		Position pos = dijkstra.findClosestPosition();
		return pos;
	}
	

	@Override
	public Boolean containsSelected() {

		return false;
	}

	

}
