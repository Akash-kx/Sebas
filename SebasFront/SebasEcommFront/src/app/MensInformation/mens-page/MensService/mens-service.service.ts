import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

@Injectable({
  providedIn: 'root'
})
export class MensServiceService {

  constructor(private showMenProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showMensProduct(productFor: string): Observable<Array<ProductInventryDataType>> {

    return this.showMenProductHttp.get<Array<ProductInventryDataType>>(this.serverPort + "ShowAllProductForMen/" + productFor)
  }
}
