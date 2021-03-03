#-*- coding:utf-8 -*-

"""program"""
__author__ = "Meritz KMS"
__date__ = "creation 2021-02-26"

import time
from datetime import date, datetime, timedelta
from koalanlp.proc import SentenceSplitter
from koalanlp import API
from koalanlp.Util import initialize, finalize

def elapsed_time(start_time):
    end_time = datetime.fromtimestamp((time.time()))
    required_time = end_time - start_time
    return required_time

def kss_test():
    initialize(java_options="-Xmx4g", KKMA="2.0.4", ETRI="2.0.4")

    okt = SentenceSplitter(API.OKT)
    hnn = SentenceSplitter(API.HNN)

    text = "회사 동료 분들과 다녀왔는데 분위기도 좋고 음식도 맛있었어요 다만, 강남 토끼정이 강남 쉑쉑버거 골목길로 쭉 올라가야 하는데 다들 쉑쉑버거의 유혹에 넘어갈 뻔 했답니다 강남역 맛집 토끼정의 외부 모습."

    for sent in okt(text):
        print(sent)
    print("\n")

    for sent in hnn(text):
        print(sent)
    print("\n")
    finalize()


def main():
    st_tm = datetime.fromtimestamp(time.time())
    kss_test()
    print("kss_test()===>st_time : {0}, ps_time : {1}".format(st_tm, elapsed_time(st_tm)))


if __name__ == "__main__":

    main()