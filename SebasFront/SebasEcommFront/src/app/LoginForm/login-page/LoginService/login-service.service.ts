import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private mensProductHttp: HttpClient) { }

  serverPort: string= "http://localhost:8080/"

  loginFormData(LoginInformation: any): Observable<string> {

    return this.mensProductHttp.post<any>(this.serverPort + "AddLoginInformation", LoginInformation,
    { responseType: 'text' as 'json' })
  }
}
