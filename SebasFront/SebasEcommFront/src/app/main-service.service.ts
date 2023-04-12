import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MainServiceService {

  constructor() { }

  loginInformation= new EventEmitter<boolean>();
}
