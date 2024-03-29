import heapq as hq
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        a = []
        for p in points:
            dist = math.sqrt(p[0]**2 + p[1]**2)
            hq.heappush(a, (dist,p[0],p[1]))

        rst = []
        while k>0:
            print(k)
            dist, x, y = hq.heappop(a)
            # print(dist, x, y)
            rst.append([x,y])
            k-=1

        return rst