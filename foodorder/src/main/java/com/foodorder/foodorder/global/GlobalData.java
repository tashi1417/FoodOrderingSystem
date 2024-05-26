package com.foodorder.foodorder.global;

import java.util.ArrayList;
import java.util.List;

import com.foodorder.foodorder.entity.Product;

public class GlobalData {
    public static List<Product> cart;
    static{
        cart = new ArrayList<Product>();
    }
    
}
