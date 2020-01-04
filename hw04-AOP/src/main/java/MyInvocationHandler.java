import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private final TestLoggingInterface TestLogging;

    MyInvocationHandler(TestLoggingInterface TestLogging) {
        this.TestLogging = TestLogging;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("executed method: " + method.getName()+", param: "+args[0]);
        return method.invoke(TestLogging, args);
    }
}
