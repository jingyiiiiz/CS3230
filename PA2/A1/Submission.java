import java.util.*;
import java.io.*;
import java.lang.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = io.nextInt();
        for (int o=0; o<TC; o++) {
            int n = io.nextInt();
            int x = io.nextInt();
            int y = io.nextInt();
            int m = io.nextInt();
            if (x != y) {
                for (int i=0; i<n; i++) {
                    for (int j=0; j<x; j++) {
                        int thisInt = io.nextInt();
                    }
                }
                for (int k=0; k<y; k++) {
                    for (int l=0; l<m; l++) {
                        int thatInt = io.nextInt();
                    }
                }
                for (int p=0; p<n; p++) {
                    for (int q=0; q<m; q++) {
                        int thoseInt = io.nextInt();
                    }
                }
                io.println("Inner matrix dimensions must agree");
            } else {
                boolean correct = true;
                int[][] A = new int[n][x];
                int[][] B = new int[y][m];
                for (int i=0; i<n; i++) {
                    for (int j=0; j<x; j++) {
                        A[i][j] = io.nextInt();
                    }
                }
                for (int k=0; k<y; k++) {
                    for (int l=0; l<m; l++) {
                        B[k][l] = io.nextInt();
                    }
                }
                for (int p=0; p<n; p++) {
                    for (int q=0; q<m; q++) {
                        int result = 0;
                        int toCompare = io.nextInt();
                        for (int r=0; r<x; r++) {
                            result += A[p][r] * B[r][q];
                        }
                        if (result != toCompare) {
                            correct = false;
                        }
                    }
                }
                if (correct) {
                    io.println("AC");
                } else {
                    io.println("WA");
                }
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