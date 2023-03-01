// T10_A0239855M

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
                int[][] A = new int[n][x];
                int[][] B = new int[y][m];
                int[][] C = new int[n][m];
                int[] D = new int[m];
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
                        C[p][q] = io.nextInt();
                    }
                }
                boolean correct = true;
                for (int tracker=0; tracker<10; tracker++) {
                    for (int r=0; r<m; r++) {
                        D[r] = (int) Math.round(Math.random());
                    }
                    int[] BD = new int[y];
                    for (int s=0; s<y; s++) {
                        int interm = 0;
                        for (int t=0; t<m; t++) {
                            interm += B[s][t] * D[t];
                        }
                        BD[s] = interm;
                    }
                    int[] ABD = new int[n];
                    for (int u=0; u<n; u++) {
                        int intermediate = 0;
                        for (int v=0; v<x; v++) {
                            intermediate += A[u][v] * BD[v];
                        }
                        ABD[u] = intermediate;
                    }
                    int[] CD = new int[n];
                    for (int w=0; w<n; w++) {
                        int intermediateNum = 0;
                        for (int z=0; z<m; z++) {
                            intermediateNum += C[w][z] * D[z];
                        }
                        CD[w] = intermediateNum;
                    }
                    for (int w=0; w<n; w++) {
                        if (CD[w] != ABD[w]) {
                            correct=false;
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
