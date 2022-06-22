import java.util.Scanner;
class Sequence{
    static int calcSeq(int n){
        int sum=0,j=0;
        int[] arr = new int[n+1];
        for(int i=0;i<n+1;i++){
            j=i;
            while(j>0){
                arr[i] += i*(int)Math.pow(10,j-1) ;
                j--;
            }
            arr[i] = arr[i]*(int)Math.pow(-1,i+1);
        }
        for(int i=0;i<n+1;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.print("Ansh Nigam 20BCE0419.\n");
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n value: ");
        n = sc.nextInt();
        int val = calcSeq(n);
        System.out.print("Sum of sequence: "+val);
        sc.close();
    }
}