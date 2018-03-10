/**
 * #set{ $MyName = "Craig Mariani"}
 * #set{ $ThisClass = ".java"}
 * Created by Intelli J Idea.
 * User: $MyName
 * Date: 3/3/2018
 * Time: 1:43 PM
 * Contact: craigdacles.mariani@calbaptist.edu
 * $ThisClass was created for..
 */
import java.util.*;

public class Dice//use a sort method and frequency method to find out specifics
{
    Random rand = new Random();
    Scanner S = new Scanner(System.in);
    List<Integer> die = new ArrayList<Integer>();
    List<Integer>  combo = new ArrayList<Integer>();
    List<Integer> frequency = new ArrayList<Integer>();

    int addFrequency;
    int desiredNum = 1;
    int rollCount = 1;

    public void RollDice()//rolls dice for user
    {
        die.clear();
        System.out.println("The dice is rolled below");

            for(int i = 0; i < 5; i++) //roll five dice
            {
                die.add(rand.nextInt(6) + 1);//each die has numbers 1 to 6
            }

        System.out.println(die);
        System.out.println("Would you like to roll again?");
        String usrInput = S.next();

        if(rollCount < 3)
        {
            RecordRoll(die);
            rollCount++;
            RollDice();
        }
        else
        {
            RecordRoll(die);
        }
    }

    private void OrderRoll(List<Integer> dice)//will put the dice in order
    {
        Collections.sort(dice);
        System.out.println(dice);
    }


    private void RecordRoll(List<Integer> dice)//records the largest number of unique values
    {
        OrderRoll(dice);//sort the dice from smallest to largest
        GroupDice(dice);//will count the occurrence of each number group them together
    }

    private void GroupDice(List<Integer> dice)//sum up scores of largest unique combos
    {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();//counting, every time you count something increment the count by one
                                                                        //count the values in the arrayList by using the map
                                                                        //know which number the most of   //keep everything of that number
                                                                       //frequency is the value and the dice are the keys


        for(int i = 0; i < dice.size() ; i++)//should loop through array list and updates when contains key
            //if the new key is not contained then we must put it into the map and keep the frequency
            //add to the frequency if the value is already contained
            //the key is the number on the die and the value is the frequency
        {
            addFrequency = frequency.get(i);//the frequency is the spot in the arrayList it is re initialed each time
            if(i == 0 && dice.get(i) == dice.get(i+1))///preceding value after the chosen value equals chosen value
                                                        //need to find some way to check values inside of the map before adding one to a new frequency!
            {
                if(counter.containsKey(dice.get(i)))//if the key is already inside of the counter
                {
                    addFrequency = counter.get(dice.get(i)) + 1;//set the frequency to the stored key inside of the map and increment it
                    counter.put(dice.get(i), addFrequency);//puts the new key into the map with the added frequency
                }
                else
                {
                    addFrequency = addFrequency + 1;//adds one to the frequency
                    counter.put(dice.get(i), addFrequency);//puts the new key into the map with the added frequency
                }

            }

            if(i != 0 && dice.get(i) == dice.get(i - 1))//value before the chosen value equals the chosen value
            {
                if(counter.containsKey(dice.get(i)))//if the key is already inside of the counter
                {
                    addFrequency = counter.get(dice.get(i)) + 1;//set the frequency to the stored key inside of the map and increment it
                    counter.put(dice.get(i), addFrequency);//puts the new key into the map with the added frequency
                }

                else
                {
                    addFrequency = addFrequency + 1;//adds one to the frequency
                    counter.put(dice.get(i), addFrequency);//puts the new key into the map with the added frequency
                }

            }

            else
            {
                counter.put(dice.get(i), frequency.get(i));//add the dice number(key) and the occurrence(value) to the map
            }

        }
        System.out.println( "The current combinations are " + counter);//prints map


    }

    public static void main(String args[])
    {
        Dice dice = new Dice();
        dice.StartCombo();
        dice.InitializeFrequency();
        dice.RollDice();
    }

    public void StartCombo()
    {
        for(int i = 0; i < 5; i++)
        {
            combo.add(i);
        }
    }

    public void InitializeFrequency()
    {
        for(int i = 0; i < 5; i++)
        {
            frequency.add(1);
        }
    }
}
