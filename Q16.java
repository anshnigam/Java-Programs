import java.io.*;
import java.util.*;
class Q16{
    public static void main(String[] args) throws IOException{
        System.out.println("Ansh Nigam 20BCE0419.");
        BufferedReader br = new BufferedReader(new FileReader("phrases.txt"));
        String st;
        int ct=1;
        Map<String,Set<String>> mp = new TreeMap<>();
        while((st = br.readLine()) != null){
            int p1 = st.indexOf('(');
            int p2 = st.indexOf(')');
            String s1 = st.substring(p1+1,p2);
            st = st.substring(0,p1-1);
            String[] arr1 = st.split(" ");
            String[] arr2 = s1.split(" ");
            if(arr1.length != arr2.length){
                System.out.println("Length unequal in iteration"+ct);
                break;
            }
            for(int i=0;i<arr1.length;i++){
                if(mp.containsKey(arr2[i])){
                    Set<String> s = mp.get(arr2[i]);
                    s.add(arr1[i]);
                }
                else{
                    Set<String> s = new HashSet<>();
                    s.add(arr1[i]);
                    mp.put(arr2[i],s);
                }
            }
            ct++;
        }
        br.close();
        System.out.println("Map generated from file: ");
        for(Map.Entry<String,Set<String>> e : mp.entrySet()){
            System.out.println(e.getKey()+": "+e.getValue());
        }
        String input,value;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input phrase: ");
        input = sc.nextLine();
        String[] inp = input.split(" ");
        String[][] fin = new String[inp.length][];
        for(int i=0;i<fin.length;i++){
            value="";
            for(Map.Entry<String,Set<String>> e : mp.entrySet()){
                Set<String> temp = (Set<String>)e.getValue();
                String key = e.getKey();
                Iterator<String> itr = temp.iterator();
                while(itr.hasNext()){
                    String cmp = itr.next();
                    if(cmp.equals(inp[i])){
                        value = value + key + " ";
                    }
                }
            }
            fin[i] = value.split(" ");
        }
        System.out.println("Ragged Array wrt Input: ");
        for(int i=0;i<fin.length;i++){
            for(int j=0;j<fin[i].length;j++)
            System.out.print(fin[i][j]+" ");
            System.out.println();
        }
        System.out.print("Enter tag-sequence: ");
        String sequence = sc.nextLine();
        String[] seq = sequence.split(" ");
        sc.close();
        boolean[] flag = new boolean[inp.length];
        for(int i=0;i<flag.length;i++)
        flag[i] = false;
        for(int i=0;i<fin.length;i++){
            for(int j=0;j<fin[i].length;j++){
                if(seq[i].equals(fin[i][j])){
                    flag[i] = true;
                }
            }
        }
        boolean chk = true;
        for(int i=0;i<flag.length;i++){
            if(flag[i] == false)
            chk = false;
        }
        if(chk == true)
        System.out.println("The given sequence is accepted.");
        else
        System.out.println("The given sequence is not accepted.");
    }
}