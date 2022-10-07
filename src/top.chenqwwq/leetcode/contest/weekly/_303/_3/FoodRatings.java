package top.chenqwwq.leetcode.contest.weekly._303._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/7/24
 **/
public class FoodRatings {
    static class RatingAndCuisine {
        public Integer rating;
        public String cuisine;

        public RatingAndCuisine(Integer rating, String cuisine) {
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }

    static class RatingAndName{
        public Integer rating;
        public String name;

        public RatingAndName(Integer rating, String name) {
            this.rating = rating;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RatingAndName that = (RatingAndName) o;
            return Objects.equals(rating, that.rating) && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rating, name);
        }
    }

    Map<String, RatingAndCuisine> food2Info;
    Map<String, TreeSet<RatingAndName>> cuisine2FoodAndRating;
    Comparator<RatingAndName> comp;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        food2Info = new HashMap<>();
        cuisine2FoodAndRating = new HashMap<>();
         comp = ((Comparator<RatingAndName>) (o1, o2) -> o2.rating.compareTo(
                o1.rating)).thenComparing(o -> o.name);
        for(int i = 0;i < foods.length;i++){
            food2Info.put(foods[i],new RatingAndCuisine(ratings[i],cuisines[i]));
            if(!cuisine2FoodAndRating.containsKey(cuisines[i])){
                cuisine2FoodAndRating.put(cuisines[i],new TreeSet<>(this.comp));
            }
            cuisine2FoodAndRating.get(cuisines[i]).add(new RatingAndName(ratings[i],foods[i]));
        }
    }
    // [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
    // [null, "kimchi", "ramen", null, "sushi", null, "ramen"]

    public void changeRating(String food, int newRating) {
        if (!food2Info.containsKey(food)) {
            return;
        }
        RatingAndCuisine info = food2Info.get(food);
        if(info.rating == newRating){
            return;
        }
        cuisine2FoodAndRating.get(info.cuisine).remove(new RatingAndName(info.rating,food));
        cuisine2FoodAndRating.get(info.cuisine).add(new RatingAndName(newRating,food));
        food2Info.put(food,new RatingAndCuisine(newRating,info.cuisine));
    }

    public String highestRated(String cuisine) {
        TreeSet<RatingAndName> entries = cuisine2FoodAndRating.get(cuisine);
        if (entries.isEmpty()) {
            return "";
        }
        return entries.first().name;
    }
}