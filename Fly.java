package flypack;

public class Fly {

  public static void main(String[] args) {
    double i = 5;
    double j = 2;
    double k = max(i,j);
    System.out.println("The maximum between " + i +
        " and " + j + " is " + k );
  }

  public static double max(double num1, double num2) {
    double result;

    if (num1 > num2)
      result = num1;
    else
      result = num2;

    return result;
  }

}
