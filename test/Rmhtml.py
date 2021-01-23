import re

def remove_tag(content):
    cleanr = re.compile('<.*?>')
    cleantext = re.sub(cleanr, '', content)
    return cleantext


if __name__ == "__main__":
    content = "<html><body>hello content</body></html>"
    tr_con = remove_tag(content)
    print(tr_con)