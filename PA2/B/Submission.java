import java.util.*;
import java.io.*;
import java.lang.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = Integer.parseInt(io.nextLine());
        for (int i=0; i<TC; i++) {
            long N = io.nextLong();
            long A = io.nextLong();
            long B = io.nextLong();
            long C = io.nextLong();
            long X = io.nextLong();
            long Y = io.nextLong();

            long[] lst = new long[(int) N];
            long previous = A;
            lst[0] = A;

            for (int j=1; j<N; j++) {
                long current = (A + ((previous % C) * B)) % C * A;
                lst[(int) j] = current;
                previous = current;
            }

            long result;
            if (N % 2 == 0) {
                int index1 = (int) (N/2 - 1);
                int index2 = (int) (N/2);
                long first = find(lst, index1);
                long second = find(lst, index2);
                result = (first + second) / 2;
            } else {
                int index = (((int) N)/2);
                result = find(lst, index);
            }
            io.println(result);
        }
        io.close();
    }
    static long find(long[] lst, int index) {
        if (lst.length == 1) {
            return lst[0];
        } else {
            int size = lst.length;
            long[] auxiliary = new long[size];
            int smaller = 0;
            int larger = size-1;
            int chosen = (int) (Math.floor(Math.random() * size));
            long chosenNum = lst[chosen];
            for (int i=0; i<size; i++) {
                if (i != chosen) {
                    long toCompare = lst[i];
                    if (toCompare <= chosenNum) {
                        auxiliary[smaller] = toCompare;
                        smaller++;
                    } else {
                        auxiliary[larger] = toCompare;
                        larger--;
                    }
                }
            }
            if (smaller == index) {
                return chosenNum;
            } else if (smaller < index) {
                long[] newList = new long[size - smaller - 1];
                for (int j=0; j<newList.length; j++) {
                    newList[j] = lst[smaller+j+1];
                }
                return find(newList, index-smaller-1);
            } else {
                long[] newList = new long[smaller];
                for (int j=0; j<newList.length; j++) {
                    newList[j] = lst[j];
                }
                return find(newList, index);
            }
        }
    }
}

// io class
class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
