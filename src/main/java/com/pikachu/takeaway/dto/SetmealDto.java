package com.pikachu.takeaway.dto;

import com.pikachu.takeaway.entity.Setmeal;
import com.pikachu.takeaway.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
