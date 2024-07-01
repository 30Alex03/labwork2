package Main;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.interval.ConfidenceInterval;


public class Calculator {
    
     public static double calculationGeometricMean(double[] sample) {
        return StatUtils.geometricMean(sample);
    }

    public static double calculationMean(double[] sample) {
        return StatUtils.mean(sample);
    }

    public static double calculationSD(double[] sample) {
        StandardDeviation sd = new StandardDeviation();
        return sd.evaluate(sample);
    }

    public static double calculationRange(double[] sample) {
        return StatUtils.max(sample) - StatUtils.min(sample);
    }

    public static double calculationCovariance(double[] sample1, double[] sample2) {
        Covariance covariance = new Covariance();
        return covariance.covariance(sample1, sample2);
    }

    public static double calculationSize(double[] sample) {
        return sample.length;
    }

    public static double calculationCoeffVariance(double[] sample) {
        StandardDeviation sd = new StandardDeviation();
        double mean = StatUtils.mean(sample);
        return sd.evaluate(sample) / mean;
    }

    public static ConfidenceInterval calculationConfidanceInterval(double[] sample, double alpha) {
        StandardDeviation sd = new StandardDeviation();
        double mean = StatUtils.mean(sample);
        double standartDeviation = sd.evaluate(sample);
        NormalDistribution nd = new NormalDistribution();
        double quiantile = nd.inverseCumulativeProbability(1.0 - alpha / 2.0);
        double marginOfError = quiantile * standartDeviation / Math.sqrt(sample.length);
        return new ConfidenceInterval(mean - marginOfError, mean + marginOfError, 1.0 - alpha);
    }

    public static double calculationVar(double[] sample) {
        Variance variance = new Variance();
        return variance.evaluate(sample);
    }

    public static double calculationMin(double[] sample) {
        return StatUtils.min(sample);
    }

    public static double calculationMax(double[] sample) {
        return StatUtils.max(sample);
    }

    public static double[][] CovMatrix(Map<String, double[]> samples) {
        String[] keyArray = samples.keySet().toArray(new String[0]);
        double[][] covarianceMatrix = new double[keyArray.length][keyArray.length];
        for (int i = 0; i < keyArray.length; i++) {
            for (int j = 0; j < keyArray.length; j++) {
                covarianceMatrix[i][j] = calculationCovariance(samples.get(keyArray[i]), samples.get(keyArray[j]));
            }
        }
        return covarianceMatrix;
    }

    public static Map<String, double[]> getCalculations(Map<String, double[]> data) {
        Map<String, double[]> answers = new HashMap<>();
        int numberOfSamples = data.keySet().size();
        double[] geomenticMean = new double[numberOfSamples];
        double[] mean = new double[numberOfSamples];
        double[] sd = new double[numberOfSamples];
        double[] range = new double[numberOfSamples];
        double[] size = new double[numberOfSamples];
        double[] max = new double[numberOfSamples];
        double[] min = new double[numberOfSamples];
        double[] coefvariance = new double[numberOfSamples];
        double[] var = new double[numberOfSamples];
        double[] intervalLower = new double[numberOfSamples];
        double[] intervalUpper = new double[numberOfSamples];
        double[] confidanceLevel = new double[numberOfSamples];
        int i = 0;
        for (String key : data.keySet()) {
            double[] sample = data.get(key);
            geomenticMean[i] = calculationGeometricMean(sample);
            mean[i] = calculationMean(sample);
            sd[i] = calculationSD(sample);
            range[i] = calculationRange(sample);
            size[i] = calculationSize(sample);
            max[i] = calculationMax(sample);
            min[i] = calculationMin(sample);
            var[i] = calculationVar(sample);
            coefvariance[i] = calculationCoeffVariance(sample);
            ConfidenceInterval interval = calculationConfidanceInterval(sample, 0.05);
            intervalLower[i] = interval.getLowerBound();
            intervalUpper[i] = interval.getUpperBound();
            confidanceLevel[i] = interval.getConfidenceLevel();
            i++;
        }
        answers.put("Среднее геом.", geomenticMean);
        answers.put("Среднее арифм", mean);
        answers.put("Оценка стандартного отколнения", sd);
        answers.put("Размах", range);
        answers.put("Количество элементов", size);
        answers.put("Максимум", max);
        answers.put("Минимум", min);
        answers.put("Дисперсия", var);
        answers.put("Коэф. вариации", coefvariance);
        answers.put("Нижняя граница дов. интервала", intervalLower);
        answers.put("Верхняя граница дов.интервала", intervalUpper);
        answers.put("Confidance level", confidanceLevel);
        return answers;
    }

    
}
