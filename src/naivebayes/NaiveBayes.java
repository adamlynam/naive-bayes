/*
 * Main.java
 *
 * Created on 31 May 2005, 13:13
 */

package naivebayes;

/**
 *
 * @author Mad_Fool
 */
public class NaiveBayes
{
    /** Creates a new instance of NaiveBayes */
    public NaiveBayes()
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        double totalTruePlay = 9.0;
        double totalFalsePlay = 5.0;
        
        Variable outlookSunny = new Variable();
        outlookSunny.playTrue = 2.0 / totalTruePlay;
        outlookSunny.playFalse = 3.0 / totalFalsePlay;
        Variable outlookOvercast = new Variable();
        outlookOvercast.playTrue = 4.0 / totalTruePlay;
        outlookOvercast.playFalse = 0.0 / totalFalsePlay;
        Variable outlookRainy = new Variable();
        outlookRainy.playTrue = 3.0 / totalTruePlay;
        outlookRainy.playFalse = 2.0 / totalFalsePlay;
        
        Effect outlook = new Effect();
        outlook.variables.add(outlookSunny);
        outlook.variables.add(outlookOvercast);
        outlook.variables.add(outlookRainy);
        
        
        Variable temperatureHot = new Variable();
        temperatureHot.playTrue = 2.0 / totalTruePlay;
        temperatureHot.playFalse = 2.0 / totalFalsePlay;
        Variable temperatureMild = new Variable();
        temperatureMild.playTrue = 4.0 / totalTruePlay;
        temperatureMild.playFalse = 2.0 / totalFalsePlay;
        Variable temperatureCool = new Variable();
        temperatureCool.playTrue = 3.0 / totalTruePlay;
        temperatureCool.playFalse = 1.0 / totalFalsePlay;
        
        Effect temperature = new Effect();
        temperature.variables.add(temperatureHot);
        temperature.variables.add(temperatureMild);
        temperature.variables.add(temperatureCool);
        
        
        Variable humidityHigh = new Variable();
        humidityHigh.playTrue = 3.0 / totalTruePlay;
        humidityHigh.playFalse = 4.0 / totalFalsePlay;
        Variable humidityNormal = new Variable();
        humidityNormal.playTrue = 6.0 / totalTruePlay;
        humidityNormal.playFalse = 1.0 / totalFalsePlay;
        
        Effect humidity = new Effect();
        humidity.variables.add(humidityHigh);
        humidity.variables.add(humidityNormal);
        
        
        Variable windyTrue = new Variable();
        windyTrue.playTrue = 3.0 / totalTruePlay;
        windyTrue.playFalse = 3.0 / totalFalsePlay;
        Variable windyFalse = new Variable();
        windyFalse.playTrue = 6.0 / totalTruePlay;
        windyFalse.playFalse = 2.0 / totalFalsePlay;
        
        Effect windy = new Effect();
        windy.variables.add(windyTrue);
        windy.variables.add(windyFalse);
        
        /*if sunny, cool, high, true came in, would we play?
        Variable outlookVariable = (Variable)outlook.variables.get(0);
        Variable temperatureVariable = (Variable)temperature.variables.get(2);
        Variable humidityVariable = (Variable)humidity.variables.get(0);
        Variable windyVariable = (Variable)windy.variables.get(0);*/
        
        /*if rainy, cool, high, false came in, would we play?
        Variable outlookVariable = (Variable)outlook.variables.get(2);
        Variable temperatureVariable = (Variable)temperature.variables.get(2);
        Variable humidityVariable = (Variable)humidity.variables.get(0);
        Variable windyVariable = (Variable)windy.variables.get(1);*/
        
        //if overcast, cool, high, true came in, would we play?
        Variable outlookVariable = (Variable)outlook.variables.get(1);
        Variable temperatureVariable = (Variable)temperature.variables.get(2);
        Variable humidityVariable = (Variable)humidity.variables.get(0);
        Variable windyVariable = (Variable)windy.variables.get(1);
        
        double trueValue = totalTruePlay / 14 * outlookVariable.playTrue * temperatureVariable.playTrue * humidityVariable.playTrue * windyVariable.playTrue;
        double falseValue = totalFalsePlay /14 * outlookVariable.playFalse * temperatureVariable.playFalse * humidityVariable.playFalse * windyVariable.playFalse;
        
        System.out.println("Chance of playing : " + trueValue);
        System.out.println("Chance of not playing : " + falseValue);
        
        if (trueValue > falseValue)
        {
            System.out.println("In this case we would play");
        }
        else
        {
            System.out.println("In this case we would not play");
        }
    }
    
}