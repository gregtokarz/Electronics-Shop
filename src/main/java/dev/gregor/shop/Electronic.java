package dev.gregor.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electronic {
    @Id
    private ObjectId id;
    private String electronicId;
    private String name;
    private String category;
    private String image;
    private String new_price;
    private String old_price;
    private String description;
}
