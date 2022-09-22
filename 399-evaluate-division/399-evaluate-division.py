class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        def find_path(s, e, visited):
            if not graph[s] or not graph[e]:
                return -1
            visited[s] = 1
            dq = deque()
            dq.append((s, 1))
            while dq:
                depart, total_cost = dq.popleft()
                visited[depart] = 1
                if depart == e:
                    return total_cost

                if not graph[depart]:
                    return -1

                for dest, cost in graph[depart]:
                    if visited[dest] == 0:
                        dq.append((dest, total_cost*cost))

            return -1

        # make graph
        graph = defaultdict(list)
        for i in range(len(equations)):
            s, e = equations[i]
            cost = values[i]
            graph[s].append((e,cost))
            graph[e].append((s, 1/cost))
            # visited[s], visited[e] = 0, 0

        # search graph
        rst = []
        for s, e in queries:
            visited = defaultdict(int)
            rst.append(find_path(s,e, visited))

        return rst