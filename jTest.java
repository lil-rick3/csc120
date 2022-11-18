import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class jTest {

	@Test
	void testOG() {
		
		
		PatientQueue test1 = new PatientQueue();
		test1.enqueue("Anat", 4);
		test1.enqueue("Ben", 9);
		test1.enqueue("Sasha", 8);
		test1.enqueue("Wu", 7);
		test1.enqueue("Rein", 6);
		test1.enqueue("Ford", 2);
		test1.enqueue("Eve", 3);
		try {
			test1.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.changePriority("Eve", 10);
		String compareString = "{Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}";
		
		System.out.println(test1);
		assertTrue(test1.toString().equals(compareString));
		test1.clear();
		
		test1.enqueue("Anat", 4);
		test1.enqueue("Ben", 9);
		test1.enqueue("Sasha", 8);
		test1.enqueue(new Patient("Wu",7));
		test1.enqueue("Rein", 6);
		test1.enqueue("Ford", 2);
		test1.enqueue("Eve", 3);
		try {
			test1.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.changePriority("Eve", 10);
		assertTrue(test1.toString().equals(compareString));
	}
	
	@Test
	void testAlpha() {
		PatientQueue test = new PatientQueue();
		test.enqueue("Anat", 4);
		test.enqueue(new Patient("Ben", 4));
		test.enqueue("charlie", 1);
		test.enqueue("Zoey", 4);
		assertEquals(test.size(), 4);
		
		try {
			assertTrue(test.dequeue().equals("charlie"));
			assertTrue(test.dequeue().equals("Anat"));
			assertTrue(test.dequeue().equals("Ben"));
			assertTrue(test.dequeue().equals("Zoey"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	void testBravo() {
		PatientQueue test = new PatientQueue();
		assertTrue(test.isEmpty());
		test.enqueue("Anat", 4);
		test.enqueue(new Patient("Ben", 4));
		assertEquals(test.size(),2);
		test.clear();
		assertTrue(test.isEmpty());
		assertEquals(test.size(),0);
		test.enqueue("charlie", 1);
		test.enqueue("Zoey", 4);
		assertTrue(test.toString().equals("{charlie (1), Zoey (4)}"));
		try {
			assertTrue(test.dequeue().equals("charlie"));
			assertTrue(test.dequeue().equals("Zoey"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Test
	void testCharlie() {
		PatientQueue test1 = new PatientQueue();
		test1.enqueue("Anat", 4);
		test1.enqueue("", 7);
		test1.enqueue("Sasha", 8);
		test1.enqueue(new Patient("Wu",7));
		test1.enqueue("Rein", 6);
		test1.enqueue("Ford", 2);
		test1.enqueue("Eve", 3);
		
		
		try {
			assertEquals(test1.peek(), "Ford");
			assertEquals(test1.peekPriority(), 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(test1);
	}
	@Test
	void test4() {
		PatientQueue test1 = new PatientQueue();
		test1.enqueue("Anat", 4);
		test1.enqueue("", 7);
		test1.enqueue("Sasha", 8);
		test1.enqueue(new Patient("Wu",7));
		test1.enqueue("Rein", 6);
		test1.enqueue("Ford", 2);
		test1.enqueue("Eve", 3);
		
		System.out.println(test1);
		test1.changePriority("Ford", 5);
		System.out.println(test1);
		
	}

}
