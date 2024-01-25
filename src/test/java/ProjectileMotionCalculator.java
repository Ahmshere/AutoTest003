import java.math.BigDecimal;

public class ProjectileMotionCalculator {


    private static final double GRAVITY = 9.8; // Ускорение свободного падения на Земле в м/с²

    public BigDecimal calculateDistance(double initialVelocity, double launchAngle) {
        double launchAngleInRadians = Math.toRadians(launchAngle);
        double result = (Math.pow(initialVelocity, 2) * Math.sin(2 * launchAngleInRadians)) / GRAVITY;
        return BigDecimal.valueOf(result);
    }

    public BigDecimal calculateTimeOfFlight(double initialVelocity, double launchAngle) {
        double launchAngleInRadians = Math.toRadians(launchAngle);
        double result = (2 * initialVelocity * Math.sin(launchAngleInRadians)) / GRAVITY;
        return BigDecimal.valueOf(result);
    }

    public static void main(String[] args) {
        ProjectileMotionCalculator calculator = new ProjectileMotionCalculator();

        // Пример использования функций с начальной скоростью 20 м/с и углом 90 градусов
        BigDecimal distance = calculator.calculateDistance(120, 90);
        BigDecimal timeOfFlight = calculator.calculateTimeOfFlight(120, 90);

        System.out.println("Дистанция: " + distance + " метров");
        System.out.println("Время полета: " + timeOfFlight + " секунд");
    }
}
