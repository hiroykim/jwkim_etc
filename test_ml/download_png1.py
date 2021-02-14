import urllib.request

url="http://uta.pw/shodou/img/28/214.png"
savename="C:/KMS_PROJECT/data/url/test.png"

#urllib.request.urlretrieve(url, savename)

mem = urllib.request.urlopen(url).read()

with open(savename, mode="wb") as f:
    f.write(mem)
    print("저장되었습니다.")