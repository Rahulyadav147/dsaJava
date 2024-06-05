package ArrayLIst;
import java.util.ArrayList;
class MultiDimensionalArrayList{
    public static void main(String[] args) {
        // syntax
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        // creating 1 dimensinoal lists 
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        ArrayList<Integer>list3=new ArrayList<>();
        // adding elements to 1d arraylists
        for(int i=1;i<=5;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }

        // adding 1d arraylist to 2d 
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        list2.remove(list2.size()-1);// removing from last
        list2.remove(list2.size()-1);

        System.out.println(mainList);
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer>currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){// to get each 1d arraylist size
                  System.out.print(currList.get(j)+" ");

            }
            System.out.println();
        }







    }
}