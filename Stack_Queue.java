import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class Stack_Queue
{
    public static void main(String[] args) {

       
        int[] arr=new int[]{3,4,2,6,5};

        Stack<Integer> stk=new Stack<>();

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<arr.length;i++)
        {
            while(!stk.isEmpty())
            {
                queue.add(stk.pop());
            }

            stk.push(arr[i]);

            while(!queue.isEmpty())
            {
                stk.push(queue.poll());
            }
        }

        int[] result=new int[arr.length];
        int k=0;
        while(!stk.isEmpty())
        {
            result[k]=stk.pop();
            k++;
        }
        
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+"\t");
        }

    }
}