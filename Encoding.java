import java.util.Scanner;
class Encoding{
    private String inputtext;
    private String[] sa;
    private int[] ia;
    Encoding(String s){
        this.inputtext = s;
        sa = inputtext.split(" ");
    }
    Encoding(){
        inputtext = "";
    }
    static String[] sort(Encoding[] E){
        int n=0,st=0;
        String temp;
        for(int i=0;i<E.length;i++){
            n+=E[i].sa.length;
        }
        String[] arr = new String[n];
        // copying all sa to one string arrray.
        for(int i=0;i<E.length;i++){
            System.arraycopy(E[i].sa,0,arr,st,E[i].sa.length);
            st += E[i].sa.length;
        }
        // sorting arr.
        int min;
        for(int i=0;i<arr.length-1;i++){
            min = i;
            for(int j=i+1;j<arr.length;j++)
                if(arr[min].compareTo(arr[j]) > 0)
                min =j;
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        // removing repetition and transfering unique val to arr1.
        int j = 0;//for next element  
        for (int i=0; i < arr.length-1; i++){  
            if (!arr[i].equals(arr[i+1])){  
                arr[j++] = arr[i];  
            }  
        }  
        arr[j++] = arr[n-1];
        String[] arr1 = new String[j];
        System.arraycopy(arr,0,arr1,0,j);
        return arr1;
    }
    void encodeText(String[] arr){
        ia = new int[sa.length];
        System.out.print("\n[");
        for(int i=0;i<sa.length;i++){
            for(int j=0;j<arr.length;j++){
                if(sa[i].equals(arr[j]))
                ia[i] = j;
            }
            System.out.print(ia[i]+" ");
        }
        System.out.print("]");
    }
    void encodeText(String[] arr,int max){
        int k=0;
        ia = new int[max];
        for(int i=0;i<sa.length;i++){
            for(int j=0;j<arr.length;j++){
                if(sa[i].equals(arr[j]))
                ia[i] = j;
            }
            k=i;
        }
        k+=1;
        while(k < max){
            ia[k] = -1;
            k++;
        }
        System.out.print("\n[");
        for(int i=0;i<ia.length;i++)
        System.out.print(ia[i]+" ");
        System.out.print("]");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        String s;
        System.out.println("Ansh Nigam 20BCE0419.");
        n = sc.nextInt();
        sc.nextLine();
        Encoding[] E = new Encoding[n];
        for(int i=0;i<n;i++){
            s = sc.nextLine();
            E[i] = new Encoding(s);
        }
        String[] sorted = sort(E);
        
        System.out.print("\nCodewords: ");
        for(int i=0;i<E.length;i++)
        E[i].encodeText(sorted);

        int max =0; 
        for(int i=0;i<E.length;i++){
            if(max<E[i].sa.length)
            max = E[i].sa.length;
        }

        System.out.print("\nCodewords with -1 padding: ");
        for(int i=0;i<E.length;i++)
        E[i].encodeText(sorted,max);
        sc.close(); 
    }
}