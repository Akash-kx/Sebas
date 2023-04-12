import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';
import { WishListDataType } from 'src/app/WishListDataType.module';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private showProductIdHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showSearchedProduct(productId: number): Observable<ProductInventryDataType> {

    return this.showProductIdHttp.get<ProductInventryDataType>(this.serverPort + "ShowSearchedProduct/" + productId)
  }

  addProductInWishList(wishListDetail: {productId: number, productSize: string, productQuantity: string}): void {

    this.showProductIdHttp.post<{productId: number, productSize: string, productQuantity: string}>
    (this.serverPort + "AddProductInWishList", wishListDetail, { responseType: 'text' as 'json' }).subscribe()
  }

  addProductInAddToBag(addToBagDetail: {productId: number, productSize: string, productQuantity: string}): void {

    this.showProductIdHttp.post<{productId: number, productSize: string, productQuantity: string}>
    (this.serverPort + "AddProductInAddToBag", addToBagDetail, { responseType: 'text' as 'json' }).subscribe()
  }

}
