package kr.seok.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums,
 * return this repeated number.
 */
public class List_287 {
    /*
        주기가 시작되는 노드를 반환

        1. slow, fast가 각 주기가 다르게 탐색하여 교차점(intersection)을 찾는다.
        2. slow, fast가 head, intersection에서 출발하되 같은 주기로 탐색하여 만나는 지점이 enterance 이고 그 값을 반환
     */
    public int findDuplicateFloydCycle(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int hare = nums[0];
        do {
            slow = nums[slow];
            hare = nums[nums[hare]];
        } while (slow != hare);

        // Find the "entrance" to the cycle.
        slow = nums[0];
        while (slow != hare) {
            slow = nums[slow];
            hare = nums[hare];
        }

        return hare;
    }

    /*
        Set

        배열을 반복하면서 각 요소를 저장하여 배열을 반복할 때 요소를 간단히 확인할 수 있다.

        선형적인 시간 복잡도를 달성하기 위해 일정한 시간에 요소를 데이터 구조에 삽입하고 조회할 수 있어야 한다.

        삽입 전에 존재하는지 확인한 뒤 값을 반환
     */
    public int findDuplicateSet(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num)) {
                return num;
            }
            visited.add(num);
        }

        return -1;
    }
}
