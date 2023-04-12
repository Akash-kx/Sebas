import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

@Injectable({
  providedIn: 'root'
})
export class SearchedServiceService {

  constructor(private showSearchedProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showSearchedProduct(productFor: string): Observable<Array<ProductInventryDataType>> {

    return this.showSearchedProductHttp.get<Array<ProductInventryDataType>>(this.serverPort + "ShowAllSearchedProduct/" + productFor)
  }
}
