import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/model/Product.model';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/model/Category.model';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  productForm : FormGroup;
  categoryItems : Category[] = [];
  constructor(private fb : FormBuilder, 
    private productservice : ProductService,
    private categoryService: CategoryService,
    private router: Router) { }

  ngOnInit() {
    this.loadCategories();
    this.initForm();
  }

  loadCategories() {
    this.categoryService.getAllCategories().subscribe(
      (data : Category[]) => {
        this.categoryItems = data;
      }
    );
  }

  initForm(){
    this.productForm = this.fb.group(
      {
        name : this.fb.control(""),
        description : this.fb.control(""),
        price : this.fb.control(""),
        cat_id : this.fb.control("")
      }
    );
  }

  addNewProduct(){
    this.productservice.addProduct(
      new Product(null, 
                  this.productForm.value.name, 
                  this.productForm.value.description, 
                  this.productForm.value.price,
                  new Category(this.productForm.value.cat_id, "","")
                  )
    );
    this.router.navigate(["/productsList"]);
  }

}
