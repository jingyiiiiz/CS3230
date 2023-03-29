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
        vector<int> lst(N);
        int sum = 0;
        for (int j = 0; j < N; j++) {
            int currentNum = io.nextInt();
            lst[j] = currentNum;
            sum += currentNum;
        }
        vector<vector<bool>> table(N, vector<bool>(sum + 1));
        table[0][0] = true;
        table[0][lst[0]] = true;
        for (int k = 1; k < N; k++) {
            for (int l = 0; l <= sum; l++) {
                if (table[k - 1][l]) {
                    table[k][l] = true;
                } else if ((l - lst[k] >= 0) && (table[k - 1][l - lst[k]])) {
                    table[k][l] = true;
                }
            }
        }
        if (N == 1) {
            io.println(sum);
        } else {
            int half = sum / 2;
            while (!table[N - 1][half]) {
                half--;
            }
            int otherHalf = sum - half;
            io.println(otherHalf - half);
        }
    }
    return 0;
}
