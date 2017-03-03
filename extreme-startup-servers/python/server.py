from flask import Flask
from flask import request, jsonify

app = Flask(__name__)


@app.route("/")
def hello():
    query = request.args.get('q')
    id = request.args.get('id')
    return calculate_reply(query, id)


def calculate_reply(query, id):
    return jsonify({'id': id, 'r': })

if __name__ == "__main__":
    app.run(port=1337)