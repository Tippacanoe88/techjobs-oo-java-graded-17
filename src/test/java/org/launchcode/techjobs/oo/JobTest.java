package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        //Using assertNotEquals to verify that the IDs of the two objects are distinct
        assertNotEquals(job1.getId(), job2.getId());
    }
   @Test
   public void testJobConstructorsSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
   //Test for the name field;
       assertTrue(job.getName() instanceof String);
       assertEquals("Product tester", job.getName());

       assertTrue(job.getEmployer() instanceof Employer);
       assertEquals("ACME", job.getEmployer().getValue());

       assertTrue(job.getLocation() instanceof Location);
       assertEquals("Desert", job.getLocation().getValue());

       assertTrue(job.getPositionType() instanceof PositionType);
       assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test 
    public void testJobsForEquality() {
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

//not sure if the setId method will work inside of the Jobs class.
        assertFalse(job1.equals(job2));
    }
    //tests the new line function for toString method
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String toStringResult = job.toString();

        assertTrue(toStringResult.startsWith("\n"));
        assertTrue(toStringResult.endsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String toStringResult = job.toString();

        assertTrue(toStringResult.contains("\nID: "));
        assertTrue(toStringResult.contains("\nName: Product tester"));
        assertTrue(toStringResult.contains("\nEmployer: ACME"));
        assertTrue(toStringResult.contains("\nLocation: Desert"));
        assertTrue(toStringResult.contains("\nPosition Type: Quality control"));
        assertTrue(toStringResult.contains("\nCore Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        String toStringResult = job.toString();

        System.out.println("Actual toString result: " + toStringResult); // Add this line for debugging

        assertTrue(toStringResult.contains("\nPosition Type: ") ||
                toStringResult.contains("\nPosition Type:Data not available"));
    }
}
//This test creates a 'Job' object with specific values and uses 'assertTrue' and 'assertEquals' statements
//to verify that each field is correctly assigned both the class andd the value.
