package com.example.demopojo.controllers;

import com.example.demopojo.models.Product;
import com.example.demopojo.services.FileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {


    private FileUploadService fileUploadService;

    public ProductController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    private List<Product> products = new ArrayList<>();


    @GetMapping("/product/all")
    public String showAllProductForm(Model model) {
        model.addAttribute("products", products);

        return "product";
    }

    @GetMapping("/product/one")
    public String showOneProductForm(Model model) {
        model.addAttribute("products", products);

        return "product";
    }

    @GetMapping("/product/add")
    public String showAddProductForm(Model model) {

        model.addAttribute("product", new Product());
        return "add-product";
    }



    @PostMapping("/product/add/submit")
    public String addProduct(Product product,@RequestParam("my-file") List<MultipartFile> files) {

        product.setProImages(this.fileUploadService.upload(files));

        this.products.add(product);

        return "redirect:/product/all";
    }


}
