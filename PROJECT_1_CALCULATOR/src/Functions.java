/*
Mani Makaremi
2/13/2018
class comp585
project Calculator
 */
public class Functions {
private double firstNumber;
private double secondNumber;
    public Functions(double firstNumber,double secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    public double add(){
        return firstNumber+secondNumber;
    }
    public double multiplication(){
        return firstNumber*secondNumber;
    }
    public double difference(){
        return firstNumber-secondNumber;
    }
    public double division(){
        return firstNumber/secondNumber;
    }
    public double mod(){

        return firstNumber % secondNumber;
    }
}
