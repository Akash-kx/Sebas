import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

@Injectable({
  providedIn: 'root'
})
export class WomensServiceService {

  constructor(private showWomenProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showWomensProduct(productFor: string): Observable<Array<ProductInventryDataType>> {

    return this.showWomenProductHttp.get<Array<ProductInventryDataType>>(this.serverPort + "ShowAllProductForWomen/" + productFor)
  }
}
