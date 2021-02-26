#-*- coding:utf-8 -*-

"""program"""
__author__ = "Meritz KMS"
__date__ = "creation 2021-02-26"

from konlpy.utils import pprint
from konlpy.tag import Kkma
from konlpy.tag import Okt
from konlpy.tag import Mecab

def mecab_test():
    mecab = Mecab()
    print(mecab.morphs(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    print(mecab.nouns(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    print(mecab.pos(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))

def kkma_test():
    kkma = Kkma()
    pprint(kkma.sentences(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    pprint(kkma.nouns(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    pprint(kkma.pos(u"도움이 되셨다면 구독 꾸욱 눌러주세요~."))

def okt_test():
    okt = Okt()
    print(okt.morphs("도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    print(okt.nouns("도움이 되셨다면 구독 꾸욱 눌러주세요~."))
    print(okt.pos("도움이 되셨다면 구독 꾸욱 눌러주세요~."))

def main():
    kkma_test()
    print("=============================")
    okt_test()
    print("=============================")
    mecab_test()

if __name__ == "__main__":
    main()