package com.quincy.laboratory.leetcode.commonFunc;

import java.util.Arrays;

public class Greedy {
    /**
     * 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
     * <p>
     * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
     * n == capacity.length == rocks.length
     * 1 <= n <= 5 * 10^4
     * 1 <= capacity[i] <= 10^9     (10^9 < 2^31)
     * 0 <= rocks[i] <= capacity[i]
     * 1 <= additionalRocks <= 10^9
     *
     * @param capacity
     * @param rocks
     * @param additionalRocks
     * @return
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        long total = 0;     // 这里total极容易int溢出，故而设为long
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
            total += capacity[i];
        }

        if (total <= additionalRocks) {
            return capacity.length;
        }
        Arrays.sort(capacity);
        int count = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (additionalRocks >= capacity[i]) {
                additionalRocks -= capacity[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }


}
