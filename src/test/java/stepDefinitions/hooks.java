package stepDefinitions;
import io.cucumber.java.After;
import TestComponents.TestContextSetup;

public class hooks {

    TestContextSetup testContextSetup;
    public hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;

    }

    @After
    public void closeApplication(){
        testContextSetup.baseTest.tearDown();
    }
}
