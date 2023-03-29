#include <bits/stdc++.h>
using namespace std;

// io class
class FastIO {
public:
    FastIO() {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
    }

    string next() {
        string s;
        cin >> s;
        return s;
    }

    int nextInt() {
        int x;
        cin >> x;
        return x;
    }

    long long nextLong() {
        long long x;
        cin >> x;
        return x;
    }

    double nextDouble() {
        double x;
        cin >> x;
        return x;
    }

    string nextLine() {
        string s;
        getline(cin, s);
        return s;
    }

    void println(string s) {
        cout << s << "\n";
    }

    void println(int x) {
        cout << x << "\n";
    }
};


int main() {
    FastIO io;
    int TC = io.nextInt();
    while (TC--) {
        int N = io.nextInt();
        int M = io.nextInt();
        vector<int> fav(N);
        for (int j = 0; j < N; j++) {
            fav[j] = io.nextInt();
        }
        int result = 0;
        while (M--) {
            vector<int> current(N);
            for (int l = 0; l < N; l++) {
                current[l] = io.nextInt();
            }
            vector<vector<int>> table(N + 1, vector<int>(N + 1));
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (fav[a] == current[b]) {
                        table[a + 1][b + 1] = table[a][b] + 1;
                    } else {
                        table[a + 1][b + 1] = max(table[a][b + 1], table[a + 1][b]);
                    }
                }
            }
            int lcs = table[N][N];
            int steps = N - lcs;
            result += steps;
        }
        cout << result << '\n';
    }
    return 0;
}