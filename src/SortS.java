import java.util.Scanner;
public class SortS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("---------Enter The Number Of Strings You Want To Enter-------::");
        int n = sc.nextInt();
        sc.nextLine();
        boolean exceptionThrown = false;
        System.out.print("Enter " + n + " Strings - \n");
        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextLine();
        }

        class Swap {
            public void swap(int i, int j) {
                String temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        Swap swap = new Swap();
        outer:
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[i].length() > list[j].length()) {
                    swap.swap(i, j);
                }
                if (list[i].length() == list[j].length()) {
                    try {
                         Integer.parseInt(list[i]);
                         Integer.parseInt(list[j]);
                    } catch (NumberFormatException nfe) {
                        exceptionThrown = true;
                        System.out.println("Do not enter anything except for numbers");
                        break outer;
                    }
                    if (Integer.parseInt(list[i]) > Integer.parseInt(list[j])) {
                        swap.swap(i, j);
                    }
                }
            }
        }

        
        if (!exceptionThrown) {
        	System.out.println("-----------------------OUTPUT----------------------------");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}