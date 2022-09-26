from collections import defaultdict
from typing import List

class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        # make graph from == equations
        graph = defaultdict(set)
        not_equals = []

        def can_meet(u, target, visited):
            if u==target:
                return True
            visited.add(u)
            for v in graph[u]:
                if v in visited:
                    continue
                if can_meet(v, target, visited):
                    return True
            return False

        for eq in equations:
            n1 = eq[0]
            n2 = eq[-1]
            operator = eq[1:-1]
            if operator == '==':
                graph[n1].add(n2)
                graph[n2].add(n1)
            else:
                not_equals.append((n1, n2))

        for u, v in not_equals:
            if can_meet(u, v, set()):
                return False
        return True