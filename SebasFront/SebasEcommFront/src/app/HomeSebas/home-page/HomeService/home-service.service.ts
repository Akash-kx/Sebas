import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductInventryDataType } from 'src/app/ProductInventryDataType.module';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

  constructor(private showProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showAllProductInInventory(): Observable<Array<ProductInventryDataType>> {

    return this.showProductHttp.get<Array<ProductInventryDataType>>(this.serverPort + "ShowOnlySpecificProduct")
  }
}
