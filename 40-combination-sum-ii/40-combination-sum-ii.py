class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(comb, remain, idx, counter, results):
            if remain == 0:
                results.append(comb[:])
                return
            if remain < 0:
                return

            for i in range(idx, len(counter)):
                num, cnt = counter[i]
                if cnt <= 0:
                    continue
                # add a new element to the current combination
                comb.append(num)
                counter[i] = (num, cnt-1)

                # continue the exploration with the updated combination
                backtrack(comb, remain-num, i, counter, results)

                # backtrack the changes, so that we can try another candidate
                counter[i] = (num, cnt)
                comb.pop()

        results = []  # container to hold the final combinations
        counter = Counter(candidates)
        # convert the counter table to a list of (num, count) tuples
        counter = [(c, counter[c]) for c in counter]

        backtrack(comb=[], remain=target, idx=0, counter = counter, results = results)

        return results