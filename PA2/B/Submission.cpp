#include <bits/stdc++.h>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <limits>

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
        int N = io.nextInt();
        long A = io.nextLong();
        long B = io.nextLong();
        long C = io.nextLong();
        long X = io.nextLong();
        long Y = io.nextLong();

        long lst[N];

        long previous = A;
        lst[0] = A;
        for (int j = 1; j < N; j++) {
            long current = ((A + (previous % C) * B) % C) * A;
            lst[j] = current;
            previous = current;
        }

        if (N % 2 == 1) {
            int index = N / 2;
            std::nth_element(lst, lst + index, lst + N);
            io.println(lst[index]);
        } else {
            int index = N / 2;
            std::nth_element(lst, lst + index - 1, lst + N);
            long long smaller = lst[index - 1];
            std::nth_element(lst, lst + index, lst + N);
            long long larger = lst[index];
            long long raw = smaller + larger;
            if (raw % 2 == 0) {
                io.println(raw / 2);
            } else {
                long d = raw / 2;
                cout<< d <<".5\n";
            }
        }
    }
    io.close();
    return 0;
}