class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        def dfs(start):
            # 첫 번째 값을 읽어 어휘 순 방문
            while graph[start]:
                dfs(graph[start].pop(0))
            route.append(start)

        # 그래프 구성하기
        graph = defaultdict(list)
        for s, e in sorted(tickets):
            graph[s].append(e)

        start = "JFK"
        route = []
        dfs(start)  # 결과 값은 끝에서부터 출력됨 -> 뒤집어 줘야함
        return route[::-1]