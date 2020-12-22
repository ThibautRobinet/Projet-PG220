from sklearn import preprocessing
from sklearn.tree import tree
from sklearn_porter import Porter
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import StratifiedKFold
from sklearn.model_selection import RandomizedSearchCV
from sklearn.model_selection import KFold
from sklearn.tree import DecisionTreeClassifier
from sklearn2pmml.pipeline import PMMLPipeline
from sklearn import svm
from sklearn2pmml import sklearn2pmml

##Loading data
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

##Training
X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.4, random_state=36851235)
scaler = preprocessing.StandardScaler().fit(X_train)
X_train_transformed = scaler.transform(X_train)
clf = svm.SVC(C=1).fit(X_train_transformed, y_train)
X_test_transformed = scaler.transform(X_test)
scores = clf.score(X_test_transformed, y_test)


crossv = StratifiedKFold(n_splits=10, random_state=36851234)
# tune GridSearchCV parameters
param_grid = {'n_neighbors': range(1, 30)}
knn = KNeighborsClassifier()
knn_randomcv = RandomizedSearchCV(knn,
                              param_grid ,
                              n_iter = 15,
                              scoring = 'f1_weighted',
                              cv = crossv,
                              random_state=36851232)
knn_randomcv = knn_randomcv.fit(X_train, y_train)

# choose best estimator
knn_best_random = knn_randomcv.best_estimator_

#### Save best estimator like pmml
pipeline = PMMLPipeline([("knn_best_estimator",knn_randomcv.best_estimator_)])

#pipeline.active_fields = X_train.columns.values
#pipeline.target_field = y_train.name

sklearn2pmml(pipeline, "KNNFit_py.pmml", debug = 'True')

# pipeline = PMMLPipeline([("classifier", DecisionTreeClassifier())])
# pipeline.fit(X, Y)
# sklearn2pmml(pipeline, "DecisionTreeIris.pmml", with_repr = True)
#
#
# porter = Porter(clf, language='java')
# output = porter.export(embed_data=False,details=False)
#
# classe = open("./src/main/java/player/SVC.java", 'w')
# classe.write("package player;\n")
# classe.write(output)
# classe.close()