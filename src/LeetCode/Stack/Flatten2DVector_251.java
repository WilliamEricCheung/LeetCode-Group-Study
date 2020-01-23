package LeetCode.Stack;

import java.util.*;

public class Flatten2DVector_251 {
    class Vector2DStrem {

        Iterator<Integer> iter;

        public Vector2DStrem(int[][] v) {
            iter = Arrays.asList(v)
                    .stream()
                    .flatMapToInt(i -> Arrays.stream(i))
                    .iterator();
        }

        public int next() {
            return iter.next();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }
    }

    class Vector2D {
        private int[][] v;
        int i, j;

        public Vector2D(int[][] v) {
            this.v = v;
            if (v != null && v.length != 0) {
                i = 0;
                while (i < v.length && v[i].length == 0)
                    i++;
                j = 0;
            }
        }

        public int next() {
            int result = v[i][j];

            j++;
            if (j >= v[i].length) {
                i++;
                while (i < v.length && v[i].length == 0)
                    i++;
                j = 0;
            }

            return result;
        }

        public boolean hasNext() {
            if (v == null || v.length == 0 || i == v.length)
                return false;
            return true;
        }
    }
}
