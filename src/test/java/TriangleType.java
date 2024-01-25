public enum TriangleType {
    EQUILATERAL("Equilateral"),  // Равносторонний треугольник
    ISOSCELES("Isosceles"),      // Равнобедренный треугольник
    SCALENE("Scalene"),          // Разносторонний треугольник
    INVALID("Invalid");          // Недопустимый треугольник

    private final String description;

    TriangleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
