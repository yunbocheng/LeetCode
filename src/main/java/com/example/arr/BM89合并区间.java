package com.example.arr;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-05-06
 */
public class BM89合并区间 {

    public static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(10, 30);
        Interval interval2 = new Interval(20, 60);
        Interval interval3 = new Interval(80, 100);
        Interval interval4 = new Interval(150, 180);
        list.add(interval1);
        list.add(interval3);
        list.add(interval2);
        list.add(interval4);
        ArrayList<Interval> merge = merge(list);
//        for (Interval interval : merge) {
//            System.out.println(interval);
//        }
    }

    public static ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals.isEmpty()) {
            return res;
        }
        if (intervals.size() == 1) {
            res.add(intervals.get(0));
            return res;
        }

        // 按照 start 排序
        intervals.sort(Comparator.comparingInt(v -> v.start));

        // 合并区间
        int index = -1;
        for (Interval interval : intervals) {
            if (index == -1 || interval.start > res.get(index).end) {
                res.add(interval);
                index++;
            }else {
                res.get(index).end = Math.max(interval.end, res.get(index).end);
            }
        }
        return res;
    }
}
