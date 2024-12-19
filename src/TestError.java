public class TestError extends Exception {
    public TestError(double currentValue, double expectedValue, String valueName){
        super("Current " + valueName + " = " + currentValue + " , but it must be " + expectedValue + " . Test was unsuccessful");
    }
}
