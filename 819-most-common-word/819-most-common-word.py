class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        # 데이터 전처리
        words = [word for word in re.sub('[^\w]', ' ', paragraph)
                                          .lower().split()
                                            if word not in banned]
        
        # counts = collections.defaultdict(int)  # dict
        # for word in words:
        #     counts[word] += 1
        counts = collections.Counter(words)
        return counts.most_common(1)[0][0]
    
                                          
                                        