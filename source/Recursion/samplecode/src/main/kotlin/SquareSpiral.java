public class SquareSpiral

{

    public static void main(String[] args)

    {

        TurtleSeward bob = new TurtleSeward();

        for(int i=0;i<360;i++)

        {

            bob.forward(i*1.25);

            bob.left(90.25);

        }

    }

}