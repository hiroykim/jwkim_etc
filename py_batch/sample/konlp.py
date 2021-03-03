#-*- coding:utf-8 -*-

"""program"""
__author__ = "Meritz KMS"
__date__ = "creation 2021-02-26"

import time
from konlpy.utils import pprint
from konlpy.tag import Kkma
from konlpy.tag import Okt
from konlpy.tag import Mecab
from datetime import date, datetime, timedelta

def elapsed_time(start_time):
    end_time = datetime.fromtimestamp((time.time()))
    required_time = end_time - start_time
    return required_time

def mecab_test():
    mecab = Mecab(dicpath=r"C:\mecab\mecab-ko-dic")
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
    st_tm = datetime.fromtimestamp(time.time())
    kkma_test()
    print("kkma_test()===>st_time : {0}, ps_time : {1}".format(st_tm, elapsed_time(st_tm)))
    st_tm = datetime.fromtimestamp(time.time())
    okt_test()
    print("okt_test()====>st_time : {0}, ps_time : {1}".format(st_tm, elapsed_time(st_tm)))
    st_tm = datetime.fromtimestamp(time.time())
    mecab_test()
    print("mecab_test()==>st_time : {0}, ps_time : {1}".format(st_tm, elapsed_time(st_tm)))

if __name__ == "__main__":

    main()
    print("--------------------------------------------------------")
    main()