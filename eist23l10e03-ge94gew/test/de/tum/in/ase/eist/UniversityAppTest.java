package de.tum.in.ase.eist;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversityAppTest {

	@Test
	void testButtonText() {
		UniversityApp app = new UniversityApp();
		String buttonText = app.getButtonText();
		assertEquals("EIST", buttonText, "getButtonText() should return EIST");
	}
}

