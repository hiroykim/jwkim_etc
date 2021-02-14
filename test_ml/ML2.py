import pandas as pd
from sklearn import svm, metrics
from sklearn.model_selection import train_test_split

csv = pd.read_csv("C:/KMS_PROJECT/data/docs/iris.csv")

data = csv[["sepal.length", "sepal.width", "petal.length", "petal.width"]]
label = csv["variety"]

train_data, test_data, train_label, test_label = train_test_split(data, label)

#print(data)
#print(label)

clf = svm.SVC()
clf.fit(train_data, train_label)
results = clf.predict(test_data)
score = metrics.accuracy_score(test_label, results)
report = metrics.classification_report(test_label, results)
print("정답률: ", score)
print("보고서: ", report)
