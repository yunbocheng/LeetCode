package com.example.backtrace;

import java.util.ArrayList;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM55没有重复项数字的全排列 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

    }


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> ls = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int[] used = new int[num.length];
        dfs(num,used);
        return res;
    }

    private void dfs(int[] a,int[] used) {
        if(ls.size() == a.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i < a.length; i++) {
            if(used[i] == 1) continue;
            used[i] = 1;
            ls.add(a[i]);
            dfs(a,used);
            used[i] = 0;
            ls.remove(ls.size()-1);
        }
    }


}
