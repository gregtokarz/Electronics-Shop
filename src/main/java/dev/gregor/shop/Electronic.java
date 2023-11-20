package dev.gregor.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "electronics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electronic {
    @Id
    private ObjectId id;
    private String name;
    private String link;
    private String price;
}
