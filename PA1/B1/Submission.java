import java.util.*;
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

            long[] auxiliary = new long[(int) C];

            if (A < C) {
                auxiliary[(int) A] = 1;
            } else {
                auxiliary[0] = 0;
            }

            long previous = A;

            for (int j=1; j<N; j++) {
                long current = (smallA + previous * B) % C;
                auxiliary[(int) current]++;
                previous = current;
            }
            
            long V = 77;
            if (A >= C) {
                for (int k=0; k<C; k++) {
                    for (int l=0; l<auxiliary[k]; l++) {
                        V = (V * X + 7 * (long) k) % Y;
                    }
                }
                V = (V * X + 7 * (long) A) % Y;
            } else {
                for (int m=0; m<C; m++) {
                    for (int o=0; o<auxiliary[m]; o++) {
                        V = (V * X + 7 * (long) m) % Y;
                    }
                }
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
