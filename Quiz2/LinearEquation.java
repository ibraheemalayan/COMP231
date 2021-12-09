package Quiz2;

public class LinearEquation {

    private int a, b, c, d, e, f;
    private double x, y;

    public LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean isSolvable(){
        return (((a * d) - (b * c)) != 0);
    }

    public double getX() {
        return ( (double) (e*d - b*f)) / (a*d - b*c);
    }
    public double getY() {
        return ( (double) (a*f - e*c)) / (a*d - b*c);
    }
}
