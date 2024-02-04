package com.cskaoyan.digit.train;

import com.cskaoyan.digit.config.ConfigParameter;
import com.cskaoyan.digit.model.DoubleMatrix;
import com.cskaoyan.digit.model.IntegerMatrix;
import com.cskaoyan.digit.utils.Constant;

import java.util.*;

/**
 * @ClassName NaiveBayes
 * @Description: TODO
 * 使用朴素贝叶斯的方式来去求数字识别为某个数字的概率问题
 * 对应的公式：
 * P(Digit0)·P(C0,0=0|Digit0)·........P(C27,27=0|Digit0)------猜测这个数字是0
 * P(Digit1)·P(C0,0=0|Digit1)·........P(C27,27=0|Digit1)------猜测这个数字是1
 * P(Digit2)·P(C0,0=0|Digit2)·........P(C27,27=0|Digit2)------猜测这个数字是2
 * P(Digit3)·P(C0,0=0|Digit3)·........P(C27,27=0|Digit3)------猜测这个数字是3
 * P(Digit4)·P(C0,0=0|Digit4)·........P(C27,27=0|Digit4)------猜测这个数字是4
 * P(Digit5)·P(C0,0=0|Digit5)·........P(C27,27=0|Digit5)------猜测这个数字是5
 * P(Digit6)·P(C0,0=0|Digit6)·........P(C27,27=0|Digit6)------猜测这个数字是6
 * P(Digit7)·P(C0,0=0|Digit7)·........P(C27,27=0|Digit7)------猜测这个数字是7
 * P(Digit8)·P(C0,0=0|Digit8)·........P(C27,27=0|Digit8)------猜测这个数字是8
 * P(Digit9)·P(C0,0=0|Digit9)·........P(C27,27=0|Digit9)------猜测这个数字是9
 * 只要求出上述10个概率值，取出一个最大的概率值，那么便是我们猜测的结果数字
 * 在此期间还需要引入平滑度，防止出现0概率，导致最终结果全部都是0
 * 还需要引入lg和的形式，防止小数相乘之后导致的数值急剧缩小，无法比较的情况
 * 1.先解决P(Digit0)~P(Digit9)先验概率的问题
 * 2.需要获取每个数字对应的全部训练集的矩阵，统计每一位出现0和1的次数；每个数字需要有两个矩阵：0矩阵  1矩阵；0矩阵里面存放每一位出现0的次数情况；1矩阵存放每一位出现1的次数情况，用什么数据结构呢？把0矩阵和1矩阵放到map中；再把这个map放到数字对应的map value中，也就是一个大map嵌套着一个小map
 * 3、加入一个平滑度，防止出现概率0的情况
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/4 10:23
 * @Version V1.0
 **/
public class NaiveBayes implements TrainModel{

    //这个容器用来存放0~9数字出现的次数
    private Map<String, Integer> frequencyMap = new HashMap<>();

    //用来去存储0~9数字在训练集中出现的概率 = 次数 / 总次数   此时不需要引入平滑度
    private Map<String, Double> probabilityMap = new HashMap<>();

    //外层map的String表示的是数字label 0~9;里面的map String表示的是0矩阵还是1矩阵，IntegerMatrix就是对应的矩阵
    private Map<String, Map<String, IntegerMatrix>> countMatrix = new HashMap<>();


    //概率矩阵
    //外层map的String key还是一样的是每个数字0~9；里面的map的String依然是特征0或者特征1；DoubleMatrix里面存放的是每一位的概率
    private Map<String, Map<String, DoubleMatrix>> probabilityMatrix = new HashMap<>();



    //先定义一个list用来存放0~9
    private List<String> labels = Arrays.asList("0","1","2","3","4","5","6","7","8","9");

    //计算每个数字0~9的先验概率
    private void calculateProbability(List<String> trainLabels) {
        for (String label : trainLabels) {
            // label:0~9
            Integer times = frequencyMap.getOrDefault(label, 0);
            times ++;
            frequencyMap.put(label, times);
        }
        Set<String> keySet = frequencyMap.keySet();
        for (String label : keySet) {
            Integer times = frequencyMap.get(label);
            double v = times.doubleValue() / trainLabels.size();
            probabilityMap.put(label, v);
        }
    }

    @Override
    public void train(List<IntegerMatrix> trainImages, List<String> trainLabels) {
        //计算先验概率
        calculateProbability(trainLabels);

        //获取次数矩阵
        generateCountMatrix(trainImages, trainLabels);

        //加入平滑度
        increaseSmoothing();

        //随后我们就可以去统计概率矩阵了
        generateProbabilityMatrix();
    }

    //模型训练过后，我们使用验证数据集对于我们的模型进行验证
    @Override
    public void validate(List<IntegerMatrix> validationImages, List<String> validationLabels) {
        int wrong = 0;
        for (int i = 0; i < validationImages.size(); i++) {
            //给了一个矩阵，那么该矩阵的每一位的0或者1的情况是知道的
            //你分别猜测是0~9，带入其中，计算概率值；概率最大的便是我们推测的数字
            IntegerMatrix validationMatrix = validationImages.get(i);
            //标记的正确的数字
            String actuallabel = validationLabels.get(i);
            String guessLabel = guess(validationMatrix);
            if(!guessLabel.equals(actuallabel)){
                //如果猜测的数字和最终的数字不一致，那么wrong +1
                wrong ++;
            }
        }
        Integer totalSize = validationLabels.size();
        double rate = (totalSize - wrong) * 100.0 / totalSize;
        System.out.println("使用朴素贝叶斯模型训练过后，统计的准确率为" + rate + "%");
    }

    private String guess(IntegerMatrix validationMatrix) {
        //给定了一个矩阵，里面每一位是0还是1我们是可以知道的，假设它是0，计算其总概率值，假设是1，计算其总概率值......直至最后取出概率值最大的一个，那么便是猜测的数字
        for (int i = 0; i < labels.size(); i++) {
            String label = labels.get(i);
            //计算在当前数字label情况下，该矩阵每一位是0还是1的概率值
            double result = 0.0;
//            P(Digitn)·P(C0,0=0|Digitn)·........P(C27,27=0|Digitn)----->导致数值很小，采用lg和的方式不会改变最终的大小关系lg(P(Digitn)) + lg(P(C0,0=0|Digitn)) + .....+ lg(P(C27,27=0|Digitn))
            result += Math.log10(probabilityMap.get(label));

        }
        return null;
    }

    //生成概率矩阵
    private void generateProbabilityMatrix() {
        initProbabilityMatrix();

        calculateProbabilityMatrix();
    }

    private void calculateProbabilityMatrix() {
        //这个方法里面应该要处理countMatrix，去得到probabilityMatrix
        for (String label : labels) {
            //当前数字对应的次数矩阵  里面是特征0 还有特征1 两个矩阵
            Map<String, IntegerMatrix> featureCountMap = countMatrix.get(label);
            Integer totalSize = frequencyMap.get(label);
            Map<String, DoubleMatrix> featureProbabilityMap = probabilityMatrix.get(label);
            //分别去处理特征0和特征1的次数矩阵，得到对应的概率矩阵
            //features:0、1
            Set<String> features = featureCountMap.keySet();
            for (String feature : features) {
                //得到的是某个数字对应的0或者1的次数矩阵
                IntegerMatrix countMatrixOfFeature = featureCountMap.get(feature);
                //某个数字对应的特征0或者特征1的概率矩阵
                DoubleMatrix probabilityMatrixOfFeature = featureProbabilityMap.get(feature);
                for (int y = 0; y < countMatrixOfFeature.element.length; y++) {
                    for (int x = 0; x < countMatrixOfFeature.element[y].length; x++) {
                        Integer times = countMatrixOfFeature.element[y][x];
                        //需要得到当前label总次数
                        double v = times.doubleValue() / (totalSize + 2 * ConfigParameter.smoothing);
                        probabilityMatrixOfFeature.element[y][x] = v;
                    }
                }
            }
        }
    }

    //初始化概率矩阵中，我们需要给里面的矩阵初始化，填充
    private void initProbabilityMatrix() {
        for (String label : labels) {
            Map<String, DoubleMatrix> featureProbability = new HashMap<>();
            featureProbability.put(Constant.FEATURE_ZERO, new DoubleMatrix(28));
            featureProbability.put(Constant.FEATURE_ONE, new DoubleMatrix(28));
            probabilityMatrix.put(label, featureProbability);
        }
    }

    //给次数矩阵添加一个平滑度，防止出现次数0导致概率为0的情况发生
    private void increaseSmoothing() {
        Set<String> keySet = countMatrix.keySet();
        for (String label : keySet) {
            Map<String, IntegerMatrix> featureMap = countMatrix.get(label);
            IntegerMatrix oneMatrix = featureMap.get(Constant.FEATURE_ONE);
            IntegerMatrix zeroMatrix = featureMap.get(Constant.FEATURE_ZERO);
            oneMatrix.add(ConfigParameter.smoothing);
            zeroMatrix.add(ConfigParameter.smoothing);
        }
    }

    private void generateCountMatrix(List<IntegerMatrix> trainImages, List<String> trainLabels) {
        //初始化次数矩阵
        initCountMatrix();

        //填充次数矩阵，需要做的事情便是在训练集中找到每个数字对应的全部矩阵，分别统计每一位出现0还是1的次数，相加
        calculateCountMatrix(trainImages, trainLabels);
    }

    //计算每个数字对应的次数矩阵信息
    private void calculateCountMatrix(List<IntegerMatrix> trainImages, List<String> trainLabels) {
        for (int i = 0; i < trainLabels.size(); i++) {
            String label = trainLabels.get(i);
            IntegerMatrix dataMatrix = trainImages.get(i);
            Map<String, IntegerMatrix> featureMap = countMatrix.get(label);
            //下面两个分别是次数0矩阵和次数1矩阵，分别用来统计每一位出现0还是1的次数
            IntegerMatrix zeroMatrix = featureMap.get(Constant.FEATURE_ZERO);
            IntegerMatrix oneMatrix = featureMap.get(Constant.FEATURE_ONE);
            for (int y = 0; y < dataMatrix.element.length; y++) {
                for (int x = 0; x < dataMatrix.element[y].length; x++) {
                    int v = dataMatrix.element[y][x];
                    if(v == 0){
                        //次数0矩阵中对应位置+1
                        zeroMatrix.element[y][x] ++;
                    }else {
                        //次数1矩阵中对应的位置+1
                        oneMatrix.element[y][x] ++;
                    }
                }
            }
        }
    }

    //初始化次数矩阵
    private void initCountMatrix() {
        for (String label : labels) {
            Map<String, IntegerMatrix> featureMap = new HashMap<>();
            featureMap.put(Constant.FEATURE_ZERO, new IntegerMatrix(28));
            featureMap.put(Constant.FEATURE_ONE, new IntegerMatrix(28));
            countMatrix.put(label, featureMap);
        }
    }


}
