import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    MyArrayList<Integer> list = new MyArrayList<>();


    for(int i=0; i<=15; i++){
      list.add(i);
      System.out.println(list.get(i));
    }

    System.out.println("리스트사이즈 : " +list.capacity());
  }

}
