package Quiz4;

public class Triangle {

    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws IllegalArgumentException{

        if ( !(side1 + side2 > side3 && side3 + side2 > side1 && side1 + side3 > side2) ){
            throw new IllegalArgumentException("Triangle Sides Are Not Valid");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IllegalArgumentException {

        if ( !(side1 + side2 > side3 && side3 + side2 > side1 && side1 + side3 > side2) ){
            throw new IllegalArgumentException("Triangle Sides Are Not Valid");
        }
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IllegalArgumentException{

        if ( !(side1 + side2 > side3 && side3 + side2 > side1 && side1 + side3 > side2) ){
            throw new IllegalArgumentException("Triangle Sides Are Not Valid");
        }
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IllegalArgumentException{

        if ( !(side1 + side2 > side3 && side3 + side2 > side1 && side1 + side3 > side2) ){
            throw new IllegalArgumentException("Triangle Sides Are Not Valid");
        }
        this.side3 = side3;
    }
}
