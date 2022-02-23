import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Book implements Comparable<Book> {
    int s;
    int e;

    Book(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Book b) {
        if (this.e == b.e) {
            return this.s - b.s;
        } else {
            return this.e - b.e;
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (T > 0) {
            int n = kb.nextInt();
            int m = kb.nextInt();
            int[] check = new int[n + 1];
            ArrayList<Book> arr = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();

                arr.add(new Book(a, b));
            }
            Collections.sort(arr);

            int tmp = 0;
            for (int i = 0; i < m; i++) {
                for (int s = arr.get(i).s; s <= arr.get(i).e; s++) {
                    if (check[s] == 0) {
                        check[s] = 1;
                        tmp++;
                        break;
                    }
                }
            }
            answer.append(tmp + "\n");
            T--;
        }

        System.out.println(answer);
    }
}