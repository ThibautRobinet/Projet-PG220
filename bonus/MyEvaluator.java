package main.java.player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.EvaluatorUtil;
import org.jpmml.evaluator.InputField;

import org.jpmml.evaluator.LoadingModelEvaluatorBuilder;
import org.jpmml.evaluator.TargetField;
import org.xml.sax.SAXException;

public class MyEvaluator{

    private Evaluator evaluator;

    MyEvaluator(){
        try {
            this.evaluator = new LoadingModelEvaluatorBuilder().load(new File("KNNFit_py.pmml")).build();
            evaluator.verify();
        } catch (IOException | SAXException | JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Map<FieldName, ?> prepareArgs(Evaluator evaluator, double[] board) {
        Map<FieldName, Double> pmmlArguments = new HashMap<>();

        List<InputField> activeFields = evaluator.getActiveFields();
        for (InputField activeField : activeFields) {
            FieldName fn = activeField.getFieldName();
            String name = fn.getValue();
            int j = Integer.parseInt(name.substring(1));
            //System.out.println("fn " + fn + " : " + i+ " : " + j);
            pmmlArguments.put(fn,board[j-1]);
        }

        return pmmlArguments;
    }

    public int evaluate(double[] board) {
        Map<FieldName, ?> args = prepareArgs(evaluator, board);
        Map<FieldName,?> results = evaluator.evaluate(args);
        int r = 0;
        List<TargetField> targetFields = evaluator.getTargetFields();
        for(TargetField targetField : targetFields){
            Object targetValue = results.get(targetField.getName());
            //Object u = ((Map<String, ?>) targetValue).get("result");
            r = (int)EvaluatorUtil.decode(targetValue);
            //System.out.println("outPut: "+ r+ "/"+ targetValue );
        }
        return r;
    }
}
