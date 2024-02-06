package com.cskaoyan.digit.train;

import com.cskaoyan.digit.config.ConfigParameter;
import com.cskaoyan.digit.model.DigitResult;
import com.cskaoyan.digit.model.IntegerMatrix;

import java.util.*;

/**
 * @ClassName Perceptron
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/5 14:49
 * @Version V1.0
 **/
public class Perceptron implements TrainModel {

    //需要给每个数字0~9创建对应的权重矩阵
    private List<String> labels = Arrays.asList("0","1","2","3","4","5","6","7","8","9");

    private Map<String, IntegerMatrix> weightMatrix = new HashMap<>();

    //感知机如何训练呢？
    //感知机是需要持续不断地去纠错的，w·x的值要求是最大的
    @Override
    public void train(List<IntegerMatrix> trainImages, List<String> trainLabels) {
        //先将权重矩阵进行初始化操作
        initWeightMatrix();
        //感知机需要经过多次训练
        for (int i = 0; i < ConfigParameter.iterations; i++) {
            System.out.println("感知机进行第" + (i + 1) + "轮训练");

            for (int n = 0; n < trainImages.size(); n++) {
                IntegerMatrix trainData = trainImages.get(n);
                String guessNumber =  classify(trainData);
                String actualNumber = trainLabels.get(n);
                if(!guessNumber.equals(actualNumber)){
                    //没有猜对，
                    learn(guessNumber, actualNumber, trainData);
                }
            }
        }
    }

    //去猜测究竟是数字几？实际上是不是只要求找到一个w·x最大的即可 w·x = w1x1 + w2x2 + w3x3 + ....+ w784x784
    //不就等于w0,0 x0,0 + w1,0 x1,0
    //f(x) = w·x + b
    //f(x) = w3·x - w5·x
    private String classify(IntegerMatrix trainData) {
        //从0~9依次去猜
        //我们要去取最大的result对应的数字
        TreeSet<DigitResult> treeSet = new TreeSet<>(new Comparator<DigitResult>() {
            @Override
            public int compare(DigitResult o1, DigitResult o2) {
                if(o1.result > o2.result){
                    return 1;
                }
                return -1;
            }
        });
        for (String label : labels) {
            int result = 0;
            IntegerMatrix weight = weightMatrix.get(label);
            result = trainData.multiply(weight);
            treeSet.add(new DigitResult(label, result));
        }
        //取出最大的，也就是最后一个
        return treeSet.pollLast().label;
    }

    private void learn(String guessNumber, String actualNumber, IntegerMatrix trainData) {
        //将guess的权重降低；将实际的权重增加
        IntegerMatrix guessWeight = weightMatrix.get(guessNumber);
        IntegerMatrix actualWeight = weightMatrix.get(actualNumber);
        guessWeight.removeWeight(trainData);
        actualWeight.increaseWeight(trainData);
    }

    private void initWeightMatrix() {
        for (String label : labels) {
            // label:0~9每个数字
            weightMatrix.put(label, new IntegerMatrix(28));
        }
    }

    @Override
    public void validate(List<IntegerMatrix> validationImages, List<String> validationLabels) {
        int wrong = 0;
        for (int n = 0; n < validationImages.size(); n++) {
            IntegerMatrix validateData = validationImages.get(n);
            String actualNumber = validationLabels.get(n);
            String guessNumber = classify(validateData);
            if(!actualNumber.equals(guessNumber)){
                wrong ++;
            }
        }
        Integer size = validationImages.size();
        double rate = (size - wrong) * 100 / size;
        System.out.println("使用感知机识别的准确率为" + rate + "%");
    }
}
