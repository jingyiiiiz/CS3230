import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Submission {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int TC = io.nextInt();
        for (int i=0; i<TC; i++) {
            int a = io.nextInt();
            double b = io.nextDouble();
            double c = io.nextDouble();
            double d = io.nextDouble();
            int k = io.nextInt();

            double logBandA = Math.log(a) / Math.log(b);
            
            if (logBandA > d) {
                // enter case 1
                if (logBandA == 0) {
                    io.println(String.format("T(n) = %s(1)", "\u0398"));
                } else if (logBandA == 1) {
                    io.println(String.format("T(n) = %s(n)", "\u0398"));
                } else if (Math.pow(b, (int) logBandA) == a) {
                    io.println(String.format("T(n) = %s(n^%.0f)", "\u0398", logBandA));
                } else {
                    io.println(String.format("T(n) = %s(n^%.1f)", "\u0398", logBandA));
                }
            } else if (logBandA == d) {
                // enter case 2
                if (k == 0) {
                    if (logBandA == 0) {
                        io.println(String.format("T(n) = %s(log n)", "\u0398"));
                    } else if (logBandA == 1) {
                        io.println(String.format("T(n) = %s(n log n)", "\u0398"));
                    } else if (Math.pow(b, (int) logBandA) == a) {
                        io.println(String.format("T(n) = %s(n^%.0f log n)", "\u0398", logBandA));
                    } else {
                        io.println(String.format("T(n) = %s(n^%.1f log n)", "\u0398", logBandA));
                    }
                } else {
                    if (logBandA == 0) {
                        io.println(String.format("T(n) = %s(log^%d n)", "\u0398", k+1));
                    } else if (logBandA == 1) {
                        io.println(String.format("T(n) = %s(n log^%d n)", "\u0398", k+1));
                    } else if (Math.pow(b, (int) logBandA) == a) {
                        io.println(String.format("T(n) = %s(n^%.0f log^%d n)", "\u0398", logBandA, k+1));
                    } else {
                        io.println(String.format("T(n) = %s(n^%.1f log^%d n)", "\u0398", logBandA, k+1));
                    }
                }
            } else if (logBandA < d) {
                // enter case 3
                if (k == 1) {
                    if (d == 0) {
                        io.println(String.format("T(n) = %s(log n)", "\u0398"));
                    } else if (d == 1) {
                        io.println(String.format("T(n) = %s(n log n)", "\u0398"));
                    } else if ((int) d == d) {
                        io.println(String.format("T(n) = %s(n^%.0f log n)", "\u0398", d));
                    } else {
                        io.println(String.format("T(n) = %s(n^%.1f log n)", "\u0398", d));
                    }
                } else {
                    if (d == 0) {
                        io.println(String.format("T(n) = %s(log^%d n)", "\u0398", k));
                    } else if (d == 1) {
                        io.println(String.format("T(n) = %s(n log^%d n)", "\u0398", k));
                    } else if ((int) d == d) {
                        io.println(String.format("T(n) = %s(n^%.0f log^%d n)", "\u0398", d, k));
                    } else {
                        io.println(String.format("T(n) = %s(n^%.1f log^%d n)", "\u0398", d, k));
                    }
                }
            } else {
                io.println("not applicable");
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