package LeetCode.Heap;

import java.util.*;

public class TheSkylineProblem_218 {

    //class Point implements Comparable<Point>{}
    //TreeMap
    class Solution {
        class Point implements Comparable<Point> {
            int x, y;
            boolean isStart;

            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            @Override
            public int compareTo(Point p) {
                if (this.x != p.x)
                    return this.x - p.x;
                else {
                    return (this.isStart ? -this.y : this.y) - (p.isStart ? -p.y : p.y);
                }
            }
        }

        public List<List<Integer>> getSkyline(int[][] buildings) {
            Point[] points = new Point[buildings.length * 2];

            int index = 0;
            for (int i = 0; i < buildings.length; i++) {
                points[index] = new Point();
                points[index].x = buildings[i][0];
                points[index].y = buildings[i][2];
                points[index].isStart = true;

                points[++index] = new Point();
                points[index].x = buildings[i][1];
                points[index].y = buildings[i][2];
                points[index++].isStart = false;
            }

            Arrays.sort(points);

            List<List<Integer>> ans = new ArrayList();
            TreeMap<Integer, Integer> heights = new TreeMap();
            int preHeight = 0, currHeight;
            heights.put(0, 1);
            for (Point p : points) {
                if (p.isStart) {
                    heights.compute(p.y, (key, value) -> {
                        if (value != null) {
                            return value + 1;
                        }
                        return 1;
                    });
                }
                else {
                    heights.compute(p.y, (key, value) -> {
                        if (value == 1)
                            return null;
                        return value - 1;
                    });
                }

                currHeight = heights.lastKey();
                if (currHeight != preHeight) {
                    List<Integer> keyPoint = new ArrayList(Arrays.asList(p.x, currHeight));
                    ans.add(keyPoint);
                    preHeight = currHeight;
                }
            }

            return ans;
        }
    }
}
