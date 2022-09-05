class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        # graph 구현
        graph = collections.defaultdict(list)
        for u,v,w in flights:
            graph[u].append((v,w))

        # 최단거리 저장 -> 전체 거리를 계산할 필요가 없으므로 제거
        # dist = collections.defaultdict(int)

        # 큐 (price, src, 거쳐간 노드 개수)
        Q = [(0, src, K+1)]
        visit = [0]*n

        while Q:
            price, node, k = heapq.heappop(Q)
            if node == dst:
                return price
            if visit[node] >= k:
                continue
            visit[node] = k
            for v, w in graph[node]:
                temp = price + w
                heapq.heappush(Q, (temp, v, k - 1))
            # if cnt <= k:  # k 이내일 때만 우선순위 큐에 경로를 추가, k를 넘어서는 경로는 더 이상 탐색하지 않도록 함
            #     for v, w in graph[node]:
            #         temp = price+w
            #         heapq.heappush(Q,(temp, v, cnt-1))

        return -1