class Bank {
    static String[] name = new String[5];
    static int[] amt = new int[5];
    static int[] tran = new int[5];
    static void withdraw(int n){
        for(int i=0;i<n;i++){
            System.out.print("\n"+name[i]);
            if(tran[i] < -25000){
                System.out.print("\nFailed Transaction");
                System.out.print("\n"+amt[i]);
            }    
            else if(amt[i] < Math.abs(tran[i])){
                System.out.print("\nFailed Transaction");
                System.out.print("\n"+amt[i]);
            }
            else {
                if(tran[i] >= -500)
                    System.out.print("\n"+(amt[i] + tran[i] - 5));
                else if(tran[i] >= -1000)
                    System.out.print("\n"+(amt[i] + tran[i] - 8));
                else if(tran[i] < -1000 && tran[i] >= -5000)
                    System.out.print("\n"+(amt[i] + tran[i] - 10));
                else if(tran[i] < -5000 && tran[i] >= -15000)
                    System.out.print("\n"+(amt[i] + tran[i] - 12));
                else if(tran[i] < -15000 && tran[i] >= -25000)
                    System.out.print("\n"+(amt[i] + tran[i] - 15));
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Ansh Nigam 20BCE0419.");
        int n=args.length/3;
        for(int i=0;i<n;i++){
            name[i] = args[i*3];
            amt[i] = Integer.parseInt(args[(i*3) + 1]);
            tran[i] = Integer.parseInt(args[(i*3) + 2]);
        }
        withdraw(n);
    }
}