class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # 그래프 만들기
        graph = collections.defaultdict(list)
        for u,v,w in times:
            graph[u].append((v,w))

        # 우선순위 큐 (소요 시간, 정점)  : 시작점 -> 정점까지 걸리는 소요 시간
        Q = [(0, k)]

        # source로부터 모든 노드까지 거리 저장 변수 dist (파인썬에서는 최단 거리가 결정된 경우에만 dist에 저장)
        dist = collections.defaultdict(int)   # 파이썬에서는 무한대로 저장하지 않는다. heapq 모듈의 기능상 제약때문
        # key: 노드, value: source -> node까지의 최단거리

        # 우선순위 큐 최솟값 기준으로 정점까지 최단 경로 삽입
        while Q:
            time, node = heapq.heappop(Q)
            if node not in dist:
                dist[node] = time
                for v,w in graph[node]:
                    alt = time + w
                    heapq.heappush(Q, (alt,v))

        # 모든 경로의 최단 경로 존재 여부 판별
        if len(dist) == n:
            return max(dist.values())
        return -1     