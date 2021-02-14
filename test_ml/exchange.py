import urllib.request
from bs4 import BeautifulSoup

url = "https://finance.naver.com/marketindex/"
response = urllib.request.urlopen(url)

soup = BeautifulSoup(response, "html.parser")
#soup.select_one()
results = soup.select("span.value")
#for result in results:
print("달러 : ", results[0].string)
print("엔: ", results[1].string)
print("유로: ", results[2].string)
