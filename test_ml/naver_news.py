import urllib.request
from bs4 import BeautifulSoup

url = "https://news.daum.net/"
#url = "https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001"
#url = "https://finance.naver.com/marketindex/"
response = urllib.request.urlopen(url)

soup = BeautifulSoup(response, "html.parser")
#soup.select_one()
results = soup.select("#mArticle a")
for result in results:
    print(result.string)
    print("href : " , result.attrs["href"])
    print("class : ", result.attrs["class"])
