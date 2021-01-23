from time import sleep
    import sys

cnt = 0

fp = open("/application/kms/test/loopout.txt",'a')
while True:
    v_str = "hello python -> " + str(cnt) +"\n"
    print(v_str)
    fp.write(v_str)
    sleep(1)
    cnt = cnt + 1
    fp.flush()
close(fp)
