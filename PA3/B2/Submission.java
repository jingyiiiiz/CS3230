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
                int currInt = io.nextInt();
                fav[currInt-1] = j;
            }

            /* 
            int[] aux = new int[N];
            int counter = 0;
            boolean needNew;
            for (int c=0; c<N; c++) {
                needNew = true;
                int curr = fav[c];
                for (int d=0; d<=counter; d++) {
                    if ((aux[d] == 0) || (aux[d] < curr)) {
                        aux[d] = curr;
                        needNew = false;
                        break;
                    }
                }
                if (needNew) {
                    counter++;
                    aux[counter] = curr;
                }
            }
            int favLis = counter;
            */
            
            int result = 0;
            for (int k=0; k<M; k++) {
                int[] current = new int[N];
                for (int l=0; l<N; l++) {
                    int thisNum = io.nextInt();
                    current[l] = fav[thisNum-1];
                }
                /*
                int[] auxCurr = new int[N];
                int counterCurr = 0;
                boolean needNewCurr;
                for (int e=0; e<N; e++) {
                    needNewCurr = true;
                    int currCurr = current[e];
                    for (int f=0; f<= counterCurr; f++) {
                        if ((auxCurr[f] == 0) || (auxCurr[f] < currCurr)) {
                            auxCurr[f] = currCurr;
                            needNewCurr = false;
                            break;
                        }
                    }
                    if (needNewCurr) {
                        counterCurr++;
                        auxCurr[counterCurr] = currCurr;
                    }
                }
                int favCurr;
                if (counterCurr != 0) {
                    favCurr = counterCurr + 1;
                } else {
                    favCurr = N;
                }
                */
                
                /*
                if (favLis > favCurr) {
                    result = result + favLis - favCurr;
                } else {
                    result = result + favCurr - favLis;
                }
                */
                int[] auxCurr = new int[N];
                int counterCurr = 0;
                for (int e = 0; e < N; e++) {
                    int currCurr = current[e];
                    int index = Arrays.binarySearch(auxCurr, 0, counterCurr, currCurr);
                    if (index < 0) {
                        index = -(index + 1);
                    }
                    auxCurr[index] = currCurr;
                    if (index == counterCurr) {
                        counterCurr++;
                    }
                }
                int favCurr = counterCurr;
                result += N - favCurr;
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
