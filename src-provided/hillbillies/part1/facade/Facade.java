package hillbillies.part1.facade;



import hillbillies.model.exceptions.IllegalNameException;
import hillbillies.model.exceptions.TaskInterruptionException;
import hillbillies.model.exceptions.UnitException;
import hillbillies.model.exceptions.WorldException;
import hillbillies.model.hillbilliesobject.CurrentState;
import hillbillies.model.hillbilliesobject.unit.Unit;
import ogp.framework.util.ModelException;



public class Facade implements IFacade{

	@Override
	public Unit createUnit(String name, int[] initialPosition, int weight, int agility, int strength, int toughness,
			boolean enableDefaultBehavior) throws ModelException {
		Unit unit;
		try {
			unit = new Unit((double)initialPosition[0], (double)initialPosition[1], (double)initialPosition[2], 
					name, weight, strength, agility, toughness, enableDefaultBehavior);
		} catch (IllegalNameException e) {
			System.out.println(e.value + " is an invalid name.");
			throw new ModelException();
		} catch (UnitException e){
			throw new ModelException();
		}
		
		return unit;
	}

	@Override
	public double[] getPosition(Unit unit) throws ModelException {
		double xpos = unit.getxpos();
		double ypos= unit.getypos();
		double zpos = unit.getzpos();
		double[] pos = {xpos,ypos,zpos};
		return pos;
	}

	@Override
	public int[] getCubeCoordinate(Unit unit) throws ModelException {
		int cubeX = (int)unit.getxpos();
		int cubeY = (int)unit.getypos();
		int cubeZ = (int)unit.getzpos();
		int[] pos = {cubeX,cubeY,cubeZ};
		return pos;
	}

	@Override
	public String getName(Unit unit) throws ModelException {
		return unit.getName();
	}

	@Override
	public void setName(Unit unit, String newName) throws ModelException {
		try {
			unit.setName(newName);
		} catch (IllegalNameException e) {
			System.out.println(e.value + " is an invalid name.");
			throw new ModelException();
		}
		
	}

	@Override
	public int getWeight(Unit unit) throws ModelException {
		return unit.getWeight();
	}

	@Override
	public void setWeight(Unit unit, int newValue) throws ModelException {
		unit.setWeight(newValue);
		
	}

	@Override
	public int getStrength(Unit unit) throws ModelException {
		return unit.getStrength();
	}

	@Override
	public void setStrength(Unit unit, int newValue) throws ModelException {
		unit.setStrength(newValue);
		
	}

	@Override
	public int getAgility(Unit unit) throws ModelException {
		return unit.getAgility();
	}

	@Override
	public void setAgility(Unit unit, int newValue) throws ModelException {
		unit.setAgility(newValue);
		
	}

	@Override
	public int getToughness(Unit unit) throws ModelException {
		return unit.getToughness();
	}

	@Override
	public void setToughness(Unit unit, int newValue) throws ModelException {
		unit.setToughness(newValue);
		
	}

	@Override
	public int getMaxHitPoints(Unit unit) throws ModelException {
		return unit.getMaxHP();
	}

	@Override
	public int getCurrentHitPoints(Unit unit) throws ModelException {
		return unit.getCurrentHP();
	}

	@Override
	public int getMaxStaminaPoints(Unit unit) throws ModelException {
		return unit.getMaxSP();
	}

	@Override
	public int getCurrentStaminaPoints(Unit unit) throws ModelException {
		return unit.getCurrentSP();
	}

	@Override
	public void advanceTime(Unit unit, double dt) throws ModelException {
		try {
			unit.advanceTime(dt);
		} catch (WorldException e) {
			throw new ModelException();
		}
	}

	@Override
	public void moveToAdjacent(Unit unit, int dx, int dy, int dz) throws ModelException {
		try {
			unit.moveToAdjacent(dx, dy, dz);
		} catch (UnitException e) {
			throw new ModelException();
		}
	}

	@Override
	public double getCurrentSpeed(Unit unit) throws ModelException {
		return unit.getSpeed();
	}

	@Override
	public boolean isMoving(Unit unit) throws ModelException {
		return (unit.getMyState()==CurrentState.MOVING);
	}

	@Override
	public void startSprinting(Unit unit) throws ModelException {
		try {
			unit.setToggledSprint(true);
		} catch (UnitException e) {
			throw new ModelException();
		};
	}

	@Override
	public void stopSprinting(Unit unit) throws ModelException {
		try {
			unit.setToggledSprint(false);
		} catch (UnitException e) {
			throw new ModelException();
		}
	}

	@Override
	public boolean isSprinting(Unit unit) throws ModelException {
		return unit.getToggledSprint();
	}

	@Override
	public double getOrientation(Unit unit) throws ModelException {
		return unit.getOrientation();
	}

	@Override
	public void moveTo(Unit unit, int[] cube) throws ModelException {
		try {
			unit.moveTo(cube[0], cube[1], cube[2]);
		} catch (UnitException | TaskInterruptionException e) {
			throw new ModelException();

		}
	}

	@Override
	public void work(Unit unit) throws ModelException {
		try {
			unit.workAt(0,0,0);
		} catch (UnitException | TaskInterruptionException e) {
			throw new ModelException();
		}
	}

	@Override
	public boolean isWorking(Unit unit) throws ModelException {
		return unit.getMyState()==CurrentState.WORKING;
	}

	@Override
	public void fight(Unit attacker, Unit defender) throws ModelException {
		try {
			attacker.startAttacking(defender);
		} catch (UnitException | TaskInterruptionException e) {
			throw new ModelException();
		}
	}

	@Override
	public boolean isAttacking(Unit unit) throws ModelException {
		return unit.getMyState()==CurrentState.ATTACKING;
	}

	@Override
	public void rest(Unit unit) throws ModelException {
		try {
			unit.startResting();
		} catch (TaskInterruptionException e) {
			throw new ModelException();
		}
	}

	@Override
	public boolean isResting(Unit unit) throws ModelException {
		return unit.isResting();
	}

	@Override
	public void setDefaultBehaviorEnabled(Unit unit, boolean value) throws ModelException {
		unit.setDefaultBehaviourEnabled(value);
	}

	@Override
	public boolean isDefaultBehaviorEnabled(Unit unit) throws ModelException {
		return unit.getDefaultBehaviourEnabled();
	}

}