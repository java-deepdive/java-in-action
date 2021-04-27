package kr.seok.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight.
 * 당신은 항공사의 목록이 주어진다 출발 한 비행기의 도착 공항을 대표합니다.
 * <p>
 * Reconstruct the itinerary in order and return it.
 * <p>
 * All of the tickets belong to a man who departs from "JFK",
 * <p>
 * thus, the itinerary must begin with "JFK".
 * <p>
 * If there are multiple valid itineraries,
 * <p>
 * you should return the itinerary that has the smallest lexical order when read as a single string.
 * <p>
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * <p>
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 * <p>
 * <p>
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * <p>
 * <p>
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 */
public class Graph_332 {
    // 값을 처리할 자료구조
    private final HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    // 결과물을 저장할 전역 변수
    private LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        // 티켓이 들어오면 노드 하나씩 탐색
        for (List<String> ticket : tickets) {
            // ["JFK","SFO"]
            String origin = ticket.get(0);
            String dest = ticket.get(1);

            // 전역 변수로 선언된 자료구조에 티켓의 정보를 입력
            if (this.flightMap.containsKey(origin)) {
                LinkedList<String> destList = this.flightMap.get(origin); // 목적지 조회
                destList.add(dest); // 저장
            } else {
                // 티켓 정보가 없는 경우
                LinkedList<String> destList = new LinkedList<>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        this.flightMap.forEach((key, value) -> Collections.sort(value));

        this.result = new LinkedList<>();
        this.DFS("JFK");
        return this.result;
    }

    // dfs 탐색
    private void DFS(String origin) {
        if (this.flightMap.containsKey(origin)) {

            // JFK로 탐색 시작
            LinkedList<String> destList = this.flightMap.get(origin);
            // 목적지 리스트를 앞에서부터 순차적으로 poll
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        this.result.offerFirst(origin);
    }
}
