import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {
    public void action() {
        TestLoggingInterface TestLogging = createTestLogging();
        TestLogging.calculation(6);
    }

    private TestLoggingInterface createTestLogging(){
        InvocationHandler handler = new MyInvocationHandler(new TestLoggingImpl());
        return (TestLoggingInterface) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }
}
