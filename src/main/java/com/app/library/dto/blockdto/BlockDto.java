package com.app.library.dto.blockdto;

import lombok.Builder;
import lombok.Data;

@Data
public abstract class BlockDto {
    private Integer id;
    private  String blockName; // we Have using T to making this variable without a specified type
    private int number_pro; // this variable for counting the number of  properties;
    private int av_pro; //

}
