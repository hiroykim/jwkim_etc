from bs4 import BeautifulSoup

#태크선택자
"h1"
#id선택자
"#meigen"
#class선택자
"ul.items.art.book" \
#후손선택자
"#meigen li"
#자식선택자
"ul.items > li"

html="""
<html>
    <body>
        <div id="meigen">
            <h1>위키북스 도서</h1>
            <ul class="items art book">
                <li>유니티 게임 이펙트 입문1</li>
                <li>유니티 게임 이펙트 입문2</li>
                <li>유니티 게임 이펙트 입문3</li>
            </ul>
        </div>
    </body>
</html>
"""

soup = BeautifulSoup(html, 'html.parser')

header = soup.select_one("body > div > h1")
list_items = soup.select("ul.items > li")

print(header.string)
print(header.attrs)
print(soup.select_one("ul").attrs)
for li in list_items:
    print(li)