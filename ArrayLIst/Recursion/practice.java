package Recursion;

import java.util.ArrayList;

public class practice {

    public static void printDecreasing(int n){
              // base case
             if(n==1){
                System.out.println(n);
                return ;
             }
             // kaam
             System.out.println(n);// printing before calling function
             // function call (innner function)
             printDecreasing(n-1);
    }



    public static void printIncreasing(int n){
        if(n==1){
            System.out.println(n);
            return ;
         }

         printIncreasing(n-1);
         System.out.println(n);// printing after calling function
    }



    public static int findFact(int n){
           if(n==1){
            return 1;
           }
           // kaam  or (inner function) or (chota  function jo bade ki tarah dikhta hai) or  
           int factNm1=findFact(n-1);
           // finding answer using smaller function
           int fact=n*factNm1;
           return fact;
    }



    public static int sumToN(int n ){
        // base case
        if(n==1) return 1;
        // chota function jo bade function ki tarah dikhta hai 
        int calc=sumToN(n-1);
        // creating answer using chota function
        int ans=n+calc;
        return ans;
    }



    public static int nthFiboNum(int n){
        // base case
        if(n==0 || n==1) return n;
         // chota function jo bade function ki tarah dikhta hai 
         int fibNm1=nthFiboNum(n-1);
         int fibNm2=nthFiboNum(n-2);;
        // creating answer using chota function
        int ans=fibNm1+fibNm2;
        return ans;
    }



    public static  boolean ifSorted(int arr[],int start){
       if(start==arr.length-1)return true;// base case
       if(arr[start]>arr[start+1])return false;//  ek case solve kar do
       return ifSorted(arr, start+1);// baki recursion dekh lega
       
    }



    public static void printArray(int arr[],int i){
                 // base case:
                 if(i>=arr.length)
                 return;
                 // processing (ek case solve kar do )
                 System.out.println("element "+i+" is:"+arr[i]);
                 // recursive call sambhal lega
                 printArray(arr, i+1);
    }


    // findMax
    public static int findMax(int arr[],int i,int max){
        // base case:
        
        if(i>=arr.length)return max;
        // processing (ek case solve kar do)
          if(arr[i]>max)max=arr[i];
        // recursive call:
        return findMax(arr,i+1,max);
    }

    public static boolean findKey(String s,char a,int i,int count){
        // base case:
        if(i>=s.length()){
            return false;
        }
        // processing (ek case solve kar do )
        if(a==s.charAt(i)){
            count+=1;
            return true;}
        // recursive call(backi recursion sambhal lega)
        return findKey(s, a, i+1,count);
    }

    public static void printKeys(String s,char a,int i){
        // base case:
        if(i>=s.length()){
            return ;
        }
        // processing (ek case solve kar do)
        if(a==s.charAt(i)){
            System.out.println(a+" at index "+i);}
        // recursive call(baki recursion sambhal lega)
         printKeys(s, a, i+1);
    }
    

    public static void copyKeys(String s,char a,int i,ArrayList<Integer>array){
        // base case:
        if(i>=s.length()){
            return ;
        }
        // processing (ek case solve kar do)
        if(a==s.charAt(i)){
           array.add(i); }
        // recursive call(baki recursion sambhal lega)
         copyKeys(s, a, i+1,array);
    }



     public static int firstOccurence(int arr[],int startPos,int key){
        // base case
        if(startPos>arr.length-1){
            return -1;
        }
       
        // ek case solve kar do
        if(arr[startPos]==key){
            return startPos;
        }
        // baki recursion sambhal lega
        return firstOccurence(arr, startPos+1,  key);
     }

     public static int lastOccurence(int arr[],int startPos,int key){
        // base case
        if(startPos<0){
            return -1;
        }
       
        // ek case solve kar do
        if(arr[startPos]==key){
            return startPos;
        }
        // baki recursion sambhal lega
        return lastOccurence(arr, startPos-1, key);
     }


     public static int powOfxTon(int x,int n){
        // base case
        if(n==0)return 1;
        // ek case solve kar do (recursive function define kar do)
        int powXm1=powOfxTon( x, n-1);
        // combine choti problem to get answer
        int powx=x*powXm1;
        return powx;

     }
     public static int optimizedPower(int x,int n){
       // base case
       if(n==0)return 1;   
       int halfPower=optimizedPower(x, n/2);// it is done to reduce multiple function call
       int halfPowerSq=halfPower*halfPower;
       // for even
       if((n&1)==0){
        return  halfPowerSq;
       }
       // for odd
       else{
        return x*halfPowerSq;
       }
     }
     // tiling problem
     public static int tilingWays(int n){
        if(n==0|| n==1) return 1;
        // for horizonal
        int horizontal=tilingWays(n-2);
        // for vertical
        int vertical=tilingWays(n-1);
     return horizontal+vertical;

     }

     public static String removeDuplicates(StringBuilder s,String output,int index){
        // base case
         if(index>s.length()-1) return output;

        // ek case solve kar do (kaam)
        if(output.indexOf(s.charAt(index))==-1){
            output+=s.charAt(index);
        }
        // baki recursion sambhal lega
        return removeDuplicates(s, output, index+1);
         }



// another approach using map:
         public static void removeDuplicates(String str, int i, boolean  map[],StringBuilder sb){

            if(i == str.length()){
    
                System.out.println(sb);
                return;
    
            }
    
            //kam
    
            char currentChar = str.charAt(i);
            if(map[currentChar - 'a'] == true){
                //duplicate
                removeDuplicates(str,i+1,map,sb);
            }else{
                map[currentChar - 'a'] = true;
                removeDuplicates(str,i+1,map,sb.append(currentChar));
            }
    
        }

// friends pairing 

public static int friendPairs(int n) {

    // base case
    if (n == 1 || n == 2) {
        return n;
    }

    // choice
    // single

    int fnm1 = friendPairs(n - 1);

    // pair
    int fnm2 = friendPairs(n - 2);
    // because the single person can make pair with any other variable so their are n-1 * fnm2 ways
    int ways = (n-1) * fnm2;

    return fnm1 + ways;

}

// Binary Strings problem
//n = index, 
    //str = string in which the values will be stored
    //lastplace = the last place number
    public static void printBinString(int n, String str, int lastPlace){

        //base case
        if(n==0){
            System.out.println(str);
            return;
        }

        //kaam
        //here we are starting with the 1 as last place
        printBinString(n-1,str+"0",0); 

        if(lastPlace == 0){
            printBinString(n-1,str+"1",1);
        }

    }
    public static void main(String[] args) {

        printDecreasing(10);
        System.out.println();

        printIncreasing(10);
        System.out.println();

        System.out.println(findFact(5));
        System.out.println();

        System.out.println(sumToN(10));
        System.out.println();

        System.out.println(nthFiboNum(5));
        System.out.println();

        int arr[]={1,2,3,6,3,4,5};
        System.out.println("Array is sorted :"+ifSorted(arr,0));
        System.out.println();

        printArray(arr,0);
        System.out.println();

        int max=Integer.MIN_VALUE;
        System.out.println("max element is: "+findMax(arr,0,max));
        System.out.println();

        String s="Rahul yadav";
        int count=0;
        System.out.println("key is present: "+findKey(s,'a',0,count));
        System.out.println(count);// wrong answer use array of size 1
        printKeys(s,'a',0);

        // store all indexes in an array:
        ArrayList<Integer> array = new ArrayList<>();
        copyKeys(s,'a',0,array);
        for(int x:array){
            System.out.println(x);
        }
        // first occurence
      System.out.println("the first position of key is:"+firstOccurence(arr,0,3));
      System.out.println("the  last position of key is:"+lastOccurence(arr,arr.length-1,3));
       
      // print x^n
      System.out.println(powOfxTon(5,3));
      System.out.println(optimizedPower(2, 10));

      // tiling problem
      // actual parameter is n from 2 X N   tile dimension
      System.out.println(tilingWays(3));
      // Remove duplicates
      System.out.println(removeDuplicates(new StringBuilder("appannacollege"),new String(""),0));
      removeDuplicates("appannacollege",0,new boolean[26],new StringBuilder(""));

      // friends pairing
      System.out.println(friendPairs(3));// output : 4

      printBinString(3,"",0);// do recursion tree analysis for this function
    }
}
