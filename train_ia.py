from sklearn import svm
from sklearn.tree import tree
from sklearn_porter import Porter
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import KFold

file = open("human_move.txt", "r")
lines = file.readlines()
file.close();

X,Y = [],[];
for i in range(0,len(lines)):
    x = []
    pred = False
    for c in lines[i]:
        if (pred == True):
            X.append(x)
            Y.append(int(c))
            break;
        if (c == '/'):
            pred = True
        else:
            x.append(int(c))

#clf = svm.SVC(kernel='linear', C=1)
clf = tree.DecisionTreeClassifier()
clf.fit(X,Y)
scores = cross_val_score(clf, X, Y, cv=10)

clf = tree.DecisionTreeClassifier()
clf.fit(X, Y)

# Export:
porter = Porter(clf, language='java')
output = porter.export(embed_data=True)
print(output)
classe = open("./src/main/java/player/DecisionTreeClassifier.java", 'w')
classe.write("package player;\n")
classe.write(output)
classe.close()
# kf = KFold(n_splits=2)
# for train, test in kf.split(X):
#     print(train)
#     clf.fit(train)



# knn = KNeighborsClassifier(5)
# knn.fit(X,Y)
#
# porter = Porter(clf, language='java')
# output = porter.export(embed_data=False)
#print(output)
#


# knnPorter = Porter(knn, language='java')
# output = knnPorter.export(embed_data=True)
# print(output)
#
# classe = open("./src/main/java/player/KNeighborsClassifier.java", 'w')
# classe.write("package player;\n")
# classe.write(output)
# classe.close()








