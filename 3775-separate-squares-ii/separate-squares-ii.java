class Solution {
    static class Event {
        long y, x1, x2;
        int type;
        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] len;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            len = new long[n * 4];
        }

        void update(int node, int l, int r, int ql, int qr, int v) {
            if (qr <= l || ql >= r) return;
            if (ql <= l && r <= qr) {
                count[node] += v;
            } else {
                int m = (l + r) / 2;
                update(node * 2, l, m, ql, qr, v);
                update(node * 2 + 1, m, r, ql, qr, v);
            }
            if (count[node] > 0) {
                len[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                len[node] = 0;
            } else {
                len[node] = len[node * 2] + len[node * 2 + 1];
            }
        }

        long query() {
            return len[1];
        }
    }

    public static double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        TreeSet<Long> xsSet = new TreeSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            long x2 = x + l, y2 = y + l;
            events.add(new Event(y, x, x2, 1));
            events.add(new Event(y2, x, x2, -1));
            xsSet.add(x);
            xsSet.add(x2);
        }

        long[] xs = xsSet.stream().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> idx = new HashMap<>();
        for (int i = 0; i < xs.length; i++) idx.put(xs[i], i);

        events.sort(Comparator.comparingLong(e -> e.y));

        // First pass: total area
        SegmentTree st = new SegmentTree(xs);
        long prevY = events.get(0).y;
        double totalArea = 0;

        for (Event e : events) {
            long y = e.y;
            totalArea += (double) st.query() * (y - prevY);
            st.update(1, 0, st.n, idx.get(e.x1), idx.get(e.x2), e.type);
            prevY = y;
        }

        double half = totalArea / 2.0;

        // Second pass: find Y
        st = new SegmentTree(xs);
        prevY = events.get(0).y;
        double cur = 0;

        for (Event e : events) {
            long y = e.y;
            double covered = st.query();
            double slice = covered * (y - prevY);

            if (cur + slice >= half) {
                double need = half - cur;
                return prevY + need / covered;
            }

            cur += slice;
            st.update(1, 0, st.n, idx.get(e.x1), idx.get(e.x2), e.type);
            prevY = y;
        }
        return prevY;
    }
}