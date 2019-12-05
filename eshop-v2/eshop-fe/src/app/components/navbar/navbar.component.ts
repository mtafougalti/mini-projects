import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private productService : ProductService) { }

  ngOnInit() {
  }

  searchProducts(form : NgForm) {
    console.log("Keyword : " + form.value.keyWord);
    //this.productService.findProductsByKeyWord(form.value.keyWord);
  }

}
