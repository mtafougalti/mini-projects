import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import * as rxjs from 'rxjs';
import { Observable } from 'rxjs/index';
import { Product } from 'src/app/model/Product.model';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  productList: Array<Object>;
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getAllProducts().subscribe(
      (data: Product[]) => {
        this.productList = data;
        console.log("Products loaded successfully : " + this.productList.length)
        this.productList.forEach((p: Product) => {
          console.log("Product : " + p.name);
        });
      },
      error => {
        console.log("Error : " + error.value)
      }
    );
  }

}
