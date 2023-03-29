import java.util.*;
import java.io.*;
import java.lang.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = io.nextInt();
        for (int i=0; i<TC; i++) {
            int N = io.nextInt();
            int[] lst = new int[N];
            int sum = 0;
            for (int j=0; j<N; j++) {
                int currentNum = io.nextInt();
                lst[j] = currentNum;
                sum += currentNum;
            }
            boolean[][] table = new boolean[N][sum+1];
            table[0][0] = true;
            table[0][lst[0]] = true;
            for (int k=1; k<N; k++) {
                for (int l=0; l<= sum; l++) {
                    if ((table[k-1][l])) {
                        table[k][l] = true;
                    } else if ((l-lst[k] >= 0) && (table[k-1][l-lst[k]])) {
                        table[k][l] = true;
                    }
                }
            }
            /* 
            for (int p=0; p<N; p++) {
                for (int q=0; q<=sum; q++) {
                    io.print(table[p][q] + " ");
                }
                io.print("\n");
            }
            */
            if (N == 1) {
                io.println(sum);
            } else {
                int half = sum / 2;
                while (!table[N-1][half]) {
                    half--;
                }
                int otherHalf = sum - half;
                io.println(otherHalf - half);
            }
            
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
