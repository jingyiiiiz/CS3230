import java.util.*;
import java.io.*;
import java.lang.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = io.nextInt();
        for (int i=0; i<TC; i++) {
            int N = io.nextInt();
            int M = io.nextInt();
            int[] fav = new int[N];
            for (int j=0; j<N; j++) {
                fav[j] = io.nextInt();
            }
            int result = 0;
            for (int k=0; k<M; k++) {
                int[] current = new int[N];
                for (int l=0; l<N; l++) {
                    current[l] = io.nextInt();
                }
                int[][] table = new int[N+1][N+1];
                for (int a=0; a<N; a++) {
                    for (int b=0; b<N; b++) {
                        if (fav[a] == current[b]) {
                            table[a+1][b+1] = table[a][b] + 1;
                        } else {
                            table[a+1][b+1] = Math.max(table[a][b+1], table[a+1][b]);
                        }
                    }
                }
                int lcs = table[N][N];
                int steps = N - lcs;
                result += steps;
            }
            io.println(result);
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
