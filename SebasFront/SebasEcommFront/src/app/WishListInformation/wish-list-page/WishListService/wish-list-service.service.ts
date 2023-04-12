import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WishListDataType } from 'src/app/WishListDataType.module';

@Injectable({
  providedIn: 'root'
})
export class WishListServiceService {

  constructor(private showWishListProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showAllWishListProduct(): Observable<Array<WishListDataType>> {

    return this.showWishListProductHttp.get<Array<WishListDataType>>(this.serverPort + "ShowAllProductInWishList")
  }

  deleteSpecificWishListProduct(productId: number): Observable<Array<WishListDataType>> {

    return this.showWishListProductHttp.delete<Array<WishListDataType>>(this.serverPort + "DeleteSpecificProductInWishList/" + productId)
  }

  addProductInAddToBagFromWishListProduct(productId: number): Observable<Array<WishListDataType>> {

    return this.showWishListProductHttp.post<Array<WishListDataType>>(this.serverPort + "AddProductInAddToBagFromWishList/" + productId, { responseType: 'text' as 'json' })
  }
}
