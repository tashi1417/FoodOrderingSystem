package com.foodorder.foodorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.foodorder.foodorder.entity.Product;
import com.foodorder.foodorder.service.CategoryService;
import com.foodorder.foodorder.service.ProductService;

import jakarta.servlet.http.HttpSession;

// @Controller
// public class homeController {

//     @Autowired
//     CategoryService categoryService;
//     @Autowired
//     ProductService productService;


//     @GetMapping({"/","/home"})
//     public String home( Model model){

//             model.addAttribute("cartCount", GlobalData.cart.size());

//             return "index";
//         }
    

//     @GetMapping("/shop")
//     public String shop(Model model){
//         model.addAttribute("categories",categoryService.getAllCategory());
//         model.addAttribute("products", productService.getAllProduct());
//         model.addAttribute("cartCount", GlobalData.cart.size());

//         return "shop";
//     }


//     @GetMapping("/shop/category/{id}")
//     public String shopByCategory(Model model, @PathVariable int id){
//         model.addAttribute("categories",categoryService.getAllCategory());
//         model.addAttribute("cartCount", GlobalData.cart.size());

//         model.addAttribute("products", productService.getAllProductsByCategoryId(id));
//         return "shop";

//     }

//     @GetMapping("/shop/viewproduct/{id}")
//     public String viewProduct(Model model, @PathVariable int id){
//         model.addAttribute("product",productService.getProductById(id).get());
//         model.addAttribute("cartCount", GlobalData.cart.size());

//         return "viewProduct";
        
//     }


    
    


// }


@Controller
public class homeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public List<Product> getCart(HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping({"/","/home"})
    public String home( Model model, @ModelAttribute("cart") List<Product> cart){

            model.addAttribute("cartCount", cart.size());

            return "index";
        }
    

    @GetMapping("/shop")
    public String shop(Model model, @ModelAttribute("cart") List<Product> cart){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("cartCount", cart.size());

        return "shop";
    }


    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id, @ModelAttribute("cart") List<Product> cart){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("cartCount", cart.size());

        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "shop";

    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id, @ModelAttribute("cart") List<Product> cart){
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount", cart.size());

        return "viewProduct";
        
    }



    
    


}
