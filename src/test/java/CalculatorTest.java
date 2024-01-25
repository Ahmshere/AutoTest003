import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        Mockito.when(mockCalculator.add(3,7)).thenReturn(10); // Это инструкция! указали Mockito, что когда вызывается метод add с аргументами (3, 7), то он должен возвращать 10.
        Assert.assertEquals(mockCalculator.add(3,7), 10);

    }

    @Test
    public void calcTest_001(){
        Calculator calculator = new Calculator();
        Assert.assertFalse(calculator.isitTriangle(90, 90, 90), "Is it triangle or not?");
    }
    @Test
    public void whatTriangleIsThis(){
        Calculator calculator = new Calculator();
        Assert.assertEquals((calculator.getTriangleType(90, 40, 50)), TriangleType.SCALENE);
    }
    @Test
    public void calcTest(){
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        Mockito.when(mockCalculator.isitTriangle(90,45,45)).thenReturn(true); // Это инструкция! указали Mockito, что когда вызывается метод add с аргументами (3, 7), то он должен возвращать 10.
        Mockito.when(mockCalculator.isitTriangle(90,0,0)).thenReturn(false);
        Assert.assertEquals(mockCalculator.isitTriangle(90,0,0), false);
    }

}
