// package com.foodorder.foodorder.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import com.foodorder.foodorder.entity.Product;
// import com.foodorder.foodorder.global.GlobalData;
// import com.foodorder.foodorder.service.ProductService;

// public class CartController {
//     @Autowired
//     ProductService productService;


//     @GetMapping("/checkout")
//     public String checkout(){
//         return "checkout";
//     }

//     @GetMapping("/addToCart/{id}")
//     public String addToCart(@PathVariable int id){
//     GlobalData.cart.add(productService.getProductById(id).get());
//     return "redirect:/cart";
// }

//     @GetMapping("/cart")
//     public String cartGet(Model model){
//         model.addAttribute("cartCount", GlobalData.cart.size());
//         model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
//         model.addAttribute("cart", GlobalData.cart);
//         return "cart";  
//     }





// }


package com.foodorder.foodorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foodorder.foodorder.entity.Product;
import com.foodorder.foodorder.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    ProductService productService;


    @GetMapping("/addToCart/{id}")
public String addToCart(@PathVariable int id, HttpSession session) {
    Product product = productService.getProductById(id).get();
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList<>();
        session.setAttribute("cart", cart);
    }
    cart.add(product);
    return "redirect:/shop";
}

    @GetMapping("/cart")
    public String cartGet(Model model, @ModelAttribute("cart") List<Product> cart) {
        model.addAttribute("cartCount", cart.size());
        model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
        return "cart";  
    }
    
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart != null) {
            cart.remove(index);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }
    
    @GetMapping("/checkout")
    public String checkout(Model model) {
        List<Product> cart = (List<Product>) model.getAttribute("cart");
        if (cart != null) {
            model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
        }
        return "checkout";
    }

   

}