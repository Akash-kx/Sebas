import { Injectable } from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    let JwtToken = sessionStorage.getItem("Token")

    let newHeader = request.clone({
      setHeaders: {
        Authorization : `${JwtToken}`
      }
    })

    request= newHeader
    return next.handle(request);
  }
}
