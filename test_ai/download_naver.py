import urllib.request
import urllib.parse

api = "https://search.naver.com/search.naver"
values = {
    "where": "nexearch",
    "sm": "top_hty",
    "fbm": "1",
    "ie": "utf-8",
    "query": "초코릿"
}
params = urllib.parse.urlencode(values)

url = api + "?" + params

data = urllib.request.urlopen(url).read()

print(data.decode("utf-8"))