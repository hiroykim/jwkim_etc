# 모듈을 추출합니다.
import urllib.request
from bs4 import BeautifulSoup
import time
# 기사 목록을 가져옵니다.
url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"
response = urllib.request.urlopen(url)
soup = BeautifulSoup(response, "html.parser")
results = soup.select("#section_body a")
for result in results:
    # 기사를 가져옵니다.
    print("제목:", result.attrs["title"])
    url_article = result.attrs["href"]
    response = urllib.request.urlopen(url_article)
    soup_article = BeautifulSoup(response, "html.parser")
    content = soup_article.select_one("#articleBodyContents")
    # 가공합니다.
    output = ""
    for item in content.contents:
        stripped = str(item).strip()
        if stripped == "":
            continue
        if stripped[0] not in ["<", "/"]:
            output += str(item).strip()
    print(output.replace("본문 내용TV플레이어", ""))
    print()
    # 30초 휴식
    time.sleep(1)