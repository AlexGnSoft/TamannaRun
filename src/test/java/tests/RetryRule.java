package tests;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {
    //Set counter - counter of failed tests
    private int retryCounter = 0;

    public RetryRule(int retryCounter) {
        this.retryCounter = retryCounter;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable error = null;
                for (int i = 0; i < retryCounter; i++) {
                    try{
                        base.evaluate();
                        return;
                    }catch (Throwable t){
                        error = t;
                        System.err.println(description.getDisplayName() + " was run " + (i+1) + " times ");
                    }
                }
                System.err.println(description.getDisplayName() + " test failed after the attempt " + retryCounter);
                throw error;
            }
        };
    }
}
