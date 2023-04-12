import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './HomeSebas/home-page/home-page.component';
import { ProductPageComponent } from './ProductInformation/product-page/product-page.component';
import { MensPageComponent } from './MensInformation/mens-page/mens-page.component';
import { LoginPageComponent } from './LoginForm/login-page/login-page.component';
import { WomensPageComponent } from './WomensInformation/womens-page/womens-page.component';
import { SearchedPageComponent } from './SearchedInformation/searched-page/searched-page.component';
import { WishListPageComponent } from './WishListInformation/wish-list-page/wish-list-page.component';
import { AddToBagInformationComponent } from './AddToBagInformation/add-to-bag-information/add-to-bag-information.component';
import { YourOrderPageComponent } from './YourOrderInformation/your-order-page/your-order-page.component';


const routes: Routes = [
  {
    path: "", redirectTo: "/HomePage", pathMatch: "full"
  },
  {
    path: "HomePage", component: HomePage
  },
  {
    path: "productPage/:id", component: ProductPageComponent
  },
  {
    path: "MensPage", component: MensPageComponent
  },
  {
    path: "WomensPage", component: WomensPageComponent
  },
  {
    path: "LoginPage", component: LoginPageComponent
  },
  {
    path: "SearchedPage/:searchValue", component: SearchedPageComponent
  },
  {
    path: "WishListPage", component: WishListPageComponent
  },
  {
    path: "AddToBagPage", component: AddToBagInformationComponent
  },
  {
    path: "YourOrderPage", component: YourOrderPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
