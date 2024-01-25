public class Calculator {
    public int add(int a, int b){
        return a+b;
    }
    public int subtraction(int a, int b){
        return a-b;
    }
    public int multiplication(int a, int b){
        return a*b;
    }
    public int division(int a, int b){
        return a/b;
    }

    public boolean isitTriangle(int a, int b, int c) {
        // Проверка, что углы не отрицательны
        if (a > 0 && b > 0 && c > 0) {
            // Проверка, что сумма углов равна 180
            if (a + b + c == 180) {
                // Проверка, что каждый угол не превышает 180
                if (a < 180 && b < 180 && c < 180) {
                    // Дополнительные проверки по вашему усмотрению...
                    return true;  // Условия для треугольника выполнены
                }
            }
        }
        return false;  // Условия для треугольника не выполнены
    }
    public TriangleType getTriangleType(int a, int b, int c) {
        if (isValidTriangle(a,b,c)) {
            if (isEquilateral(a,b,c)) {
                return TriangleType.EQUILATERAL;  // Равносторонний треугольник
            } else if (isIsosceles(a,b,c)) {
                return TriangleType.ISOSCELES;    // Равнобедренный треугольник
            } else {
                return TriangleType.SCALENE;      // Разносторонний треугольник
            }
        } else {
            return TriangleType.INVALID;          // Недопустимый треугольник
        }
    }

    private boolean isValidTriangle(int a, int b, int c) {
        if (a > 0 && b > 0 && c > 0) {
            // Проверка, что сумма углов равна 180
            if (a + b + c == 180) {
                // Проверка, что каждый угол не превышает 180
                if (a < 180 && b < 180 && c < 180) {
                    // Дополнительные проверки по вашему усмотрению...
                    return true;  // Условия для треугольника выполнены
                }
            }
        }
        return false;  // Условия для тре
    }


    private boolean isEquilateral(int a, int b , int c) {
        // Все стороны равны
        return a == b && b == c;
    }

    private boolean isIsosceles(int a, int b , int c) {
        // Две стороны равны
        return a == b || b == c || a == c;
    }


}
