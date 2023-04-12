import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePage } from './HomeSebas/home-page/home-page.component';
import { ProductPageComponent } from './ProductInformation/product-page/product-page.component';
import { MensPageComponent } from './MensInformation/mens-page/mens-page.component';
import { LoginPageComponent } from './LoginForm/login-page/login-page.component';
import { JwtInterInterceptor } from './jwt-inter.interceptor';
import { WomensPageComponent } from './WomensInformation/womens-page/womens-page.component';
import { SearchedPageComponent } from './SearchedInformation/searched-page/searched-page.component';
import { WishListPageComponent } from './WishListInformation/wish-list-page/wish-list-page.component';
import { AddToBagInformationComponent } from './AddToBagInformation/add-to-bag-information/add-to-bag-information.component';
import { YourOrderPageComponent } from './YourOrderInformation/your-order-page/your-order-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePage,
    ProductPageComponent,
    MensPageComponent,
    LoginPageComponent,
    WomensPageComponent,
    SearchedPageComponent,
    WishListPageComponent,
    AddToBagInformationComponent,
    YourOrderPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
