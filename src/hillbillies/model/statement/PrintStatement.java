package hillbillies.model.statement;

import hillbillies.model.Position;
import hillbillies.model.expressions.Expression;
import hillbillies.model.hillbilliesobject.unit.Unit;
import hillbillies.model.world.World;
import hillbillies.model.world.WorldException;

public class PrintStatement extends Statement{
	//ADRIAAN
	@Override
	public Boolean execute(World world, Unit unit, Position selectedCube) throws WorldException {
		// TODO Auto-generated method stub
		System.out.println(stuffToPrint.evaluate(world, unit, selectedCube));
		return true;
	}

	@Override
	public Boolean containsSelected() {
		// TODO Auto-generated method stub
		return stuffToPrint.containsSelected();
	}
	private final Expression stuffToPrint;
	public PrintStatement(Expression value){
		
		this.stuffToPrint = value;
	}


}
