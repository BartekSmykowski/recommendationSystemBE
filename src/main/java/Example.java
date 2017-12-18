import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.util.List;

public class Example {

    public static void main(String[] args) throws Exception {

        File dataFile = new File("src/main/resources/inputData.csv");
        File resultFile = new File("src/main/resources/result.csv");

        DataModel model = new FileDataModel(dataFile);

        //UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        ItemSimilarity similarity = new EuclideanDistanceSimilarity(model);

        //UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);

        //UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        ItemBasedRecommender recommender = new GenericItemBasedRecommender(model,similarity);

        List<RecommendedItem> recommendations = recommender.recommend(2, 5);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }


}
