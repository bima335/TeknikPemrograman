public class TestShape {
    public static void main(String[] args) {
        System.out.println("UJI SHAPE");
        Shape s1 = new Shape();
        System.out.println(s1.toString());
        Shape s2 = new Shape("blue", false);
        System.out.println(s2.toString());

        System.out.println("\nUJI CIRCLE");
        Circle c1 = new Circle(5.0, "yellow", true);
        System.out.println(c1.toString());
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println("\nUJI RECTANGLE");
        Rectangle r1 = new Rectangle(2.0, 4.0, "purple", false);
        System.out.println(r1.toString());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());


        System.out.println("\nUJI SQUARE");
        Square sq1 = new Square(3.0, "black", true);
        System.out.println(sq1.toString());
        System.out.println("Area (3x3): " + sq1.getArea());

        System.out.println("\nMengubah sisi menjadi 5.0...");
        sq1.setSide(5.0);
        System.out.println("New Width: " + sq1.getWidth());
        System.out.println("New Length: " + sq1.getLength());
        System.out.println("New Area: " + sq1.getArea());
    }
}