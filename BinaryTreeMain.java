import java.util.*;
interface BinaryTree{
  void buildTree();
  void traverse();
}
class ArrayBinaryTree implements BinaryTree
{
  int n;
  String a[];
  ArrayBinaryTree(int n)
  {
    this.n=n;
    a=new String[n];
  }
  public void buildTree(){
    String start="0";
    a[0]=start;
    int count=1;
    int ind=0;
    while(count<n){ 
      int left=ind*2+1;
      int right=ind*2+2;
      a[left]=a[ind]+"0";
      count++;
      if(count>=n)
      break;
      a[right]=a[ind]+"1";
      count++;
      if(count>=n)
      break;
      ind++;
    }
  }
  public void traverse(){
    int ind=0,qind=0;
    int count=1;
    for(String x: a)
      System.out.println(x);
  }
}  
class LinkedBinaryTree implements BinaryTree
{
  int rear=-1,front=-1,n;
  String data;
  LinkedBinaryTree root=null;
  LinkedBinaryTree left;
  LinkedBinaryTree right;
  LinkedBinaryTree[] queue;
  LinkedBinaryTree(int n){ 
    this.n=n;
  }
  LinkedBinaryTree(){ 
    data=null; left=null; right=null;
  }
  public void buildTree(){
    queue=new LinkedBinaryTree[3*n];
    String start="0";
    int count=0;
    while(count<n){
      if(root==null){
        root=new LinkedBinaryTree();
        root.left=null;
        root.right=null;
        root.data=start;
        queue[++rear]=root;
        front++;
        count++;
      }
      else{
        LinkedBinaryTree node=new LinkedBinaryTree();
        node.left=null;
        node.right=null;
        LinkedBinaryTree lbt=queue[front++];
        if(lbt.left==null){  
          node.data=lbt.data+"0";
          lbt.left=node;
          count++;
          if(count>=n)
          break;
          if(lbt.left!=null || lbt.right!=null)
          queue[++rear]=lbt;
          queue[++rear]=lbt.left;
          front--;
        }
        else if(lbt.right==null){ 
          node.data=lbt.data+"1";
          lbt.right=node;
          count++;
          if(count>=n)
          break;
          if(lbt.left!=null || lbt.right!=null)
          queue[++rear]=lbt;
          queue[++rear]=lbt.right;
          front--;
        }
      }      
    }
  }
  public void traverse(){    
    front=-1; rear=-1;
    LinkedBinaryTree temp=root;
    queue[++rear]=root;
    do{
      temp=queue[++front];
      if(temp!=null){
        System.out.println(temp.data);
        queue[++rear]=temp.left;
        queue[++rear]=temp.right;
      }
    }while (front!=rear);
  }        
}  
class BinaryTreeMain
{
    public static void main(String[] args){   
      System.out.println("Ansh Nigam 20BCE0419.");
      BinaryTree bt=new ArrayBinaryTree(15);
      bt.buildTree();
      System.out.println("Array based Binary Tree Traversal");
      bt.traverse();
      bt=new LinkedBinaryTree(15);
      bt.buildTree();
      System.out.println("Linked Binary Tree Traversal");
      bt.traverse();
    }
}       