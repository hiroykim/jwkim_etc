import requests

#url = "http://google.com"
url = "http://daum.net"
data = {"a": 10, "b": 20}

session = requests.session()
response = session.get(url, data=data)
response.raise_for_status()
print(response.text)