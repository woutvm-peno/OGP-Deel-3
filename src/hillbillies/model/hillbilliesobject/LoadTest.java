package hillbillies.model.hillbilliesobject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hillbillies.model.NbCompare;
import hillbillies.model.Position;
import hillbillies.model.hillbilliesobject.unit.UnitException;
import hillbillies.model.world.World;
import hillbillies.model.world.WorldException;
import hillbillies.tests.util.PositionAsserts;

public class LoadTest {
	
	static int[][][] smallWorld = new int[3][3][3];
	NbCompare comp = new NbCompare();
	Position pos;
	World world;
	Load load;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		for (int x=0;x<3;x++){
			 for (int y=0;y<3;y++){
				 smallWorld[x][y][0] = 1;
				 smallWorld[x][y][1] = 0;
				 smallWorld[x][y][2] = 0;
			 }
		 }
		world = new World(smallWorld,null);
		pos = new Position(1,1,1,world);
		load = new Load(pos,world);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoublePosition() throws WorldException {
		PositionAsserts.assertDoublePositionEquals(1.5, 1.5, 1.5, load.getDoublePosition());

	}
	
	
	@Test
	public void testCorrectWeight() throws WorldException{
		for (int i=0;i<1000;i++){
			load = new Load(pos,world);
			assert (load.getWeight()>=10);
			assert (load.getWeight()<=50);
		}
	}
	
	@Test
	public void testAdvanceTime() throws WorldException{
		
		load.advanceTime(0.1);
		try{
			load.advanceTime(-0.1);
			fail();
		} catch (UnitException e){
			  //Great
		}
		try{
			load.advanceTime(0.3);
			fail();
		} catch (UnitException e){
			  //Great
		}
		try{
			load.advanceTime(0);
			fail();
		} catch (UnitException e){
			  //Great
		}
	}
	
	@Test
	public void testFallingMovesDown() throws WorldException{
		pos = new Position(0,0,2,world);
		load = new Load(pos,world);
		load.startFalling();
		while (!comp.equals(load.getDoublePosition()[2], 1.5)){
			double[] prevPos = load.getDoublePosition();
			load.advanceTime(0.05);
			PositionAsserts.assertPositionXEquals(load.getDoublePosition()[0], prevPos);
			PositionAsserts.assertPositionYEquals(load.getDoublePosition()[1], prevPos);
			assert (!comp.equals(load.getDoublePosition()[2], prevPos[2]));
		}
		load.advanceTime(0.1);
		assert (comp.equals(load.getDoublePosition()[2], 1.5));
	}
	
	@Test
	public void testParentCube() throws WorldException{
		pos = new Position(0,0,2,world);
		load = new Load(pos,world);
		load.startFalling();
		assert load.getParentCube()==world.getCube(0, 0, 2);
		while (!comp.equals(load.getDoublePosition()[2], 1.5)){
			if (load.getDoublePosition()[2]>=2){
				assert (load.getParentCube()==world.getCube(0, 0, 2));
			}
			else {
				assert (load.getParentCube()==world.getCube(0,0,1));
			}
			load.advanceTime(0.05);
		}
	}

}
