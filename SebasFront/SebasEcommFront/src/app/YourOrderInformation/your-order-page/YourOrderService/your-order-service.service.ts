import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { YourOrderDataType } from 'src/app/YourOrderDataType.component';

@Injectable({
  providedIn: 'root'
})
export class YourOrderServiceService {

  constructor(private showYourOrderProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  showAllYourOrderProduct(): Observable<Array<YourOrderDataType>> {

    return this.showYourOrderProductHttp.get<Array<YourOrderDataType>>(this.serverPort + "ShowAllProductInYourOrder")
  }

  showAllYourOrderProductAfterDelete(productId: number): Observable<Array<YourOrderDataType>> {

    return this.showYourOrderProductHttp.delete<Array<YourOrderDataType>>(this.serverPort + "DeleteSpecificProductInYourOrder/" + productId)
  }
}
