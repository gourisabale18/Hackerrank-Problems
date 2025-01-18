import java.util.Queue;
import java.util.PriorityQueue;
class Video_Buffering
{

    //Test case
    //packets=[1,2,3,4,4,5]
    //ans -1
    public static void main(String[] args)
    {

        int[] packets=new int[]{1, 3, 2, 1, 2, 3, 3, 4};
        //ans should be 4
        int time=findRebufferingTime(2,packets);
        System.out.println("Rebuffered time is "+ time);
    }

    public static int findRebufferingTime(int arrivalRate, int[] packets)
    {
        int index=0; // traverse through the packets

        Queue<Integer> buffer=new PriorityQueue<>();

        int time=1;
        while(index<packets.length)
        {
            //at time process packets equal to arrival rate

            for(int i=0;i<arrivalRate && index<packets.length; i++,index++)
            {
                int packet=packets[index];
                if(packet > time) // cant play immediately, value greater than curr time , so put in buffer
                {
                    buffer.add(packet);
                }
            }

            //u have processed 2 packets now
            //chk if they can be played from buffer
            if(!buffer.isEmpty() && buffer.peek()==time)
            {
                buffer.poll(); // poll it and play
            }
            else if(index<packets.length && packets[index-arrivalRate]==time)
            {
                //chk if first packets in the arrived packets sequence is matching with time
                //play
            }
            else
            {
                //rebuffering packet is not avaiable for direct play or in buffer
                return time; 
            }
            time++;

        }


        return -1;
    }
}