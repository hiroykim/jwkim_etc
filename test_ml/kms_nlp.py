from konlpy.tag import Okt

okt = Okt()

print(okt.pos('아버지가 방에 들어가신다'))
print(okt.pos('아버지가방에들어가신다'))
print(okt.pos('경기수원대리점'))
print(okt.pos('1번째 아해가 골목길을 달려간다.'))
print(okt.pos('2번째 아해가 골목길을 달려 간다.'))