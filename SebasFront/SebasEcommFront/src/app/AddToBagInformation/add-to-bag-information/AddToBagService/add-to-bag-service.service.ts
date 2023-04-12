import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddToBagDataType } from 'src/app/AddToBagDataType.module';
import { CardDataType } from 'src/app/CardDataType.module';

@Injectable({
  providedIn: 'root'
})
export class AddToBagServiceService {

  constructor(private showAddToCartProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showAllAddToCartProduct(): Observable<Array<AddToBagDataType>> {

    return this.showAddToCartProductHttp.get<Array<AddToBagDataType>>(this.serverPort + "ShowAllProductInAddToBag")
  }

  deleteSpecificAddToCartProduct(productId: number): Observable<Array<AddToBagDataType>> {

    return this.showAddToCartProductHttp.delete<Array<AddToBagDataType>>(this.serverPort + "DeleteSpecificProductInAddToBag/" + productId)
  }

  moveSpecificAddToCartProduct(productId: number): Observable<Array<AddToBagDataType>> {

    return this.showAddToCartProductHttp.post<Array<AddToBagDataType>>(this.serverPort + "MoveProductToWishList/" + productId ,
    { responseType: 'text' as 'json' })
  }

  updateSpecificProductInAddToCart(updateAddToCartDetail: {productId: number, productSize: string, productQuantity: number}): Observable<Array<AddToBagDataType>> {

    return this.showAddToCartProductHttp.put<Array<AddToBagDataType>>(this.serverPort + "UpdateProductInAddToBag", updateAddToCartDetail)
  }

  showAllProductIdInAddToBag(): Observable<Array<number>> {

    return this.showAddToCartProductHttp.get<Array<number>>(this.serverPort + "ShowAllProductIdInAddToBag")
  }

  moveProductToYourOrder(productIds: Array<number>): Observable<Array<AddToBagDataType>> {

    return this.showAddToCartProductHttp.post<Array<AddToBagDataType>>(this.serverPort + "MoveProductToYourOrder/" + productIds ,
    { responseType: 'text' as 'json' })
  }

  cardDetailValidate(cardDetail: CardDataType): Observable<CardDataType> {

    return this.showAddToCartProductHttp.post<CardDataType>(this.serverPort + "UserCardDetail", cardDetail,
    { responseType: 'text' as 'json'})
  }
}
