import java.util.*;
public class LongestEqualBitSubstring {
    static char[] s;
    static int[] z, o, pz, po, sz, so;
    static void build(int v, int l, int r) {
        if (l == r) {
            if (s[l] == '0') z[v] = pz[v] = sz[v] = 1;
            else o[v] = po[v] = so[v] = 1;
            return;
        }
        int m = (l + r) / 2;
        build(v * 2, l, m);
        build(v * 2 + 1, m + 1, r);
        merge(v, l, m, r);
    }
    static void merge(int v, int l, int m, int r) {
        int a = v * 2, b = a + 1;
        int L = m - l + 1, R = r - m;
        pz[v] = pz[a] == L ? L + pz[b] : pz[a];
        sz[v] = sz[b] == R ? R + sz[a] : sz[b];
        z[v] = Math.max(Math.max(z[a], z[b]), sz[a] + pz[b]);
        po[v] = po[a] == L ? L + po[b] : po[a];
        so[v] = so[b] == R ? R + so[a] : so[b];
        o[v] = Math.max(Math.max(o[a], o[b]), so[a] + po[b]);
    }
    static void update(int v, int l, int r, int pos) {
        if (l == r) {
            s[pos] = s[pos] == '0' ? '1' : '0';
            z[v] = o[v] = pz[v] = po[v] = sz[v] = so[v] = 0;
            if (s[pos] == '0') z[v] = pz[v] = sz[v] = 1;
            else o[v] = po[v] = so[v] = 1;
            return;
        }
        int m = (l + r) / 2;
        if (pos <= m) update(v * 2, l, m, pos);
        else update(v * 2 + 1, m + 1, r, pos);
        merge(v, l, m, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next().toCharArray();
        int m = sc.nextInt(), n = s.length;
        int size = 4 * n + 5;
        z = new int[size];
        o = new int[size];
        pz = new int[size];
        po = new int[size];
        sz = new int[size];
        so = new int[size];
        build(1, 0, n - 1);
        while (m-- > 0) {
            int x = sc.nextInt() - 1;
            update(1, 0, n - 1, x);
            System.out.println(Math.max(z[1], o[1]));
        }
        sc.close();
    }
}

