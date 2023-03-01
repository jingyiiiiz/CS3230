import java.util.*;
import java.io.*;
import java.lang.*;

public class Strassen1 {
    public static void main(String[] args) {
        FastIO io = new FastIO();
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
                int[][] D = strassen(A, B, n, x, m);
                for (int p=0; p<n; p++) {
                    for (int q = 0; q < m; q++) {
                        io.print(D[p][q] + " ");
                    }
                    io.print("\n");
                }
        }
        io.close();
    }
    static int[][] strassen(int[][] input1, int[][] input2, int n, int x, int m) {
        int maxOfTwo = Math.max(x, m);
        int maxOfThree = Math.max(n, maxOfTwo);

        int[][] square1 = makeSquare(input1, maxOfThree);
        int[][] square2 = makeSquare(input2, maxOfThree);

        int[][] rawResult = multiply(square1, square2);

        int [][] result = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                result[i][j] = rawResult[i][j];
            }
        }
        return result;

    }

    static int[][] makeSquare(int[][] input, int size) {
        int[][] newSquare = new int[size][size];
        int nRow = input.length;
        int nCol = input[0].length;
        for (int i=0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                newSquare[i][j] = input[i][j];
            }
        }
        return newSquare;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int size = A.length;
        
        int[][] result = new int[size][size];

        if (size == 1) {
            result[0][0] = A[0][0] * B[0][0];
        } else {
            if (size % 2 == 1) {
                size++;
            }
            result = new int[size][size];
            int[][] a = new int[size/2][size/2];
            int[][] b = new int[size/2][size/2];
            int[][] c = new int[size/2][size/2];
            int[][] d = new int[size/2][size/2];
            int[][] e = new int[size/2][size/2];
            int[][] f = new int[size/2][size/2];
            int[][] g = new int[size/2][size/2];
            int[][] h = new int[size/2][size/2];

            split(A, a, 0, 0);
            split(A, b, 0, size/2);
            split(A, c, size/2, 0);
            split(A, d, size/2, size/2);

            split(B, e, 0, 0);
            split(B, f, 0, size/2);
            split(B, g, size/2, 0);
            split(B, h, size/2, size/2);

            int[][] P1 = multiply(a, subtract(f, h));
            int[][] P2 = multiply(add(a, b), h);
            int[][] P3 = multiply(add(c, d), e);
            int[][] P4 = multiply(d, subtract(g, e));
            int[][] P5 = multiply(add(a, d), add(e, h));
            int[][] P6 = multiply(subtract(b, d), add(g, h));
            int[][] P7 = multiply(subtract(a, c), add(e, f));

            int[][] r = add(subtract(add(P5, P4), P2), P6);
            int[][] s = add(P1, P2);
            int[][] t = add(P3, P4);
            int[][] u = subtract(subtract(add(P5, P1), P3), P7);

            join(r, result, 0, 0);
            join(s, result, 0, size/2);
            join(t, result, size/2, 0);
            join(u, result, size/2, size/2);
        }
        return result;
    }

    /*static void split(int[][] ori, int[][] result, int start1, int start2) {
        int size = result.length;
        for (int i1 = 0; i1 < size; i1++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (start1 + i1 < ori.length && start2 + i2 < ori[0].length) {
                    result[i1][i2] = ori[start1 + i1][start2 + i2];
                } else {
                    result[i1][i2] = 0;
                }
            }
        }
    }
    */
    static void split(int[][] ori, int[][] result, int start1, int start2) {
        int size = result.length;
        for (int i1=0, i2=start1; i1<size; i1++, i2++) {
            for (int j1=0, j2=start2; j1<size; j1++, j2++) {
                if (i2 < ori.length && j2 < ori[0].length) {
                    result[i1][j1] = ori[i2][j2];
                }
            }
        }
    }

    static int[][] add(int[][] A, int[][] B) {
        int size = A.length;
        int[][] result = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    static int[][] subtract(int[][] A, int[][] B) {
        int size = A.length;
        int[][] result = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    /*static void join(int[][] ori, int[][] result, int start1, int start2) {
        int size = ori.length;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result[i + start1][j + start2] = ori[i][j];
            }
        }
    }
    */
    static void join(int[][] ori, int[][] result, int start1, int start2) {
        int size = result.length;
        for (int i1=0, i2=start1; i1<size; i1++, i2++) {
            for (int j1=0, j2=start2; j1<size; j1++, j2++) {
                if (i1 < ori.length && j1 < ori[0].length) {
                    result[i2][j2] = ori[i1][j1];
                }
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
