from khaiii import KhaiiiApi
api = KhaiiiApi()
for word in api.analyze('안녕,세상.'):
    print(word)
for word in api.analyze('안녕하세요.'):
    print(word)
