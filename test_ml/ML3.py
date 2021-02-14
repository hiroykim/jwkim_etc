import pandas as pd
from sklearn import svm, metrics, model_selection
from sklearn.model_selection import train_test_split

csv = pd.read_csv("C:/KMS_PROJECT/data/docs/iris.csv")

data = csv[["sepal.length", "sepal.width", "petal.length", "petal.width"]]
label = csv["variety"]

train_data, test_data, train_label, test_label = train_test_split(data, label)

clf = svm.SVC()

scores = model_selection.cross_val_score(clf, data, label, cv=5)
print("정답률: ", scores)
print("평균정답률: ", scores.mean())
