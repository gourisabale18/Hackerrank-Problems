class Server_Investment
{
    public static void main(String[] args)
    {
        int[] num_servers=new int[]{4,3};
        int[] money=new int[]{8,9};
        int[] sale=new int[]{4,2};
        int[] upgrade=new int[]{4,5};

        int[] server_to_upgrade=new int[num_servers.length];

        for(int i=0;i<num_servers.length;i++)
        {
            int no=num_servers[i];

            while(money[i]<no*upgrade[i])
            {
                no--;
                money[i]=money[i]*sale[i];
            }
            server_to_upgrade[i]=no;
        }

        for(int i=0;i<server_to_upgrade.length;i++)
        {
            System.out.println(server_to_upgrade[i]+"\t");
        }
    }
}