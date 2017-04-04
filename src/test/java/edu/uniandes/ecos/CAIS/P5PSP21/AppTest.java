package edu.uniandes.ecos.CAIS.P5PSP21;

import edu.uniandes.ecos.CAIS.P5PSP21.controller.Program;
import edu.uniandes.ecos.CAIS.P5PSP21.model.Function;
import edu.uniandes.ecos.CAIS.P5PSP21.model.Gamma;
import edu.uniandes.ecos.CAIS.P5PSP21.model.TDistribution;
import java.io.File;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testContentIsValid() {

        Program program5 = new Program();

        assertTrue(program5.checkContentIsValid("4"));
        assertTrue(program5.checkContentIsValid("0.4"));
        assertTrue(program5.checkContentIsValid("5.2"));
        assertFalse(program5.checkContentIsValid("a"));

    }

    public void testFileExist() {
        Program program5 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        File file = new File(path + "/TestCases");
        assertTrue(program5.checkFileExist(file));
        File file2 = new File(path + "/TestCases2");
        assertFalse(program5.checkFileExist(file2));
    }

    public void testCalculateP() {
        Function function = new Function(1.1, 9);
        function.calculateP();

        assertEquals("P debe ser 0.35005864", 0.35005864, function.getP(), 0.00001);
    }

    public void testCalculateGamma() {
        Gamma gamma = new Gamma();
        assertEquals("El valor de la funcion Gamma de 5 debe ser 24 ", 24, gamma.gamma(5), 0.00001);
        assertEquals("El valor de la funcion Gamma de 9/2 debe ser 11.63173 ", 11.63173, gamma.gamma(4.5), 0.00001);
    }

    public void testCalculateDistribution() {
        TDistribution distribution = new TDistribution();
        assertEquals("El valor de la funcion de Distribucion T debe ser 0.388035", 0.388035, distribution.calculateDistribution(9, 0), 0.00001);
    }
}
