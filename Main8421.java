import java.util.Scanner;
interface Top {
    String[] arr = {"0101","0100","0000","1111","1000","1011","1001","0111","1010","0110"};
    class Nested{
        public static int[][] values = new int[10][2];
        static{
            for(int i=0;i<10;i++){
                int t =Integer.parseInt(arr[i]);
                values[i][0] = t;
                
                int temp,sum=0;
                temp = t%10;
                sum = -1*temp;
                temp = (t%100 - t%10)/10;
                sum = sum - 2*temp;
                temp = (t%1000 - t%100)/100;
                sum = sum + 4*temp;
                temp = (t - t%1000)/1000;
                sum = sum + 8*temp;
                
                values[i][1] = sum;
            }
        }
    }
}
class Class8421 implements Top{
    public static void convert(){
        Scanner sc = new Scanner(System.in);
        String s ;
        System.out.print("Enter number whose 84-2-1 code has to be calculated: ");
        s = sc.next();
        int[] num = new int[s.length()];
        for(int i=0;i<s.length();i++){
            num[i] = s.charAt(i) - '0';
        }
        String a = "";
        for(int i=0;i<num.length;i++){
            for(int j=0;j<10;j++){
                if(Nested.values[j][1] == num[i])
                a = a + arr[j] + " ";
            }
        }
        System.out.println("84-2-1 code is: "+a);
    }
}
class Complement9 extends Class8421{
    static Scanner sc = new Scanner(System.in);
    public static void findComplement(){
        System.out.print("Enter number in 84-2-1 format: ");
        String ip = sc.nextLine();
        String op = new String("");
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i) == '0')
            op += '1';
            else if(ip.charAt(i) == '1')
            op += '0';
            else if(ip.charAt(i) == ' ')
            op += ' ';
        }
        System.out.println("9's Complement: "+op);
    }
    public static void findValue(){
        System.out.print("Enter number in 84-2-1 format: ");
        String ip = sc.nextLine();
        String op = new String("");
        String[] input = ip.split(" ");
        for(int i=0;i<input.length;i++){
            for(int j=0;j<arr.length;j++){
                if(input[i].equals(arr[j]))
                op += Nested.values[j][1];
            }
        }
        System.out.println("Decimal equivalent of "+ip+" is: "+op);
    }
}
class Main8421 implements Top{
    public static void main(String[] args){
        System.out.println("Ansh Nigam 20BCE0419.");
        Class8421.convert();
        Complement9.findComplement();
        Complement9.findValue();
    }
}