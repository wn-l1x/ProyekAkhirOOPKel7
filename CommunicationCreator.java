
/**
 * Write a description of class CommunicationCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommunicationCreator extends CardCreator
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CommunicationCreator
     */
    public CommunicationCreator()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

    @Override
    public CardView createCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCard'");
    }
}
