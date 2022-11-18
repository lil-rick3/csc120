import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientQueueTest {

	@Test
	void testEnqueue() throws Exception {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Ben", 9));
		assertEquals("Ben",queue.peek());
		queue.enqueue("Sasha", 8);
		assertEquals("Sasha",queue.peek());
		queue.enqueue("Anat", 4);
		assertEquals("Anat",queue.peek());
		queue.enqueue("Wu", 7);
		queue.enqueue(new Patient("Rein", 6));
		assertEquals("Anat",queue.peek());
		queue.enqueue(new Patient("Ford", 2));
		assertEquals("Ford",queue.peek());
	}

	@Test
	void testDequeue() throws Exception {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue("Ben", 9);
		queue.enqueue(new Patient("Sasha", 8));
		queue.enqueue("Wu", 7);
		queue.enqueue("Rein", 6);
		queue.enqueue(new Patient("Ford", 2));
		assertEquals("Ford",queue.dequeue());
		assertEquals("Anat",queue.dequeue());
		assertEquals("Rein",queue.dequeue());
		assertEquals("Wu",queue.dequeue());
		assertEquals("Sasha",queue.dequeue());
		assertEquals("Ben",queue.dequeue());
	}

	@Test
	void testChangePriority() throws Exception {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue("Ben", 9);
		queue.enqueue(new Patient("Sasha", 8));
		queue.enqueue("Wu", 7);
		queue.enqueue("Rein", 6);
		queue.enqueue(new Patient("Ford", 2));
		assertEquals(queue.peek(),"Ford");
		queue.changePriority("Ford", 10);
		assertEquals(queue.peek(),"Anat");
		assertEquals(queue.peekPriority(),4);
		queue.changePriority("Sasha", 3);
		queue.changePriority("Wu", 1);
		assertEquals(queue.peek(),"Wu");
		assertEquals(queue.peekPriority(),1);
	}

	@Test
	void testIsEmptyAndSize() throws Exception {
		PatientQueue queue = new PatientQueue();
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue(new Patient("Ben", 9));
		assertFalse(queue.isEmpty());
		assertEquals(queue.size(), 2);
		queue.dequeue();
		assertEquals(queue.size(), 1);
		queue.dequeue();
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
	}

	@Test
	void testToString() {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue("Ben", 9);
		queue.enqueue(new Patient("Sasha", 8));
		queue.enqueue("Wu", 7);
		queue.enqueue("Rein", 6);
		queue.enqueue(new Patient("Eve", 10));
		String compareString = "{Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}";
		assertEquals(queue.toString(), compareString);
	}
	
	@Test
	void testResizing() {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue("Ben", 9);
		queue.enqueue(new Patient("Sasha", 8));
		queue.enqueue("Wu", 7);
		queue.enqueue("Rein", 6);
		queue.enqueue(new Patient("Eve", 10));
		queue.enqueue(new Patient("Raja", 8));
		queue.enqueue("Walt", 7);
		queue.enqueue("Ryin", 6);
		assertEquals(queue.size(), 9);
		queue.enqueue(new Patient("Bill", 8));
		assertEquals(queue.size(), 10);
		queue.enqueue(new Patient("Jill", 12));
		assertEquals(queue.size(), 11);
	}
	
	@Test
	void testSameNamesAndPriorities() throws Exception {
		PatientQueue queue = new PatientQueue();
		queue.enqueue(new Patient("Anat", 4));
		queue.enqueue("Ben", 9);
		queue.enqueue(new Patient("Sasha", 8));
		queue.enqueue("Wu", 7);
		queue.enqueue("Rein", 6);
		queue.enqueue(new Patient("Eve", 10));
		String compareString = "{Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}";
		assertEquals(queue.toString(), compareString);
		queue.enqueue("Ryin", 6);
		queue.dequeue();
		assertEquals(queue.peek(), "Rein");
		queue.enqueue("Rain", 6);
		assertEquals(queue.peek(), "Rain");
		queue.enqueue("Ryin", 3);
		assertEquals(queue.peek(), "Ryin");
		queue.changePriority("Ryin", 10);
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.peek(), "Ryin");
	}

}
