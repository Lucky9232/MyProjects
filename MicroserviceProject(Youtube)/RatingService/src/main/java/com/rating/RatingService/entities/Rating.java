package com.rating.RatingService.entities;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity()
@Table(name = "Rating_table")
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private  String hotelId;
    private int rating;
    private String feedback;

}
