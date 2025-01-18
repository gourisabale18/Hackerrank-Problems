// https://aonecode.com/Interview-Question/Tiktok-OA/Multi-Dimensional-Selection
public class Multi_Dimensional_Selection {

    public static void main(String[] args)
    {

        int[][] arr = {
            {1, 2},
            {3, 4},
            {8, 9}
    };
        int maxProduct=getMaxProduct(arr);
        System.out.println(maxProduct);

    }
    private static int getMaxProduct(int[][] arr)
    {

        int maxOfEachRow=Integer.MIN_VALUE;
        int minOfEachRow=Integer.MAX_VALUE;

        int max=Integer.MIN_VALUE; //max of minsOfEachRows
        int min=Integer.MAX_VALUE;//min of maxOFEachRows


        for(int i=0;i<arr.length;i++)
        {
            //reset for every roww
            maxOfEachRow=Integer.MIN_VALUE; //max of minsOfEachRows
            minOfEachRow=Integer.MAX_VALUE;
            for(int j=0;j<arr[0].length;j++)
            {
                maxOfEachRow=Math.max(maxOfEachRow, arr[i][j]);
                minOfEachRow=Math.min(minOfEachRow,arr[i][j]);
            }

            //overall max min
            max=Math.max(max,minOfEachRow);
            min=Math.min(min,maxOfEachRow);
           

        }

        System.out.println("max"+max);
        System.out.println("min"+min);



        int minCost=Math.abs(max-min);

        //col size + 2 (no which we selected as max and min) 
        int maxNoInOneSelection=arr[0].length+ 2;


        return minCost*maxNoInOneSelection;
    }

    
}
