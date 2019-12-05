import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private httpClient : HttpClient) { 

  }

  addProduct(p :Product){
    this.httpClient.post("http://localhost:8080/products/add", p)
                   .subscribe(
                     data => {
                       console.log("Product saved successfully.")
                     },
                     error => {
                      console.log("Error : " + error.value)
                     }
                   );
  }

  getAllProducts(){
    return this.httpClient.get("http://localhost:8080/products/list");
  }
}
