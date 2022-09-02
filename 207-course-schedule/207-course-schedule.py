class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degree=[0]*numCourses
        graph = defaultdict(list)
        for e,s in prerequisites:
            in_degree[e] += 1
            graph[s].append(e)

        dq = deque()
        for i in range(numCourses):
            if in_degree[i]==0:
                dq.append(i)

        cnt = 0
        while dq:
            out = dq.popleft()
            cnt += 1
            for next in graph[out]:
                in_degree[next] -=1
                if in_degree[next]==0:
                    dq.append(next)

        if cnt != numCourses:
            return False
        return True