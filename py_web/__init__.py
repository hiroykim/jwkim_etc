from flask import Flask, Response, make_response

app = Flask(__name__)

@app.route('/res1')
def res1():
    custom_res = Response("Custrom Response",200,{"test json":"My Value"})
    return make_response(custom_res)

@app.route("/")
def helloworld():
    return "Hello Flask"