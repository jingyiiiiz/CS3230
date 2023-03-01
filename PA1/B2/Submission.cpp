#include <bits/stdc++.h>
using namespace std;

// io class
class FastIO {
    public:
        FastIO() {
            ios_base::sync_with_stdio(false);
            cin.tie(NULL);
        }

        string next() {
            cin >> buffer;
            return buffer;
        }

        int nextInt() {
            return stoi(next());
        }

        long long nextLong() {
            return stoll(next());
        }

        double nextDouble() {
            return stod(next());
        }

        string nextLine() {
            getline(cin, buffer);
            return buffer;
        }

        void println(long long x) {
            cout << x << "\n";
        }

        void close() {
            cout.flush();
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }

    private:
        string buffer;
};

int main() {
    FastIO io;
    int TC = io.nextInt();
    for (int i = 0; i < TC; i++) {
        long long N = io.nextLong();
        long long A = io.nextLong();
        long long B = io.nextLong();
        long long C = io.nextLong();
        long long smallA = A % C;
        B = B % C;
        long long X = io.nextLong();
        long long Y = io.nextLong();
        X = X % Y;

        vector<long long> lst(N);
        vector<long long> output(N);
        int bitsize = 32768;
        vector<long long> auxiliary(bitsize);

        long long previous = A;
        lst[0] = A;

        for (int j = 1; j < N; j++) {
            long long current = (smallA + previous * B) % C;
            lst[j] = current;
            previous = current;
        }

        for (int k = 0; k < N; k++) {
            int corrIndex = lst[k] % bitsize;
            auxiliary[corrIndex]++;
        }

        for (int l = 1; l < bitsize; l++) {
            auxiliary[l] += auxiliary[l-1];
        }

        for (long long m = N-1; m >= 0; m--) {
            int corrIndex = lst[m] % bitsize;
            output[auxiliary[corrIndex] - 1] = lst[m];
            auxiliary[corrIndex]--;
        }

        auxiliary.assign(bitsize, 0);
        lst.assign(N, 0);

        long long V = 77;

        for (long long o = 0; o < N; o++) {
            int corrIndex = (output[o] - (output[o] % bitsize)) / bitsize;
            auxiliary[corrIndex]++;
        }

        for (int p = 1; p < bitsize; p++) {
            auxiliary[p] += auxiliary[p-1];
        }

        for (long long q = N-1; q >= 0; q--) {
            int corrIndex = (output[q] - (output[q]) % bitsize) / bitsize;
            lst[auxiliary[corrIndex] - 1] = output[q];
            auxiliary[corrIndex]--;
        }

        for (int r = 0; r < N; r++) {
            V = (V * X + 7 * lst[r]) % Y;
        }

        io.println(V);
    }
    io.close();
    return 0;
}
