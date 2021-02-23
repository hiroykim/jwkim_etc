import os
import time
import socket
import pickle

# -*- coding: utf-8 -*-
def nslookup(DOMAIN):
    try:
        ip_list = []
        ais = socket.getaddrinfo(DOMAIN,0,0,0,0)
        for result in ais:
            ip_list.append(result[-1][0])
        ip_list = list(set(ip_list))
        return (',').join(ip_list)
    except:
        return "N/A"

def init():
    dns_dict = {"pypi.python.org" : "151.101.76.223", "pypi.org" : "151.101.0.223"}
    with open("pip.dat","wb") as fp:
        pickle.dump(dns_dict,fp)

def rd_dat():
    with open("pip.dat","rb") as fp:
        dns_dict = pickle.load(fp)

    return dns_dict

def check_dns(k, v):
    rst_list = nslookup(k)
    if v in rst_list:
        print("Good")
        print(v , "==", rst_list)
    else:
        print("Changed")
        print(v, "!=", rst_list)

def main():
    #init()
    dns_dict = rd_dat()
    for k, v in dns_dict.items():
        check_dns(k, v)


if __name__ == "__main__":
    main()
