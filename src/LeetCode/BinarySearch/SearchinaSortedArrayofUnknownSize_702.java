//package LeetCode.BinarySearch;
//
//public class SearchinaSortedArrayofUnknownSize_702 {
//    class Solution {
//        public int search(ArrayReader reader, int target) {
//            if(reader.get(0) == target)    return 0;
//            int index = 1;
//            while(reader.get(index) < target){
//                index *= 2;
//            }
//
//            if(reader.get(index) == target)    return index;
//            int start = index / 2, end = index;
//            while(start + 1 < end)  {
//                int median = (end - start) / 2 + start;
//                int num = reader.get(median);
//                if(num == target)
//                    return median;
//                if (num < target)
//                    start = median;
//                else end = median;
//            }
//
//            if(reader.get(start) == target)    return start;
//            else if (reader.get(end) == target)    return end;
//            return -1;
//        }
//    }
//}
