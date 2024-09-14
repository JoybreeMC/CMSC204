import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GradeBookTest {
	GradeBook gradeBook1;
	GradeBook gradeBook2;
	@BeforeEach
	public void setUp(){
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		gradeBook1.addScore(98.4);
		gradeBook1.addScore(78.6);
		gradeBook1.addScore(92.3);
		
		gradeBook2.addScore(54.5);
		gradeBook2.addScore(86.8);
		gradeBook2.addScore(23);
		gradeBook2.addScore(67.8);
	}
	
	@AfterEach
	public void tearDown() {
		gradeBook1 = null;
		gradeBook2 = null;
	}
	
	@Test
	public void testAddScore() {
		assertTrue("98.4 78.6 92.3 0.0 0.0 ".equals(gradeBook1.toString()));
		assertEquals(3,gradeBook1.getScoreSize());
		assertTrue("54.5 86.8 23.0 67.8 0.0 ".equals(gradeBook2.toString()));
		assertEquals(4,gradeBook2.getScoreSize());
	}
	@Test
	public void testSum() {
		assertEquals(269.3,gradeBook1.sum(),.001);
		assertEquals(232.1,gradeBook2.sum(),.001);
	}
	@Test
	public void testMinimum() {
		assertEquals(78.6,gradeBook1.minimum(),.001);
		assertEquals(23.0,gradeBook2.minimum(),.001);
	}
	@Test
	public void testFinalScore() {
		assertEquals(190.7,gradeBook1.finalScore(),.001);
		assertEquals(209.1,gradeBook2.finalScore(),.001);
	}
}
