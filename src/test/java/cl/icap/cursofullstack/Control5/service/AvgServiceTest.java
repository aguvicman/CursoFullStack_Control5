package cl.icap.cursofullstack.Control5.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AvgServiceTest {

	@Test
	void testComputeAvg() {
		AvgService avgService = new AvgService();
		assertEquals(6, avgService.computeAvg("5,6,7,3"));
	}
}
