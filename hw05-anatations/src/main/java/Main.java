import calculator.CalculatorTest;
import ru.otus.anatations.AfterEach;
import ru.otus.anatations.BeforeEach;
import ru.otus.anatations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<CalculatorTest> calculatorTestClassObj = CalculatorTest.class;
        new Main().startTests(calculatorTestClassObj);
    }

    private void startTests(Class<CalculatorTest> calculatorTestClassObj) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<CalculatorTest> constructorForCalculatorTest = calculatorTestClassObj.getConstructor();
        CalculatorTest calculatorTestObj = constructorForCalculatorTest.newInstance();

        Method[] methodsOfCalculatorTestObj = calculatorTestClassObj.getDeclaredMethods();
        int before = 0, after = 0;


        for (int i = 0; i < methodsOfCalculatorTestObj.length; i++) {
            methodsOfCalculatorTestObj[i].setAccessible(true);
            if (methodsOfCalculatorTestObj[i].isAnnotationPresent(BeforeEach.class))
                before = i;
            else if (methodsOfCalculatorTestObj[i].isAnnotationPresent(AfterEach.class))
                after = i;
        }

        for (Method method : methodsOfCalculatorTestObj) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsOfCalculatorTestObj[before].invoke(calculatorTestObj);
                method.invoke(calculatorTestObj);
                methodsOfCalculatorTestObj[after].invoke(calculatorTestObj);
            }
        }
    }
}
