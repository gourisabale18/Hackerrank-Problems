//ROund robin Load balancing

//https://aonecode.com/aplusplus/interviewctrl/getInterview/5000207481723371739

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Round_Robin
{
   
   
    public static void main(String[] args)
    {
        int[] arrival=new int[]{2, 4, 1, 8, 9};
        int[] burst=new int[]{7, 9, 2, 4, 5};



        int n=3;

        PriorityQueue<Integer> freeServers=new PriorityQueue<>();

        for(int i=1;i<=n;i++)
        {
            freeServers.add(i); //min heap
        }

        Map<Integer,Integer> hmap=new HashMap<>();

        for(int i=0;i<arrival.length;i++)
        {
            hmap.put(arrival[i],burst[i]);
        }
        
        Arrays.sort(arrival);

        PriorityQueue<Server> busyServers=new PriorityQueue<>((a,b)->a.endtime!=b.endtime ? a.endtime-b.endtime:a.index-b.index);

        int[] result=new int[arrival.length];
        for(int i=0;i<arrival.length;i++)
        {
            int arrivaltime=arrival[i];
            int bursttime=hmap.get(arrivaltime);

            //chk if any of the previous requests is processed or not

            while(!busyServers.isEmpty() && busyServers.peek().endtime<=arrivaltime)
            {
                int serverIdx=busyServers.poll().index;
                freeServers.add(serverIdx);

            }

            //if free servers available, get first/min index server from them
            //make it busy by adding its end time and idx to q
            if(!freeServers.isEmpty())
            {
                int idx=freeServers.poll();
                int endT=arrivaltime+bursttime;
                busyServers.add(new Server(endT,idx));
                result[i]=idx;
            }
            else
            {
                result[i]=-1; //if no free server available
            }
        }

        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }

       
    } 
}
    class Server
    {
        int endtime;
        int index;

        public Server(int endtime,int index)
        {
            this.endtime=endtime;
            this.index=index;
        }
    }  