package ru.geekbrains.socialnetwork.data;

import com.google.firebase.Timestamp;

import java.util.HashMap;
import java.util.Map;

public class CardDataMapping {

    public static class Fields{
        public final static String PICTURE = "picture";
        public final static String DATE = "date";
        public final static String TITLE = "title";
        public final static String DESCRIPTION = "description";
        public final static String LIKE = "like";
    }

    public static CardData toCardData(String id, Map<String, Object> doc) {
        long indexPic = (long) doc.get(Fields.PICTURE);
        Timestamp timeStamp = (Timestamp)doc.get(Fields.DATE);
        CardData answer = new CardData((String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.DESCRIPTION),
                PictureIndexConverter.getPictureByIndex((int) indexPic),
                (boolean) doc.get(Fields.LIKE),
                timeStamp.toDate());
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(CardData cardData){
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, cardData.getTitle());
        answer.put(Fields.DESCRIPTION, cardData.getDescription());
        answer.put(Fields.PICTURE, PictureIndexConverter.getIndexByPicture(cardData.getPicture()));
        answer.put(Fields.LIKE, cardData.isLike());
        answer.put(Fields.DATE, cardData.getDate());
        return answer;
    }
}
