import { Component, ElementRef, ViewChild } from '@angular/core';

import { MainServiceService } from './main-service.service';

import { Router, ActivatedRoute } from '@angular/router';
import { debounceTime, distinctUntilChanged, fromEvent, map} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SebasEcommFront';

  constructor(private mainService: MainServiceService, private router: Router, private activatesRoute: ActivatedRoute) {}

  loginDone: boolean= false
  showYourOrderPage: boolean= false

  @ViewChild('searchValue', {static: true}) searchElement!: ElementRef;
  searchedValue:string= ""

  ngOnInit(): void {

    if(sessionStorage.getItem("Token")) {

      this.loginDone= true
      this.showYourOrderPage= true
    }

    this.mainService.loginInformation.subscribe( (loginResult: boolean) => {

      this.loginDone= loginResult

      if(this.loginDone) {

        this.showYourOrderPage= true
        this.router.navigate([''], {relativeTo: this.activatesRoute})
      }
    })

    fromEvent(this.searchElement.nativeElement, 'keyup')
    .pipe(debounceTime(1000), map(data => this.searchElement.nativeElement.value), distinctUntilChanged())
    .subscribe((search: any) => {

      this.searchedValue= this.searchElement.nativeElement.value
      if(this.searchedValue === '') {

        this.router.navigate(['HomePage'])
      }
      else {

        this.searchedPage();
      }
    })
  }

  logoutButton(): void {

    sessionStorage.removeItem("Token")
  }

  searchedPage(): void {

    this.router.navigate(['SearchedPage', this.searchedValue])
  }
}
