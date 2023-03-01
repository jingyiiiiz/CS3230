import java.util.*;
import java.io.*;
import java.lang.*;

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

            boolean applicable = false;
            double powOfN;
            boolean isPowOfNInt = false;
            int powOfLogN;

            if (logBandA > d) {
                // enter case 1
                applicable = true;
                powOfN = logBandA;
                powOfLogN = 0;
                if (Math.pow(b, (int) logBandA) == a) {
                    isPowOfNInt = true;
                }
            } else if (logBandA == d) {
                // enter case 2
                applicable = true;
                powOfN = logBandA;
                powOfLogN = k + 1;
                if (Math.pow(b, (int) logBandA) == a) {
                    isPowOfNInt = true;
                }
            } else if (logBandA < d) {
                // enter case 3
                applicable = true;
                powOfN = d;
                powOfLogN = k;
                if ((int) d == d) {
                    isPowOfNInt = true;
                }
            } else {
                powOfN = -1;
                powOfLogN = -1;
                isPowOfNInt = false;
            }

            if (applicable) {
                if (powOfN == 0) {
                    if (powOfLogN == 0) {
                        io.println(String.format("T(n) = %s(1)", "\u0398"));
                    } else if (powOfLogN == 1) {
                        io.println(String.format("T(n) = %s(log n)", "\u0398"));
                    } else {
                        io.println(String.format("T(n) = %s(log^%d n)", "\u0398", powOfLogN));
                    }
                } else if (powOfN == 1) {
                    if (powOfLogN == 0) {
                        io.println(String.format("T(n) = %s(n)", "\u0398"));
                    } else if (powOfLogN == 1) {
                        io.println(String.format("T(n) = %s(n log n)", "\u0398"));
                    } else {
                        io.println(String.format("T(n) = %s(n log^%d n)", "\u0398", powOfLogN));
                    }
                } else if (isPowOfNInt) {
                    if (powOfLogN == 0) {
                        io.println(String.format("T(n) = %s(n^%d)", "\u0398", (int) powOfN));
                    } else if (powOfLogN == 1) {
                        io.println(String.format("T(n) = %s(n^%d log n)", "\u0398", (int) powOfN));
                    } else {
                        io.println(String.format("T(n) = %s(n^%d log^%d n)", "\u0398", (int) powOfN, powOfLogN));
                    }
                } else {
                    if (powOfLogN == 0) {
                        io.println(String.format("T(n) = %s(n^%.1f)", "\u0398", Math.round(powOfN*10)/10.0));
                    } else if (powOfLogN == 1) {
                        io.println(String.format("T(n) = %s(n^%.1f log n)", "\u0398", Math.round(powOfN*10)/10.0));
                    } else {
                        io.println(String.format("T(n) = %s(n^%.1f log^%d n)", "\u0398", Math.round(powOfN*10)/10.0, powOfLogN));    
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