import requests
from bs4 import BeautifulSoup

session = requests.session()
url = "https://www.hanbit.co.kr/member/login_proc.php"
data = {
    "retun_url": "https://www.hanbit.co.kr/member/login_proc.php"
    ,"m_id": "kimjunwon"
    ,"m_passwd": "gksqlc!@34"
}
response = session.post(url, data=data)
response.raise_for_status()

url="https://www.hanbit.co.kr/myhanbit/myhanbit.html"
response = session.get(url)
response.raise_for_status()
soup = BeautifulSoup(response.text,"html.parser")
text = soup.select_one(".mileage_section1 span").get_text()
print("코인 : ", text)
print("soup : ", soup.text)