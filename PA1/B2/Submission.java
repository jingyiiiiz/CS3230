import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.io.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = Integer.parseInt(io.nextLine());
        for (int i=0; i<TC; i++) {
            long N = io.nextLong();
            long A = io.nextLong();
            long B = io.nextLong();
            long C = io.nextLong();
            long smallA = A % C;
            B = B % C;
            long X = io.nextLong();
            long Y = io.nextLong();
            X = X % Y;

            long[] lst = new long[(int) N];
            long[] output = new long[(int) N];
            int bitsize = 32768;
            long[] auxiliary = new long[bitsize];

            long previous = A;
            lst[0] = A;

            for (int j=1; j<N; j++) {
                long current = (smallA + previous * B) % C;
                lst[(int) j] = current;
                previous = current;
            }

            for (int k=0; k<N; k++) {
                int corrIndex = (int) (lst[k] % bitsize);
                auxiliary[corrIndex]++;
            }

            for (int l=1; l<bitsize; l++) {
                auxiliary[l] += auxiliary[l-1];
            }

            for (long m=N-1; m>=0; m--) {
                int corrIndex = (int) (lst[(int) m] % bitsize);
                output[(int) auxiliary[corrIndex] - 1] = lst[(int) m];
                auxiliary[corrIndex]--;
            }

            auxiliary = new long[bitsize];
            lst = new long[(int) N];

            long V = 77;

            for (long o=0; o<N; o++) {
                int corrIndex = (int) ((output[(int) o] / bitsize) % bitsize);
                auxiliary[corrIndex]++;
            }

            for (int p=1; p<bitsize; p++) {
                auxiliary[p] += auxiliary[p-1];
            }

            for (long q=N-1; q>=0; q--) {
                int corrIndex = (int) ((output[(int) q] / bitsize) % bitsize);
                lst[(int) auxiliary[corrIndex] - 1] = output[(int) q];
                auxiliary[corrIndex]--;
            }

            for (int r=0; r<N; r++) {
                V = (V * X + 7 * lst[r]) % Y;
            }
            
            io.println(V);

        }
        io.close();
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
