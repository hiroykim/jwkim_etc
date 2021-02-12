import urllib.request

#url="https://www.google.co.kr/?gws_rd=ssl"
url="http://api.aoikujira.com/ip/ini"

mem = urllib.request.urlopen(url).read()

#print(mem.decode("euc-kr"))
print(mem.decode("utf-8"))